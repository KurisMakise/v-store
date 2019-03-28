package store.online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import store.online.entity.Email;
import store.online.mapper.EmailMapper;
import store.online.service.IEmailService;

/**
 * creator violet
 * createTime 2019/2/27
 * description 邮箱记录
 */
@Service
public class EmailServiceImpl implements IEmailService {

    private final EmailMapper emailMapper;

    public EmailServiceImpl(EmailMapper emailMapper) {
        this.emailMapper = emailMapper;
    }


    @Override
    public Email getEmailBySign(String emailSign) {
        QueryWrapper<Email> emailQueryWrapper = new QueryWrapper<>();
        emailQueryWrapper.eq("email_sign", emailSign);
        return emailMapper.selectOne(emailQueryWrapper);
    }

    @Override
    public Integer updateEmailStatus(Long emailId, Integer status) {
        Email email = new Email();
        email.setEmailId(emailId);
        email.setStatus(status);
        return emailMapper.updateById(email);
    }
}
