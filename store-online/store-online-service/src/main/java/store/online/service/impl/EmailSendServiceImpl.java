package store.online.service.impl;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.common.enums.StatusEnum;
import store.common.support.email.EmailMsg;
import store.common.support.email.EmailSendManager;
import store.common.util.DateUtils;
import store.online.common.enums.EmailReturnCode;
import store.online.common.enums.EmailSendStatusEnum;
import store.online.common.enums.EmailTypeEnum;
import store.online.common.util.EmailUtils;
import store.online.entity.Email;
import store.online.mapper.EmailMapper;
import store.online.pojo.dto.EmailSendResultDTO;
import store.online.service.IEmailSendService;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
@RestController
@Api(tags = {"邮件发送服务"})
@RequestMapping("/emailSendService")
public class EmailSendServiceImpl implements IEmailSendService {

    private final EmailMapper emailMapper;

    public EmailSendServiceImpl(EmailMapper emailMapper) {
        this.emailMapper = emailMapper;
    }

    @Override
    @ApiOperation("发送验证码")
    @PostMapping("/sendEmailWithVelocity")
    public EmailSendResultDTO sendEmailWithVelocity(String email, String userName, Integer type) {
        Date startTime = new Date(); // 发送时间
        Date endTime = DateUtils.getOffsiteDate(startTime, Calendar.MINUTE, EmailUtils.getCaptchaTime());// 验证时间向后偏移3分钟
        String captcha = EmailUtils.getCaptcha(); // 验证码

        Map<String, Object> model = new HashMap<>();
        model.put("createTime", startTime);
        model.put("captcha", captcha);
        model.put("email", email);
        model.put("userName", userName);
        model.put("userDate", new Date());

        EmailMsg emailMsg = new EmailMsg();
        emailMsg.setToEmails(email); // 收件人
        emailMsg.setSubject(EmailTypeEnum.typeOf(type).getEmailSubject());// 邮件主题
        emailMsg.setVelocityTemplate(EmailTypeEnum.typeOf(type).getVelocityTemplate());// 模版
        emailMsg.setModel(model);// 邮件正文

        EmailSendManager emailSendManager = new EmailSendManager();
        boolean result = emailSendManager.sendMail(emailMsg);
        Email emailRecord = new Email();

        emailRecord.setEmailSign(EmailUtils.getEmailSign());
        emailRecord.setUserEmail(email);
        emailRecord.setEmailType(EmailTypeEnum.typeOf(type).getType().byteValue());
        emailRecord.setStartTime(startTime);
        emailRecord.setEndTime(endTime);
        emailRecord.setCreateTime(startTime);

        emailRecord.setSendStatus(EmailSendStatusEnum.resultOf(result).getStatus());
        emailRecord.setCaptcha(captcha);
        emailRecord.setEmailSubject(EmailTypeEnum.typeOf(type).getEmailSubject());
        emailRecord.setEmailContent(JSON.toJSON(model).toString());
        emailRecord.setStatus(StatusEnum.ACTIVATED.getStatus());

        emailMapper.insert(emailRecord);
        return new EmailSendResultDTO(emailRecord.getEmailSign(), result);
    }
}
