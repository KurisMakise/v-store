package store.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.user.entity.UserLoginLog;

public interface UserLoginLogMapper extends BaseMapper<UserLoginLog> {
    int deleteByPrimaryKey(Long logId);

    int insert(UserLoginLog record);

    int insertSelective(UserLoginLog record);

    UserLoginLog selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(UserLoginLog record);

    int updateByPrimaryKey(UserLoginLog record);
}