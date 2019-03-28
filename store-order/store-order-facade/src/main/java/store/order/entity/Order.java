package store.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

@TableName("os_order")
public class Order {
    @TableId
    private Long orderId;

    private Long orderNumber;

    private Long userId;

    private Byte payType;

    private Byte shipmentTime;

    private Byte shipmentType;

    private BigDecimal shipmentAmount;

    private Byte invoiceType;

    private String invoiceTitle;

    private Byte orderStatus;

    private Date createTime;

    private Date updateTime;

    private BigDecimal orderAmount;

    private Integer orderScore;

    private BigDecimal payAmount;

    private Integer buyNumber;

    public Order(Long orderId, Long orderNumber, Long userId, Byte payType, Byte shipmentTime, Byte shipmentType, BigDecimal shipmentAmount, Byte invoiceType, String invoiceTitle, Byte orderStatus, Date createTime, Date updateTime, BigDecimal orderAmount, Integer orderScore, BigDecimal payAmount, Integer buyNumber) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.payType = payType;
        this.shipmentTime = shipmentTime;
        this.shipmentType = shipmentType;
        this.shipmentAmount = shipmentAmount;
        this.invoiceType = invoiceType;
        this.invoiceTitle = invoiceTitle;
        this.orderStatus = orderStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.orderAmount = orderAmount;
        this.orderScore = orderScore;
        this.payAmount = payAmount;
        this.buyNumber = buyNumber;
    }

    public Order() {
        super();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Byte getShipmentTime() {
        return shipmentTime;
    }

    public void setShipmentTime(Byte shipmentTime) {
        this.shipmentTime = shipmentTime;
    }

    public Byte getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(Byte shipmentType) {
        this.shipmentType = shipmentType;
    }

    public BigDecimal getShipmentAmount() {
        return shipmentAmount;
    }

    public void setShipmentAmount(BigDecimal shipmentAmount) {
        this.shipmentAmount = shipmentAmount;
    }

    public Byte getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Byte invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getOrderScore() {
        return orderScore;
    }

    public void setOrderScore(Integer orderScore) {
        this.orderScore = orderScore;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
}