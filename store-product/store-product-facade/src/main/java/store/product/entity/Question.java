package store.product.entity;

import java.util.Date;

public class Question {
    private Long questionId;

    private Long productId;

    private Long userId;

    private String userName;

    private String picImg;

    private String content;

    private Integer goodCount;

    private Byte status;

    private Date createTime;

    private String createBy;

    private String answerContent;

    private String answerBy;

    private Date answerTime;

    private Byte type;

    private String updateBy;

    private Date updateTime;

    public Question(Long questionId, Long productId, Long userId, String userName, String picImg, String content, Integer goodCount, Byte status, Date createTime, String createBy, String answerContent, String answerBy, Date answerTime, Byte type, String updateBy, Date updateTime) {
        this.questionId = questionId;
        this.productId = productId;
        this.userId = userId;
        this.userName = userName;
        this.picImg = picImg;
        this.content = content;
        this.goodCount = goodCount;
        this.status = status;
        this.createTime = createTime;
        this.createBy = createBy;
        this.answerContent = answerContent;
        this.answerBy = answerBy;
        this.answerTime = answerTime;
        this.type = type;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public Question() {
        super();
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent == null ? null : answerContent.trim();
    }

    public String getAnswerBy() {
        return answerBy;
    }

    public void setAnswerBy(String answerBy) {
        this.answerBy = answerBy == null ? null : answerBy.trim();
    }

    public Date getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}