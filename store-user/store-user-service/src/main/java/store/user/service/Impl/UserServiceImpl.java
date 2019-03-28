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
    public UserVO getUserVOById(Long userId) {
        return null;
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
    public User getUserByLoginName(String userName) {
        return null;
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
        if (userEmail != null && userEmail.getEmailIsActive().equals(StatusEnum.ACTIVATED.getStatus())) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM.getCode(), "邮箱已被注册");
        }
        if (userEmail != null && user.getEmailIsActive().equals(StatusEnum.NONACTIVATED.getStatus())) {
            userMapper.deleteById(userEmail.getUserId());//未被激活删除用户
        }
        user.setCreateBy(user.getUserName());
        user.setSalt(PasswordUtils.getSalt());
        user.setPicImg(UserUtils.getPicImg());
        user.setUserNumber(UserUtils.getUserNumber());
        user.setRegisterTime(new Date());
        user.setLoginPassword(PasswordUtils.getMd5(user.getLoginPassword(), user.getUserNumber(), PasswordUtils.getSalt()));
        return userMapper.insert(user);
    }
}
