package store.user.common.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import store.common.util.RandomUtils;


public class PasswordUtils {

    /**
     * 迭代次数
     */
    private static final int ITERATIONS = 6;
    /**
     * 盐值数位
     */
    private static final int SALT_NUMBER = 6;

    private PasswordUtils() {
        throw new AssertionError();
    }

    /**
     * 字符串加密函数MD5实现
     *
     * @param password   密码
     * @param userNumber 用户编号
     * @param salt       盐值
     * @return 加密结果
     */
    public static String getMd5(String password, Long userNumber, String salt) {
        return new Md5Hash(password, getCredentialsSalt(userNumber, salt), ITERATIONS).toString();
    }

    /**
     * 证书凭证
     */
    public static String getCredentialsSalt(Long userNumber, String salt) {
        return userNumber + salt;
    }

    /**
     * 获得密码盐值
     */
    public static String getSalt() {
        return RandomUtils.getString(SALT_NUMBER);
    }

}
