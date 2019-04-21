package store.online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.online.entity.Email;
import store.online.mapper.EmailMapper;
import store.online.service.IEmailService;

/**
 * creator violet
 * createTime 2019/2/27
 * description 邮箱记录
 */
@RestController
@Api("邮件服务")
@RequestMapping("/emailService")
public class EmailServiceImpl implements IEmailService {

    private final EmailMapper emailMapper;

    public EmailServiceImpl(EmailMapper emailMapper) {
        this.emailMapper = emailMapper;
    }


    @Override
    @ApiOperation("获取邮箱")
    @PostMapping("/getEmailBySign")
    public Email getEmailBySign(String emailSign) {
        QueryWrapper<Email> emailQueryWrapper = new QueryWrapper<>();
        emailQueryWrapper.eq("email_sign", emailSign);
        return emailMapper.selectOne(emailQueryWrapper);
    }

    @Override
    @ApiOperation("更新邮箱状态")
    @PostMapping("/updateEmailStatus")
    public Integer updateEmailStatus(Long emailId, Integer status) {
        Email email = new Email();
        email.setEmailId(emailId);
        email.setStatus(status);
        return emailMapper.updateById(email);
    }
}
