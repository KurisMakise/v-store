package store.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import store.common.exception.ValidationException;
import store.user.entity.User;
import store.user.entity.UserLoginLog;
import store.user.pojo.vo.UserVO;

/**
 * author  violet
 * createTime 2019/3/26 15:25
 * description
 * version 1.0
 */
@FeignClient(name = "STORE-USER-SERVICE/userService")
public interface IUserService {

    @PostMapping("/perfectUser")
    Integer perfectUser(@RequestParam("email") String email,
                        @RequestParam("realName") String realName,
                        @RequestParam("telephone") String telephone) throws ValidationException;

    @PostMapping("/getByLoginName")
    User getByLoginName(@RequestParam("loginName") String loginName);

    @PostMapping("/getUserVOById")
    UserVO getUserVOById(@RequestParam("userId") Long userId);

    @PostMapping("/updatePasswordByEmail")
    Integer updatePasswordByEmail(@RequestParam("password") String password,
                                  @RequestParam("email") String email);

    @PostMapping("/activeEmail")
    Integer activeEmail(@RequestParam("email") String email);

    @PostMapping("/getUserByLoginName")
    User getUserByLoginName(@RequestParam("loginName") String loginName);

    @PostMapping("/updateLogById")
    Integer updateLogById(@RequestBody UserLoginLog userLoginLog);

    @PostMapping("/insertUser")
    Integer insertUser(@RequestBody User user);
}
