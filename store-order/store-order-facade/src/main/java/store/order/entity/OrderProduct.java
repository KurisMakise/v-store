package store.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

@TableName("os_order_product")
public class OrderProduct {
    @TableId
    private Long orderProductId;

    private Long orderId;

    private Long productNumber;

    private String name;

    private String picImg;

    private Long productSpecNumber;

    private String productSpecName;

    private BigDecimal price;

    private Integer score;

    private Integer buyNumber;

    private Integer productScore;

    private BigDecimal productAmount;

    private Byte commentStatus;

    public OrderProduct(Long orderProductId, Long orderId, Long productNumber, String name, String picImg, Long productSpecNumber, String productSpecName, BigDecimal price, Integer score, Integer buyNumber, Integer productScore, BigDecimal productAmount, Byte commentStatus) {
        this.orderProductId = orderProductId;
        this.orderId = orderId;
        this.productNumber = productNumber;
        this.name = name;
        this.picImg = picImg;
        this.productSpecNumber = productSpecNumber;
        this.productSpecName = productSpecName;
        this.price = price;
        this.score = score;
        this.buyNumber = buyNumber;
        this.productScore = productScore;
        this.productAmount = productAmount;
        this.commentStatus = commentStatus;
    }

    public OrderProduct() {
        super();
    }

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
    }

    public Long getProductSpecNumber() {
        return productSpecNumber;
    }

    public void setProductSpecNumber(Long productSpecNumber) {
        this.productSpecNumber = productSpecNumber;
    }

    public String getProductSpecName() {
        return productSpecName;
    }

    public void setProductSpecName(String productSpecName) {
        this.productSpecName = productSpecName == null ? null : productSpecName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Integer getProductScore() {
        return productScore;
    }

    public void setProductScore(Integer productScore) {
        this.productScore = productScore;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public Byte getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Byte commentStatus) {
        this.commentStatus = commentStatus;
    }
}