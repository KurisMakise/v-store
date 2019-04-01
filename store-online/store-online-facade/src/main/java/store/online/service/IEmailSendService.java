package store.online.service;

import store.online.pojo.dto.EmailSendResultDTO;

/**
 * creator violet
 * createTime 2019/2/27
 * description 发送验证
 */
public interface IEmailSendService {

    /**
     *
     * @param email 邮箱地址
     * @param userName 用户名
     * @param type 邮箱类型
     * @return 邮件发送结果
     */
    EmailSendResultDTO sendEmailWithVelocity(String email, String userName,Integer type);
}
