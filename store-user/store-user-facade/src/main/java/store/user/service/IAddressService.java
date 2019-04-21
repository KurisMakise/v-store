package store.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
@FeignClient("store-user-service/addressService")
public interface IAddressService {

    @PostMapping("/insertAddress")
    int insertAddress(@RequestBody Address address,
                      @RequestParam("userId") Long userId);

    @PostMapping("/updateAddress")
    int updateAddress(@RequestBody Address address,
                      @RequestParam("userId") Long userId);

    @PostMapping("/deleteByAddressId")
    int deleteByAddressId(@RequestParam("addressId") Long addressId,
                          @RequestParam("userId") Long userId);

    @PostMapping("/listByUserId")
    BasePageDTO<Address> listByUserId(@RequestParam("userId") Long userId,
                                      @RequestBody PageInfo pageInfo);

    @PostMapping("/listAddress")
    List<Address> listAddress(@RequestParam("userId") Long userId);

    @PostMapping("/getAddress")
    Address getAddress(@RequestParam("addressId") Long addressId,
                       @RequestParam("userId") Long userId);
}
