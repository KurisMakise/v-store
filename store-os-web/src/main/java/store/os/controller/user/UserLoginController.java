package store.os.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.base.BaseController;
import store.common.constant.CommonReturnCode;
import store.common.exception.ValidationException;
import store.common.util.RSAUtils;
import store.common.util.RegexUtils;
import store.online.common.enums.NavigationBarTypeEnum;
import store.online.entity.NavigationBar;
import store.online.service.IEmailService;
import store.online.service.INavigationBarService;
import store.os.common.result.OsResult;
import store.os.controller.common.util.ServletUtils;
import store.os.controller.common.util.SingletonLoginUtils;
import store.user.common.constant.UserReturnCode;
import store.user.entity.User;
import store.user.entity.UserLoginLog;
import store.user.service.IUserService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * author  violet
 * createTime 2019/3/26 16:23
 * description
 * version 1.0
 */

@Controller
@Api(tags = {"用户登录"})
@RequestMapping("/pass")
public class UserLoginController extends BaseController {


    private final INavigationBarService navigationBarService;

    private final IEmailService emailService;

    private final IUserService userService;

    public UserLoginController(INavigationBarService navigationBarService, IEmailService emailService, IUserService userService) {
        this.navigationBarService = navigationBarService;
        this.emailService = emailService;
        this.userService = userService;
    }

    @ApiOperation("用户登录界面")
    @GetMapping("/login")
    public String login(Model model) {
        Map<String, Object> publicKeyMap = RSAUtils.getPublicKeyMap();
        model.addAttribute("publicKeyMap", publicKeyMap);

        List<NavigationBar> navigationBars = navigationBarService.listByNavigationId(NavigationBarTypeEnum.LOGIN_TOP.getType());
        model.addAttribute(NavigationBarTypeEnum.LOGIN_TOP.getCode(), navigationBars);
        return "/modules/user/user_login";
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestParam String loginName, @RequestParam String loginPassword) {
        //服务器端，使用RSAUtils工具类对密文进行加密
        String password = RSAUtils.decryptStringByJs(loginPassword);
        Subject curryUser = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginName, password);
        usernamePasswordToken.setRememberMe(false); //默认不记住

        try {
            curryUser.login(usernamePasswordToken);
            //日志信息
            UserLoginLog userLoginLog = new UserLoginLog();
            userLoginLog.setLoginTime(new Date());
            userLoginLog.setUserIp(ServletUtils.getIpAddr());
            userLoginLog.setUserId(SingletonLoginUtils.getUserId());
            userLoginLog.setBrowser(ServletUtils.getUserBrowser());
            userLoginLog.setOperatingSystem(ServletUtils.getUserOperatingSystem());
            Integer count = userService.updateLogById( userLoginLog);
            return new OsResult(CommonReturnCode.SUCCESS, count);
        } catch (UnknownAccountException e) {
            logger.error(UserReturnCode.USER_NOT_EXIST.getMessage(), e);
            return new OsResult(UserReturnCode.USER_NOT_EXIST);
        } catch (DisabledAccountException e) {
            logger.error(UserReturnCode.USER_SUSPEND.getMessage(), e);
            return new OsResult(UserReturnCode.USER_SUSPEND, e);
        } catch (IncorrectCredentialsException e) {
            logger.error(UserReturnCode.WRONG_PASSWORD.getMessage(), e);
            return new OsResult(UserReturnCode.WRONG_PASSWORD, e);
        } catch (ExcessiveAttemptsException e) {
            logger.error(UserReturnCode.ACCOUNT_LOCK.getMessage(), e);
            return new OsResult(UserReturnCode.ACCOUNT_LOCK, e);
        } catch (RuntimeException e) {
            logger.error(CommonReturnCode.UNKNOWN.getMessage(), e);
            return new OsResult(CommonReturnCode.UNKNOWN);
        }
    }

    @ApiOperation("完善个人信息")
    @PostMapping("/perfect")
    @ResponseBody
    public Object perfectUser(@RequestParam String email, @RequestParam String realName, @RequestParam String telephone) {
        if (!RegexUtils.isTelephone(telephone)) {
            return new OsResult(CommonReturnCode.BAD_PARAM.getCode(), "请输入正确手机号");
        }
        if (StringUtils.isEmpty(realName)) {
            return new OsResult(CommonReturnCode.BAD_PARAM, "请输入真是姓名");
        }
        if (StringUtils.isEmpty(email)) {
            return new OsResult(CommonReturnCode.BAD_PARAM, "邮箱为空，请联系管理员");
        }
        try {
            Integer count = userService.perfectUser(email, realName, telephone);
            if (count != null && count > 0)
                return new OsResult(CommonReturnCode.SUCCESS, realName);
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
            return new OsResult(e.getCode(), e.getMessage());
        }
        return new OsResult(CommonReturnCode.UNKNOWN);
    }

    @ApiOperation("注册界面")
    @GetMapping("/register")
    public String register(Model model) {
        List<NavigationBar> navigationTop = navigationBarService.listByNavigationId(NavigationBarTypeEnum.LOGIN_TOP.getType());
        model.addAttribute(NavigationBarTypeEnum.LOGIN_TOP.getCode(), navigationTop);
        return "/modules/user/user_register";
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    @ResponseBody
    public Object register(User user, String registerCode) {
        if (!SingletonLoginUtils.validate(registerCode)) {
            return new OsResult(UserReturnCode.REGISTER_CODE_ERROR);
        }
        if (StringUtils.isEmpty(user.getEmail()) || !RegexUtils.isEmail(user.getEmail())) {
            return new OsResult(CommonReturnCode.BAD_PARAM.getCode(), "请输入正确的邮箱");
        }
        if (StringUtils.isEmpty(user.getLoginPassword()) || !RegexUtils.isPassword(user.getLoginPassword())) {
            return new OsResult(UserReturnCode.PASSWORD_AUTHENTICATION_ERROR);
        }
        try {
            userService.insertUser(user);
            return new OsResult(CommonReturnCode.SUCCESS, user.getEmail());
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
            return new OsResult(e.getCode(), e.getMessage());
        }
    }


    @ApiOperation("找回密码页面")
    @GetMapping("/forgetPassword")
    public String forgetPassword(Model model) {
        return "modules/user/user_forget_password";
    }


    @ApiOperation("重置密码")
    @PutMapping("/resetPassword")
    public Object resetPassword(@RequestParam String email, @RequestParam String captcha,
                                @RequestParam String emailSign, @RequestParam String loingPassword) {
        return new OsResult(CommonReturnCode.SUCCESS);
    }

    @ApiOperation("退出登录")
    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:/index";
    }
}
