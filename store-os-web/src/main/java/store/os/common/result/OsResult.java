package store.os.common.result;

import store.common.base.BaseResult;
import store.common.exception.ReturnCode;

/**
 * author  56925
 * createTime 2019/3/22 15:19
 * description TODO
 * version 1.0
 */
public class OsResult extends BaseResult {

    public OsResult(Integer code, String message) {
        super(code, message);
    }

    public OsResult(ReturnCode returnCode, Object data) {
        super(returnCode.getCode(), returnCode.getMessage(), data);
    }

    public OsResult(ReturnCode returnCode) {
        super(returnCode.getCode(), returnCode.getMessage());
    }

}
