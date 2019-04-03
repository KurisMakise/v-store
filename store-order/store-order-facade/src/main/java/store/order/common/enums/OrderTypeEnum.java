package store.order.common.enums;

/**
 * author  violet
 * createTime 2019/3/28 22:05
 * description 订单类型
 * version 1.0
 */
public enum OrderTypeEnum {
    ALL_VALID(1, "1,2,3,4,5,6", "全部有效订单"),
    TO_BE_PAID(2, "1", "待支付"),
    PICKING(3, "2,3,4,5", "待收货"),
    CLOSE(4, "9,10", "已关闭"),
    ALL_ORDER(5, "1,2,3,4,5,6,9,10", "全部订单"),
    UNKNOWN_ORDER(6, "", "未知订单类型");

    private Integer type;

    private String typeValue;

    private String typeInfo;

    OrderTypeEnum(Integer type, String typeValue, String typeInfo) {
        this.type = type;
        this.typeValue = typeValue;
        this.typeInfo = typeInfo;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public static OrderTypeEnum typeOf(Integer type) {
        for (OrderTypeEnum orderType : values()) {
            if (orderType.getType().equals(type)) {
                return orderType;
            }
        }
        return OrderTypeEnum.UNKNOWN_ORDER;
    }
}
