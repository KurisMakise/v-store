package store.os.common.config;


import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import store.os.common.security.ShiroRealm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author  violet
 * createTime 2019/3/25 17:09
 * description
 * version 1.0
 */
@Configuration
public class ShiroConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);

    //shiro过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //配置不会被拦截的连接 顺序判断
        filterChainDefinitionMap.put("/", "anon");
        //配置退出过滤器，退出代码Shiro已经实现
        filterChainDefinitionMap.put("/logout", "logout");
        //过滤链定义，从上向下顺序执行，一般将/**放最下面

        //配置记住我过滤器或认证通过可以访问的地址(当上次登录时，记住我以后，在下次访问/或/index时，可以直接访问，不需要登陆)
        filterChainDefinitionMap.put("/index", "user");
        filterChainDefinitionMap.put("/", "user");
        //authc:所有url都必须通过认证才可以访问,anon:所有都可以匿名访问
        filterChainDefinitionMap.put("/**", "authc");

        //不设置会自动寻找Web工程目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录蔡成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    //自定义Realm
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCachingEnabled(true);
        //启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        shiroRealm.setAuthenticationCachingEnabled(true);
        //缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
        shiroRealm.setAuthenticationCacheName("authenticationCache");
        //启用授权缓存，即缓存AuthorizationInfo信息，默认false
        shiroRealm.setAuthorizationCachingEnabled(true);
        //缓存AuthorizationInfo信息的缓存名称  在ehcache-shiro.xml中有对应缓存的配置
        shiroRealm.setAuthorizationCacheName("authorizationCache");
        return shiroRealm;
    }

    //安全管理
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //自定义realm
        securityManager.setRealm(shiroRealm());
        //ehcache缓存
        securityManager.setCacheManager(ehCachemanager());
        //记住我
        securityManager.setRememberMeManager(rememberMeManager());

        //配置自定义session管理
        //securityManager.setSessionManager(sessionManager());

        return securityManager;
    }

    //记住我
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        LOGGER.info("注入Shiro的(CookieRememberMeManager)管理器-->[{}]", CookieRememberMeManager.class);
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度（128 256 512 位），通过以下代码可以获取
        //KeyGenerator keygen = KeyGenerator.getInstance("AES");
        //SecretKey deskey = keygen.generateKey();
        //System.out.println(Base64.encodeToString(deskey.getEncoded()));
        byte[] cipherKey = Base64.decode("HWrBltGvEZc14h9VpMvZWw==");
        cookieRememberMeManager.setCipherKey(cipherKey);
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

//    生成密码
//    public static void main(String[] args) {
//        KeyGenerator keygen = null;
//        try {
//            keygen = KeyGenerator.getInstance("AES");
//            SecretKey deskey = keygen.generateKey();
//            System.out.println(Base64.encodeToString(deskey.getEncoded()));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        //cookie的名称,对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //如果httpOnly设置为true，客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站脚本攻击
        simpleCookie.setHttpOnly(true);
        //记住我cookie生效时间,默认30天，单位秒
        simpleCookie.setMaxAge(60 * 60 * 24 * 30);
        return simpleCookie;
    }

    //缓存
    @Bean
    public EhCacheManager ehCachemanager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:shiro/ehcache-shiro.xml");
        return ehCacheManager;
    }
}
