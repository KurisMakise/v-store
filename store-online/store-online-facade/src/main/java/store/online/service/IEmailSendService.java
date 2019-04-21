package store.online.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.online.pojo.dto.EmailSendResultDTO;

/**
 * creator violet
 * createTime 2019/2/27
 * description 发送验证
 */
@FeignClient(name = "store-online-service/emailSendService")
public interface IEmailSendService {

    /**
     *
     * @param email 邮箱地址
     * @param userName 用户名
     * @param type 邮箱类型
     * @return 邮件发送结果
     */
    @PostMapping("/sendEmailWithVelocity")
    EmailSendResultDTO sendEmailWithVelocity(@RequestParam("email") String email,
                                             @RequestParam("userName") String userName,
                                             @RequestParam("type") Integer type);
}
