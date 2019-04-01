package store.online.common.enums;

/**
 * author  violet
 * createTime 2019/3/29 14:30
 * description 邮箱操作类型
 * version 1.0
 */
public enum EmailTypeEnum {

    FORGET(0, "找回密码", "帐号完全认证", "PswCaptcha.vm"),
    REGISTER(1, "邮箱注册", "很高兴遇见你！", "EmailCaptcha.vm"),
    CHANGE(2, "邮箱更改", "邮箱认证验证", "PswCaptcha.vm"),
    INFORM(3, "通知", "自定义", "null"),
    UNKNOWN_TYPE(4, "未知type类型", "未知type类型", "null");

    private Integer type;

    private String typeInfo;

    private String emailSubject;

    private String velocityTemplate;

    EmailTypeEnum(Integer type, String typeInfo, String emailSubject, String velocityTemplate) {
        this.type = type;
        this.typeInfo = typeInfo;
        this.emailSubject = emailSubject;
        this.velocityTemplate = velocityTemplate;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public String getVelocityTemplate() {
        return velocityTemplate;
    }

    public static EmailTypeEnum typeOf(int type) {
        for (EmailTypeEnum emailType : values()) {
            if (emailType.getType() == type)
                return emailType;
        }
        return EmailTypeEnum.UNKNOWN_TYPE;
    }
}
