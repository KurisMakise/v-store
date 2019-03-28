package store.web.mapper;

import store.web.entity.Email;

public interface EmailMapper {
    int deleteByPrimaryKey(Long emailId);

    int insert(Email record);

    int insertSelective(Email record);

    Email selectByPrimaryKey(Long emailId);

    int updateByPrimaryKeySelective(Email record);

    int updateByPrimaryKeyWithBLOBs(Email record);

    int updateByPrimaryKey(Email record);
}