package store.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.user.entity.Address;
import store.user.mapper.AddressMapper;
import store.user.service.IAddressService;

import java.util.Date;
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
    public int insertAddress(Address address, Long userId) {
        address.setUpdateTime(new Date());
        address.setUserId(userId);
        return addressMapper.insert(address);
    }

    @Override
    public int updateAddress(Address address, Long userId) {
        address.setUpdateTime(new Date());
        return addressMapper.updateById(address);
    }

    @Override
    public int deleteByAddressId(Long addressId, Long userId) {
        UpdateWrapper<Address> addressUpdateWrapper = new UpdateWrapper<>();
        addressUpdateWrapper.eq("address_id", addressId);
        addressUpdateWrapper.eq("user_id", userId);
        return addressMapper.delete(addressUpdateWrapper);
    }

    @Override
    public BasePageDTO<Address> listByUserId(Long userId, PageInfo pageInfo) {

        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq("user_id", userId);

        Page<Address> addressPage = new Page<>(pageInfo.getCurrent(), pageInfo.getLimit());

        IPage<Address> addressIPage = addressMapper.selectPage(addressPage, addressQueryWrapper);
        pageInfo.setTotal(addressIPage.getTotal());

        return new BasePageDTO<>(pageInfo, addressIPage.getRecords());
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
