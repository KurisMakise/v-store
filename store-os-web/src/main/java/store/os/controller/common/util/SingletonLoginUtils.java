package store.os.controller.common.util;

import com.google.code.kaptcha.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import store.os.common.security.AuthorizingUser;

/**
 * author  violet
 * createTime 2019/3/25 15:59
 * description 用户登录处理工具
 * version 1.0
 */
public class SingletonLoginUtils {

    private static final Logger logger = LoggerFactory.getLogger(SingletonLoginUtils.class);

    private SingletonLoginUtils() {
        throw new AssertionError();
    }


    /**
     * @return 获取登录用户
     */
    public static AuthorizingUser getUser() {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthorizingUser user = (AuthorizingUser) subject.getPrincipal();
            return user;
        } catch (UnavailableSecurityManagerException e) {
            logger.error("SingletonLoginUtils.getUser{0}", e);
        }
        return null;
    }

    public static Long getUserId() {
        AuthorizingUser authorizingUser = getUser();
        if (authorizingUser == null)
            return null;
        return getUser().getUserId();
    }



    /**
     * @param registerCode 验证码
     * @return 校验结果
     */
    public static boolean validate(String registerCode) {
        // 获取session中验证码
        Object captcha = ServletUtils.getAttribute(Constants.KAPTCHA_SESSION_KEY);

        if (registerCode == null)
            return false;

        boolean result = registerCode.equalsIgnoreCase(captcha.toString());

        if(result)
            ServletUtils.getRequest().getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        return false;
    }
}
