package store.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.user.entity.Address;
import store.user.mapper.AddressMapper;
import store.user.service.IAddressService;

import java.util.List;

/**
 * author  violet
 * createTime 2019/3/22 23:55
 * description
 * version 1.0
 */
@Service
public class AddressServiceImpl implements IAddressService {

    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public List<Address> listAddress(Long userId) {
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq("user_id", userId);
        return addressMapper.selectList(addressQueryWrapper);
    }

    public Address getAddress(Long addressId, Long userId) {
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper
                .eq("address_id", addressId)
                .eq("user_id", userId);
        return addressMapper.selectOne(addressQueryWrapper);
    }
}
