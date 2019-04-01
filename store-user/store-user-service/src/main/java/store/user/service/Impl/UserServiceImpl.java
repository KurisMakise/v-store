package store.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;
import store.common.constant.CommonReturnCode;
import store.common.enums.StatusEnum;
import store.common.exception.ValidationException;
import store.user.common.util.PasswordUtils;
import store.user.common.util.UserUtils;
import store.user.entity.User;
import store.user.entity.UserLoginLog;
import store.user.mapper.UserMapper;
import store.user.pojo.vo.UserVO;
import store.user.service.IUserService;

import java.util.Date;
import java.util.List;

/**
 * author  violet
 * createTime 2019/3/26 15:25
 * description 用户管理服务
 * version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public Integer perfectUser(String email, String realName, String telephone) throws ValidationException {
        User userByLoginName = userMapper.getByLoginName(email);
        if (telephone.equals(userByLoginName.getTelephone())) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM.getCode(), "手机号已被注册");
        }
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("email", email);
        userByLoginName.setRealName(realName);
        userByLoginName.setTelephone(telephone);
        userByLoginName.setUpdateTime(new Date());
        userByLoginName.setUpdateBy(email);
        return userMapper.update(userByLoginName, userUpdateWrapper);
    }

    @Override
    public User getByLoginName(String loginName) {
        return userMapper.getByLoginName(loginName);
    }

    @Override
    public UserVO getUserVOById(Long userId) {
        UserVO userVO = userMapper.getUserVOById(userId);
        userVO.setEmail(UserUtils.encryptEmail(userVO.getEmail()));
        userVO.setTelephone(UserUtils.encryptTelephone(userVO.getTelephone()));
        return userVO;
    }

    @Override
    public Integer updatePasswordByEmail(String password, String email) {

        return null;
    }

    @Override
    public Integer activeEmail(String email) {
        User user = new User();
        user.setEmailIsActive(StatusEnum.ACTIVATED.getStatus());
        user.setUpdateBy(email);
        user.setUpdateTime(new Date());

        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("email", email);
        return userMapper.update(user, userUpdateWrapper);
    }

    @Override
    public User getUserByLoginName(String loginName) {
        return userMapper.getByLoginName(loginName);
    }

    @Override
    public Integer updateLogById(Long userId, UserLoginLog userLoginLog) {
        return null;
    }

    @Override
    public Integer insertUser(User user) throws ValidationException {
        //验证邮箱是否存在或使用
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("email", user.getEmail());

        User userEmail = userMapper.selectOne(userQueryWrapper);
        if (userEmail != null && StatusEnum.ACTIVATED.getStatus().equals(userEmail.getEmailIsActive())) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM.getCode(), "邮箱已被注册");
        }
        if (userEmail != null) {
            userMapper.deleteById(userEmail.getUserId());//未被激活删除用户
        }
        user.setCreateBy(user.getUserName());
        user.setSalt(PasswordUtils.getSalt());
        user.setPicImg(UserUtils.getPicImg());
        user.setUserNumber(UserUtils.getUserNumber());
        user.setRegisterTime(new Date());
        user.setLoginPassword(PasswordUtils.getMd5(user.getLoginPassword(), user.getUserNumber(), user.getSalt()));
        return userMapper.insert(user);
    }
}
