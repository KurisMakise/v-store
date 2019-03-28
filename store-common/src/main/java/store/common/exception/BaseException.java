package store.common.exception;

/**
 * author  violet
 * createTime 2019/3/27 14:01
 * description 统一异常
 * version 1.0
 */
public class BaseException extends RuntimeException {

    public BaseException() {
        super();
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
