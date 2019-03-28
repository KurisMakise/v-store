package store.common.constant;

import store.common.exception.ReturnCode;

/**
 * author  56925
 * createTime 2019/3/22 16:36
 * description TODO
 * version 1.0
 */
public enum CommonReturnCode implements ReturnCode {
    //请求失败
    FAILED(0, "failed"),
    //请求成功
    SUCCESS(1, "success"),
    UNKNOWN(-1, "未知错误，请联系管理员"),

    OK(200, "请求成功"),
    FREQUENT(207, "频繁操作"),

    LOGIN_FAIL(303, "登录失败"),

    BAD_PARAM(400, "请求参数错误"),
    UNAUTHORIZED(401, "您未登录或者登录超时，请先登录"),
    FORBIDDEN(403, "没有操作权限"),
    NOT_FOUND(404, "找不到页面"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "发生冲突"),
    GONE(410, "页面已被删除"),
    LOCKED(423, "页面已经被锁定"),

    INTERNAL_SERVER_ERROR(500, "服务器内部错误");


    CommonReturnCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //状态码
    private int code;
    //返回消息
    private String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
