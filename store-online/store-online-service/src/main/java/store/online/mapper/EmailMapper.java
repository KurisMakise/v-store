package store.online.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.online.entity.Email;

public interface EmailMapper extends BaseMapper<Email> {
    int deleteByPrimaryKey(Long emailId);

    int insert(Email record);

    int insertSelective(Email record);

    Email selectByPrimaryKey(Long emailId);

    int updateByPrimaryKeySelective(Email record);

    int updateByPrimaryKeyWithBLOBs(Email record);

    int updateByPrimaryKey(Email record);
}