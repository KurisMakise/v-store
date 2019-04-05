package store.common.exception;

/**
 * author  violet
 * createTime 2019/3/27 14:01
 * description 验证异常
 * version 1.0
 */
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = -7743276186979497229L;
    private Integer code;

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ValidationException(ReturnCode returnCode) {
        super(returnCode.getMessage());
        this.code = returnCode.getCode();
    }

    public ValidationException(ReturnCode returnCode, Throwable cause) {
        super(returnCode.getMessage(), cause);
        this.code = returnCode.getCode();
    }

    public ValidationException(String message, Integer code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
