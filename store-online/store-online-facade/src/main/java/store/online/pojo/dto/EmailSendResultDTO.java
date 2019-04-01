package store.online.pojo.dto;

/**
 * author  violet
 * createTime 2019/3/29 15:43
 * description 邮件发送结果
 * version 1.0
 */
public class EmailSendResultDTO {

    private long emailSign;

    private boolean result;

    public EmailSendResultDTO() {
    }

    public EmailSendResultDTO(long emailSign, boolean result) {
        this.emailSign = emailSign;
        this.result = result;
    }

    public long getEmailSign() {
        return emailSign;
    }

    public void setEmailSign(long emailSign) {
        this.emailSign = emailSign;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
