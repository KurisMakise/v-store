package store.order.entity;

import java.util.Date;

public class OrderStatus {
    private Long orderStatusId;

    private Long orderId;

    private Byte orderStatus;

    private Date createTime;

    private String createBy;

    private Byte createStatus;

    private String remarks;

    public OrderStatus(Long orderStatusId, Long orderId, Byte orderStatus, Date createTime, String createBy, Byte createStatus, String remarks) {
        this.orderStatusId = orderStatusId;
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.createTime = createTime;
        this.createBy = createBy;
        this.createStatus = createStatus;
        this.remarks = remarks;
    }

    public OrderStatus() {
        super();
    }

    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Byte getCreateStatus() {
        return createStatus;
    }

    public void setCreateStatus(Byte createStatus) {
        this.createStatus = createStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}