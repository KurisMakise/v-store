package store.online.service;

import store.online.entity.Email;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
public interface IEmailService {

    Email getEmailBySign(String emailSign);

    Integer updateEmailStatus(Long emailId, Integer status);

}
