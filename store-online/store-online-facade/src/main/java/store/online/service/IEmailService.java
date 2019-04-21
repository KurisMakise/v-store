package store.online.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.online.entity.Email;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
@FeignClient(name = "STORE-ONLINE-SERVICE/emailService")
public interface IEmailService {

    @PostMapping("/getEmailBySign")
    Email getEmailBySign(@RequestParam("emailSign") String emailSign);

    @PostMapping("/updateEmailStatus")
    Integer updateEmailStatus(@RequestParam("emailId") Long emailId,
                              @RequestParam("status") Integer status);

}
