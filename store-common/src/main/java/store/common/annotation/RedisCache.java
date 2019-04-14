package store.common.annotation;

import store.common.base.BaseController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * redis缓存
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/13 23:51
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RedisCache {
    /**
     * 缓存数据类型
     */
    Class type();

    /**
     * 默认过期时间
     */
    long expire() default 7L;

    /**
     * 时间单位
     */
    TimeUnit timeUnit() default TimeUnit.DAYS;

    /**
     * 是否增加随机时间
     */
    boolean random() default true;
}
