package store.user.entity;

import java.util.Date;

public class User {
    private Long userId;

    private Long userNumber;

    private String userName;

    private String loginPassword;

    private String salt;

    private String realName;

    private Integer sex;

    private Byte age;

    private String picImg;

    private Integer status;

    private Integer emailIsActive;

    private String email;

    private String telephone;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Long loginNumber;

    private Date registerTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Long amount;

    private Long rankId;

    private Integer score;

    public User(Long userId, Long userNumber, String userName, String loginPassword, String salt, String realName, Integer sex, Byte age, String picImg, Integer status, Integer emailIsActive, String email, String telephone, Date lastLoginTime, String lastLoginIp, Long loginNumber, Date registerTime, String createBy, Date updateTime, String updateBy, Long amount, Long rankId, Integer score) {
        this.userId = userId;
        this.userNumber = userNumber;
        this.userName = userName;
        this.loginPassword = loginPassword;
        this.salt = salt;
        this.realName = realName;
        this.sex = sex;
        this.age = age;
        this.picImg = picImg;
        this.status = status;
        this.emailIsActive = emailIsActive;
        this.email = email;
        this.telephone = telephone;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.loginNumber = loginNumber;
        this.registerTime = registerTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.amount = amount;
        this.rankId = rankId;
        this.score = score;
    }

    public User() {
        super();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEmailIsActive() {
        return emailIsActive;
    }

    public void setEmailIsActive(Integer emailIsActive) {
        this.emailIsActive = emailIsActive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Long getLoginNumber() {
        return loginNumber;
    }

    public void setLoginNumber(Long loginNumber) {
        this.loginNumber = loginNumber;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}