package store.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.user.entity.Address;

public interface AddressMapper extends BaseMapper<Address> {
    int deleteByPrimaryKey(Long addressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Long addressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}