package store.online.common.enums;

/**
 * author  violet
 * createTime 2019/3/29 14:58
 * description
 * version 1.0
 */
public enum EmailSendStatusEnum {
    SUCCESS("成功", true, 0),
    FAILURE("失败", false, 1);

    private String stateInfo;
    private Boolean result;
    private Integer status;

    EmailSendStatusEnum(String stateInfo, Boolean result, Integer status) {
        this.stateInfo = stateInfo;
        this.result = result;
        this.status = status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public Boolean getResult() {
        return result;
    }

    public Integer getStatus() {
        return status;
    }

    public static EmailSendStatusEnum resultOf(Boolean result) {
        for (EmailSendStatusEnum statusEnum : values()) {
            if (result == statusEnum.getResult())
                return statusEnum;
        }
        return EmailSendStatusEnum.FAILURE;
    }
}
