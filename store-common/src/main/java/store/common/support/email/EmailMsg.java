package store.common.support.email;

import java.util.Date;
import java.util.Map;

/**
 * author  violet
 * createTime 2019/3/29 14:26
 * description 邮箱信息
 * version 1.0
 */
public class EmailMsg {
    /**
     * 收件人邮箱，多个邮箱以“,”分隔
     */
    private String toEmails;

    /**
     * 抄送人人邮箱，多个邮箱以“,”分隔
     */
    private String ccEmails;

    /**
     * 邮箱标题
     */
    private String subject;

    /**
     * 正文内容
     */
    private String content;

    /**
     * velocity模版
     */
    private String velocityTemplate;

    /**
     * 声明Map对象，并填入用来填充模板文件的键值对
     */
    private Map<String, Object> model;

    /**
     * 邮件中的图片，为空时无图片。map中的key为图片ID，value为图片地址
     */
    private Map<String, String> pictures;

    /**
     * 邮件中的附件，为空时无附件。map中的key为附件ID，value为附件地址
     */
    private Map<String, String> attachments;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;

    /**
     * 发送时间
     */
    private Date sendTime;

    /**
     * 1 已发送 2 未发送
     */
    private Integer status;

    /**
     * 1 正常 2 定时
     */
    private Integer type;

    /**
     * 发件人昵称
     */
    private String fromName;

    public String getToEmails() {
        return toEmails;
    }

    public void setToEmails(String toEmails) {
        this.toEmails = toEmails;
    }

    public String getCcEmails() {
        return ccEmails;
    }

    public void setCcEmails(String ccEmails) {
        this.ccEmails = ccEmails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVelocityTemplate() {
        return velocityTemplate;
    }

    public void setVelocityTemplate(String velocityTemplate) {
        this.velocityTemplate = velocityTemplate;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public Map<String, String> getPictures() {
        return pictures;
    }

    public void setPictures(Map<String, String> pictures) {
        this.pictures = pictures;
    }

    public Map<String, String> getAttachments() {
        return attachments;
    }

    public void setAttachments(Map<String, String> attachments) {
        this.attachments = attachments;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }
}
