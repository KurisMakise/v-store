package store.os.common.security;

/**
 * author  violet
 * createTime 2019/3/25 9:27
 * description
 * version 1.0
 */
public class AuthorizingUser {
    //用户ID
    private Long userId;

    //用户编号
    private Long userNumber;

    //用户名
    private String userName;

    //真实姓名
    private String realName;

    //电话
    private String telephone;

    //邮箱
    private String email;

    //加密
    private String salt;

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
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCredentialSalt() {
        if (this.userNumber != null && this.salt != null) {
            return this.userNumber + this.salt;
        }
        return null;
    }
}
