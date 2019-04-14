package store.common.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import store.common.annotation.RedisCache;
import store.common.annotation.RedisCacheEvict;
import store.common.base.BaseResult;
import store.common.util.RandomUtils;
import store.common.util.SpringContextUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * redis缓存切面
 * 将带有@RedisCache注解的方法缓存
 * 根据 (类名.方法名:参数类型 参数值) 作为key保存查询结果到redis
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/13 23:52
 */

@Component
@Aspect
public class RedisCacheAspect {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(store.common.annotation.RedisCache)")
    public void cachePointCut() {
    }

    @Pointcut("@annotation(store.common.annotation.RedisCacheEvict)")
    public void cacheEvictPointCut() {
    }

    /**
     * 缓存查询数据
     */
    @Around("cachePointCut()")
    public Object cache(ProceedingJoinPoint proceedingJoinPoint) {
        //类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        //方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        //方法参数
        Object[] args = proceedingJoinPoint.getArgs();

        //获取方法标签
        MethodSignature methodSignature = ((MethodSignature) proceedingJoinPoint.getSignature());
        //获取方法注解
        RedisCache redisCacheAnnotation = methodSignature.getMethod().getAnnotation(RedisCache.class);
        //注解类型
        Class<?> annotationType = redisCacheAnnotation.type();

        //缓存key
        String key = genKey(className, methodName, args);
        redisTemplate.opsForHash().delete(annotationType.getName(), key);
        //查询缓存
        String jsonCache = (String) redisTemplate.opsForHash().get(annotationType.getName(), key);

        //命中缓存
        if (jsonCache != null)
            return deserialize(jsonCache, methodSignature.getReturnType(), annotationType);

        //未命中缓存
        Object proceed = null;
        try {
            //不检查返回值是否为空，将空值也缓存，防止为空情况一直查询数据库，
            proceed = proceedingJoinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //查询结果序列化
        String value = JSON.toJSONString(proceed);
        //缓存查询结果
        redisTemplate.opsForHash().put(annotationType.getName(), key, value);

        //获取失效时间
        long timeout = redisCacheAnnotation.expire();
        //获取时间单位
        TimeUnit timeUnit = redisCacheAnnotation.timeUnit();
        //时间单位转为秒
        long toSeconds = timeUnit.toSeconds(timeout);

        //是否增加随机缓存时间
        boolean randomBool = redisCacheAnnotation.random();
        if (randomBool) {
            //给缓存增加随机时间防止缓存同时失效
            Random random = new Random();
            toSeconds = toSeconds + random.nextInt(500);
        }

        redisTemplate.expire(annotationType.getName(), toSeconds, TimeUnit.SECONDS);

        return proceed;
    }

    /**
     * 更新缓存
     * 1、根据key获取hash，保存hashkey
     * 2、根据key删除hash
     * 3、根据保存的hashkey更新缓存
     */

    @Around("cacheEvictPointCut()")
    public Object cacheEvict(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = null;
        //删除数据库,不捕获异常
        proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());

        //获取方法标签
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        //获取方法注解
        RedisCacheEvict redisCacheEvict = methodSignature.getMethod().getAnnotation(RedisCacheEvict.class);

        //注解缓存类型
        Class type = redisCacheEvict.type();

        Set<Object> keys = redisTemplate.opsForHash().keys(type.getName());
        //删除缓存
        redisTemplate.opsForHash().delete(type.getName(), keys);

        //更新缓存
//        for (Object key : keys) {
//            //根据key获取类，方法名，参数
//            String[] params = String.valueOf(key).split(":");
//
//            String className = params[0].substring(0, params[0].lastIndexOf("."));
//            String methodName = params[0].substring(params[0].lastIndexOf(".") + 1);
//            String[] args = params[1].split(",");
//            Object[] argsObj = new Object[args.length];
//            for (int i = 0; i < args.length; i++) {
//                args[i] = args[i].split("\\s")[1];
//            }
//
//            Class<?> aClass = Class.forName(className);
//            Object bean = SpringContextUtils.getBean(aClass);
//            Method method = bean.getClass().getMethod(methodName);
//            method.invoke(bean, argsObj);
//        }
        return proceed;
    }


    /**
     * @param className  类名
     * @param methodName 方法名
     * @param args       方法参数
     * @return 缓存key
     */
    private String genKey(String className, String methodName, Object[] args) {
        StringBuilder sb = new StringBuilder(className + "." + methodName + ":");
        for (Object arg : args) {
            sb.append(arg.getClass().getName()).append(" ").append(arg.toString()).append(",");
        }
        return sb.toString();
    }

    /**
     * @param jsonString     序列化字符串
     * @param returnType     缓存方法返回类型
     * @param annotationType 注解中类
     * @return 反序列化结果
     */
    private Object deserialize(String jsonString, Class<?> returnType, Class<?> annotationType) {
        // 序列化结果应该是List对象
        if (returnType.isAssignableFrom(List.class)) {
            return JSON.parseArray(jsonString, annotationType);
        }
        // 序列化结果是普通对象
        return JSON.parseObject(jsonString, returnType);
    }

}
