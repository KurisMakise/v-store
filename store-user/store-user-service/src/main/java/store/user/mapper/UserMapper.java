package store.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.user.entity.User;
import store.user.pojo.vo.UserVO;

public interface UserMapper extends BaseMapper<User> {
    User getByLoginName(String loginName);

    UserVO getUserVOById(Long userId);
}