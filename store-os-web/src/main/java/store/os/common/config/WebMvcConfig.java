package store.os.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import store.os.common.filter.WebSiteMeshFilter;
import store.os.common.intercepter.InterceptorLogin;
import store.os.common.intercepter.InterceptorWeb;

/**
 * @creator violet
 * @createTime 2019/3/6
 * @description
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public InterceptorWeb interceptorWeb() {
        return new InterceptorWeb();
    }

    @Bean
    public InterceptorLogin interceptorLogin() {
        return new InterceptorLogin();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**所有文件夹及里面的子文件夹;/*是所有文件夹，不含子文件夹 */
        registry.addInterceptor(interceptorWeb())
                .addPathPatterns("/index", "/list", "/search", "/detail/*", "/question/askList",
                        "/comment/list", "/buy/checkout", "/buy/confirm", "/cart/*", "/uc/**");
        registry.addInterceptor(interceptorLogin())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/pass/**", "/static/**", "/uploads/**", "/common/**");
    }

    //添加过滤器
    @Bean
    public FilterRegistrationBean filterRegister() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new WebSiteMeshFilter());
        return filter;
    }

    //添加监听
//    @Bean
//    public ServletListenerRegistrationBean listenerRegist() {
//        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
//        srb.setListener(null);
//        return srb;
//    }
}
