package store.online.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("os_email")
public class Email {
    @TableId
    private Long emailId;

    private Long emailSign;

    private String userEmail;

    private Byte emailType;

    private Date createTime;

    private Date startTime;

    private Date endTime;

    private String newEmail;

    private Integer status;

    private Integer sendStatus;

    private String captcha;

    private String emailSubject;

    private String emailContent;

    public Email(Long emailId, Long emailSign, String userEmail, Byte emailType, Date createTime, Date startTime, Date endTime, String newEmail, Integer status, Integer sendStatus, String captcha, String emailSubject) {
        this.emailId = emailId;
        this.emailSign = emailSign;
        this.userEmail = userEmail;
        this.emailType = emailType;
        this.createTime = createTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.newEmail = newEmail;
        this.status = status;
        this.sendStatus = sendStatus;
        this.captcha = captcha;
        this.emailSubject = emailSubject;
    }

    public Email(Long emailId, Long emailSign, String userEmail, Byte emailType, Date createTime, Date startTime, Date endTime, String newEmail, Integer status, Integer sendStatus, String captcha, String emailSubject, String emailContent) {
        this.emailId = emailId;
        this.emailSign = emailSign;
        this.userEmail = userEmail;
        this.emailType = emailType;
        this.createTime = createTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.newEmail = newEmail;
        this.status = status;
        this.sendStatus = sendStatus;
        this.captcha = captcha;
        this.emailSubject = emailSubject;
        this.emailContent = emailContent;
    }

    public Email() {
        super();
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public Long getEmailSign() {
        return emailSign;
    }

    public void setEmailSign(Long emailSign) {
        this.emailSign = emailSign;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Byte getEmailType() {
        return emailType;
    }

    public void setEmailType(Byte emailType) {
        this.emailType = emailType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail == null ? null : newEmail.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject == null ? null : emailSubject.trim();
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent == null ? null : emailContent.trim();
    }
}