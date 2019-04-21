package store.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.base.BasePageDTO;
import store.common.exception.ValidationException;
import store.common.support.page.PageInfo;
import store.product.pojo.vo.ProductVO;
import store.user.entity.Favorite;

/**
 * author  violet
 * createTime 2019/3/28 10:47
 * description
 * version 1.0
 */
@FeignClient(name = "STORE-USER-SERVICE/favoriteService")
public interface IFavoriteService {

    @PostMapping("/listByUserId")
    BasePageDTO<Favorite> listByUserId(@RequestParam("userId") Long userId,
                                       @RequestBody PageInfo pageInfo);

    @PostMapping("/deleteByProductNumber")
    Integer deleteByProductNumber(@RequestParam("productNumber") Long productNumber,
                                  @RequestParam("userId") Long userId);

    @PostMapping("/exists")
    boolean exists(@RequestParam("productNumber") Long productNumber,
                   @RequestParam("userId") Long userId);

    @PostMapping("/insert")
    Integer insert(@RequestBody ProductVO productVO,
                   @RequestParam("userId") Long userId) throws ValidationException;

    @PostMapping("/delete")
    Integer delete(@RequestParam("productNumber") Long productNumber,
                   @RequestParam("userId") Long userId) throws ValidationException;
}
