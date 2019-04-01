package store.os.common.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import store.common.enums.StatusEnum;
import store.common.util.RSAUtils;
import store.user.common.util.PasswordUtils;
import store.user.entity.User;
import store.user.service.IUserService;

/**
 * author  violet
 * createTime 2019/3/25 17:21
 * description
 * version 1.0
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     * 经测试:本例中该方法的调用时机为需授权资源被访问时
     * 经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
     * 比如说这里从数据库获取权限信息时,先去访问Spring3.1提供的缓存,而不使用Shior提供的AuthorizationCache
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
    /**
     * 认证回调函数, 登录时调用
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制
     * 该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        User user = userService.getUserByLoginName(usernamePasswordToken.getUsername());

        if (user == null || user.getEmailIsActive().equals(StatusEnum.NONACTIVATED.getStatus())) {
            System.out.println("UnknownAccountException -- > 没有找到邮箱或者邮箱未被激活");
            throw new UnknownAccountException(); //没有找到邮箱或者邮箱未被激活
        }

        if (user.getStatus().equals(StatusEnum.FREEZE.getStatus())) {
            System.out.println("DisabledAccountException -- > 账户被冻结");
            throw new DisabledAccountException(); //账户被冻结
        }

        AuthorizingUser authorizingUser = new AuthorizingUser();
        BeanUtils.copyProperties(user, authorizingUser);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                authorizingUser, //用户名
                user.getLoginPassword(), //密码
                ByteSource.Util.bytes(authorizingUser.getCredentialSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    /**
     * 重写方法,清除当前用户的的 授权缓存
     *
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     *
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
