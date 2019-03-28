package store.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("os_user_login_log")
public class UserLoginLog {
    @TableId
    private Long logId;

    private Date loginTime;

    private String userIp;

    private Long userId;

    private String operatingSystem;

    private String browser;

    public UserLoginLog(Long logId, Date loginTime, String userIp, Long userId, String operatingSystem, String browser) {
        this.logId = logId;
        this.loginTime = loginTime;
        this.userIp = userIp;
        this.userId = userId;
        this.operatingSystem = operatingSystem;
        this.browser = browser;
    }

    public UserLoginLog() {
        super();
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem == null ? null : operatingSystem.trim();
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }
}