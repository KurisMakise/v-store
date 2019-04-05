package store.common.enums;

/**
 * <p>
 * 数据库排序枚举
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/4 14:34
 */
public enum OrderSortEnum {
    ASC("asc","升序"),

    DESC("desc","降序");

    private String order;

    private String orderInfo;

    OrderSortEnum(String order, String orderInfo) {
        this.order = order;
        this.orderInfo = orderInfo;
    }

    public String getOrder() {
        return order;
    }

    public String getOrderInfo() {
        return orderInfo;
    }


}
