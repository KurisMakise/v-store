package store.online.common.enums;

import store.common.exception.ReturnCode;

/**
 * author  violet
 * createTime 2019/3/27 18:49
 * description
 * version 1.0
 */
public enum EmailReturnCode implements ReturnCode {

    EMAIL_FORMAT_ERROR(2001, "电子邮箱格式不正确"),
    EMAIL_NOT_EXIST(2002, "电子邮箱地址不正确"),
    SEND_EMAIL_NOT_EXIST(2003, "邮件不存在"),
    CAPTCHA_OVERDUE(2004, "验证码过期，请重新输入验证码"),
    CAPTCHA_ERROR(2005, "验证码错误，请重新输入"),
    EMAIL_INVALID(2006, "验证地址失效");

    private int code;

    private String message;

    EmailReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
