package store.common.exception;

/**
 * author  violet
 * createTime 2019/3/27 14:02
 * description
 * version 1.0
 */
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ReturnCode returnCode, Throwable cause) {
        super(returnCode.getMessage(), cause);
        this.code = returnCode.getCode();
    }

    public BusinessException(String message, Integer code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
