package store.common.util;

import com.alibaba.fastjson.JSON;

/**
 * <p>
 * TODO
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/21 20:42
 */
public class JSONUtil {

    public static <T> T parseObject(Object obj, Class<T> t) {
        return JSON.parseObject(JSON.toJSONString(obj), t);
    }
}
