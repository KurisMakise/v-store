package store.order.common.enums;

/**
 * author  violet
 * createTime 2019/3/23 20:44
 * description 订单状态
 * version 1.0
 */
public enum OrderStatusEnum {

    SUBMIT_ORDERS(1, "订单提交"),

    PAY_COMPLETE(2, "支付完成"),

    PICKING(3, "配货完成"),

    OUTBOUND_GOODS(4, "商品出库"),

    WAITS_FOR_DELIVERY(5, "等待收货"),

    TAKE_DELIVERY(6, "确认收货"),

    AUTOMATICALLY_CANCEL_ORDER(9, "自动取消订单"),

    MANUALLY_CANCEL_ORDER(10, "手动取消订单");


    private Integer status;

    private String statusInfo;

    OrderStatusEnum(Integer status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }
}
