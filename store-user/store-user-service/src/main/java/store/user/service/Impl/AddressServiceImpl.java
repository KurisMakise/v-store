package store.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
@Api("收货地址服务")
@RequestMapping("/addressService")
public class AddressServiceImpl implements IAddressService {

    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    @ApiOperation("插入地址")
    @PostMapping("/insertAddress")
    public int insertAddress(Address address, Long userId) {
        address.setUpdateTime(new Date());
        address.setUserId(userId);
        return addressMapper.insert(address);
    }

    @Override
    @ApiOperation("更新收货地址")
    @PostMapping("/updateAddress")
    public int updateAddress(Address address, Long userId) {
        address.setUpdateTime(new Date());
        return addressMapper.updateById(address);
    }

    @Override
    @ApiOperation("删除地址")
    @PostMapping("/deleteByAddressId")
    public int deleteByAddressId(Long addressId, Long userId) {
        UpdateWrapper<Address> addressUpdateWrapper = new UpdateWrapper<>();
        addressUpdateWrapper.eq("address_id", addressId);
        addressUpdateWrapper.eq("user_id", userId);
        return addressMapper.delete(addressUpdateWrapper);
    }

    @Override
    @ApiOperation("分页地址列表")
    @PostMapping("/listByUserId")
    public BasePageDTO<Address> listByUserId(Long userId, PageInfo pageInfo) {

        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq("user_id", userId);

        Page<Address> addressPage = new Page<>(pageInfo.getCurrent(), pageInfo.getLimit());

        IPage<Address> addressIPage = addressMapper.selectPage(addressPage, addressQueryWrapper);
        pageInfo.setTotal(addressIPage.getTotal());

        return new BasePageDTO<>(pageInfo, addressIPage.getRecords());
    }

    @Override
    @ApiOperation("地址列表")
    @PostMapping("/listAddress")
    public List<Address> listAddress(Long userId) {
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq("user_id", userId);
        return addressMapper.selectList(addressQueryWrapper);
    }

    @Override
    @ApiOperation("获取收货地址")
    @PostMapping("/getAddress")
    public Address getAddress(Long addressId, Long userId) {
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper
                .eq("address_id", addressId)
                .eq("user_id", userId);
        return addressMapper.selectOne(addressQueryWrapper);
    }
}
