package store.user.common.constant;

import store.common.exception.ReturnCode;

/**
 * author  violet
 * createTime 2019/3/26 18:41
 * description
 * version 1.0
 */
public enum UserReturnCode implements ReturnCode {

    USER_NOT_EXIST(100, "该帐号不存在"),
    USER_SUSPEND(101, "帐号已被冻结"),
    WRONG_PASSWORD(102, "您输入的密码不正确！"),
    ACCOUNT_LOCK(104, "输入密码连续错误超过5次，锁定半小时"),
    REGISTER_CODE_ERROR(105, "验证码错误"),
    ENTERED_PASSWORDS_DIFFER(106, "两次输入密码不一致"),
    PASSWORD_AUTHENTICATION_ERROR(107, "密码长度8~16位，必须包含字符和数字"),
    ACCOUNT_ERROR(108, "帐号已存在");

    //返回状态码
    private int code;
    //返回消息
    private String message;

    UserReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
