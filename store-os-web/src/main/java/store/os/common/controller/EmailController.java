package store.os.common.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import store.common.constant.CommonReturnCode;
import store.common.enums.StatusEnum;
import store.common.util.RegexUtils;
import store.online.common.enums.EmailReturnCode;
import store.online.common.enums.EmailTypeEnum;
import store.online.entity.Email;
import store.online.pojo.dto.EmailSendResultDTO;
import store.online.service.IEmailSendService;
import store.online.service.IEmailService;
import store.os.common.result.OsResult;
import store.user.entity.User;
import store.user.service.IUserService;

import java.util.Date;

/**
 * author  violet
 * createTime 2019/3/29 8:38
 * description 邮箱验证
 * version 1.0
 */
@Api(tags = {"邮箱"})
@Controller
@RequestMapping("/pass")
public class EmailController {
    @Autowired
    private IEmailService emailService;
    @Autowired
    private IEmailSendService emailSendService;
    @Autowired
    private IUserService userService;


    @ApiOperation("找回密码")
    @PutMapping("/email/retrieve")
    @ResponseBody
    public Object sendEmailTicket(@RequestParam String email) {
        return sendEmail(email, EmailTypeEnum.FORGET.getType());
    }

    @ApiOperation("邮箱注册")
    @PostMapping("/email/register")
    @ResponseBody
    public Object sendEmailRegister(@RequestParam String email) {
        return sendEmail(email, EmailTypeEnum.REGISTER.getType());
    }

    private OsResult sendEmail(String email, Integer type) {
        if (!RegexUtils.isEmail(email)) {
            return new OsResult(EmailReturnCode.EMAIL_FORMAT_ERROR);
        }
        User user = userService.getUserByLoginName(email);
        if (user == null) {
            return new OsResult(EmailReturnCode.SEND_EMAIL_NOT_EXIST);
        }
        EmailSendResultDTO emailSendResultDTO = emailSendService.sendEmailWithVelocity(email, user.getUserName(), type);

        if (emailSendResultDTO.isResult()) {
            return new OsResult(CommonReturnCode.SUCCESS, emailSendResultDTO.getEmailSign());
        } else {
            return new OsResult(CommonReturnCode.UNKNOWN);
        }
    }

    @ApiOperation("邮箱验证")
    @PostMapping("/email/verify")
    @ResponseBody
    public Object verifyEmail(@RequestParam String email, @RequestParam String captcha, @RequestParam String emailSign) {
        Email emailBySign = emailService.getEmailBySign(emailSign);
        if (emailBySign == null) {
            return new OsResult(EmailReturnCode.SEND_EMAIL_NOT_EXIST);
        }
        if (!emailBySign.getCaptcha().equals(captcha)) {
            return new OsResult(EmailReturnCode.CAPTCHA_ERROR);//验证码错误
        }
        if (!emailBySign.getUserEmail().equals(email)) {
            return new OsResult(EmailReturnCode.EMAIL_NOT_EXIST);//邮箱不匹配
        }
        if (new Date().after(emailBySign.getEndTime())) {
            return new OsResult(EmailReturnCode.CAPTCHA_OVERDUE);//超时
        }
        if (emailBySign.getStatus().equals(StatusEnum.INVALID.getStatus())) {
            return new OsResult(EmailReturnCode.EMAIL_INVALID);//失效
        }
        //激活帐号
        Integer count = emailService.updateEmailStatus(emailBySign.getEmailId(), StatusEnum.ACTIVATED.getStatus());
        //激活帐号
        userService.activeEmail(email);
        //更新链接已失效
        emailService.updateEmailStatus(emailBySign.getEmailId(), StatusEnum.INVALID.getStatus());
        return new OsResult(CommonReturnCode.SUCCESS, count);
    }

}
