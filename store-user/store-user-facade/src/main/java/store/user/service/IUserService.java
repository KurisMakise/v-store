package store.user.service;

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
public interface IUserService {

    Integer perfectUser(String email, String realName, String telephone) throws ValidationException;

    User getByLoginName(String loginName);

    UserVO getUserVOById(Long userId);

    Integer updatePasswordByEmail(String password, String email);

    Integer activeEmail(String email);

    User getUserByLoginName(String loginName);

    Integer updateLogById(Long userId, UserLoginLog userLoginLog);

    Integer insertUser(User user);
}
