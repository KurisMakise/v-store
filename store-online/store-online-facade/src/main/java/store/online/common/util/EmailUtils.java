package store.online.common.util;

import store.common.util.RandomUtils;

import java.util.Date;

/**
 * author  violet
 * createTime 2019/3/29 14:11
 * description
 * version 1.0
 */
public class EmailUtils {

    /**
     * 验证码长度
     */
    private static final int CAPTCHA_LENGTH = 6;

    /**
     * 验证码时长（分钟）
     */
    private static final int CAPTCHA_TIME = 6;

    /**
     * 邮箱标识后缀
     */
    private static final int SUFFIX_SIGN = 3;

    private EmailUtils() {
        throw new AssertionError();
    }

    /**
     * 获取验证码
     */
    public static String getCaptcha() {
        return RandomUtils.getString(CAPTCHA_LENGTH);
    }

    /**
     * @return 验证码有效时间
     */
    public static int getCaptchaTime() {
        return CAPTCHA_TIME;
    }

    /**
     * @return 邮箱编号
     */
    public static Long getEmailSign() {
        String prefix = Long.toString(new Date().getTime());
        String suffix = RandomUtils.number(SUFFIX_SIGN);
        return Long.valueOf(prefix + suffix);
    }

}
