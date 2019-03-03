package store.product.entity;

import java.util.Date;

public class Comment {
    private Long commentId;

    private Long productId;

    private Long userId;

    private String userName;

    private String picImg;

    private Long orderId;

    private Byte star;

    private String content;

    private Integer goodCount;

    private Byte status;

    private Byte type;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Comment(Long commentId, Long productId, Long userId, String userName, String picImg, Long orderId, Byte star, String content, Integer goodCount, Byte status, Byte type, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.commentId = commentId;
        this.productId = productId;
        this.userId = userId;
        this.userName = userName;
        this.picImg = picImg;
        this.orderId = orderId;
        this.star = star;
        this.content = content;
        this.goodCount = goodCount;
        this.status = status;
        this.type = type;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public Comment() {
        super();
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Byte getStar() {
        return star;
    }

    public void setStar(Byte star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}