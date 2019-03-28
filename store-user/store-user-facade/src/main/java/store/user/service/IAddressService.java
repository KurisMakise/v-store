package store.user.service;

import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.user.entity.Address;

import java.util.List;

/**
 * author  violet
 * createTime 2019/3/22 23:40
 * description
 * version 1.0
 */
public interface IAddressService {

    int insertAddress(Address address);

    int updateAddress(Address address);

    int deleteByAddressId(Long addressId);

    BasePageDTO<Address> listByUserId(Long userId, PageInfo pageInfo);


    List<Address> listAddress(Long userId);

    Address getAddress(Long addressId, Long userId);
}
