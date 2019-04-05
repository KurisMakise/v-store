package store.os.common.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import store.os.common.security.AuthorizingUser;
import store.os.controller.common.util.ServletUtils;
import store.os.controller.common.util.SingletonLoginUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * creator violet
 * createTime 2019/3/6
 * description
 */
public class InterceptorLogin implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //认证用户放入request中
        System.out.println(request.getRequestURL());
        AuthorizingUser authorizingUser = SingletonLoginUtils.getUser();
        request.setAttribute("user", authorizingUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
