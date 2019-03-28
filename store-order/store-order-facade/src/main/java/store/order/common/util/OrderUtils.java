package store.order.common.util;

import store.common.util.RandomUtils;

import java.util.Date;

/**
 * author  violet
 * createTime 2019/3/23 20:06
 * description  订单通用操作方法
 * version 1.0
 */
public class OrderUtils {

    //订单编号后缀位数
    private static final int SUFFIX_NUMBER = 4;

    private OrderUtils() {
        throw new AssertionError();
    }


    public static Long getOrderNumber() {
        String prefixNumber = Long.toString(new Date().getTime());
        String suffixNumber = RandomUtils.number(SUFFIX_NUMBER);
        return Long.valueOf(prefixNumber + suffixNumber);
    }

}


