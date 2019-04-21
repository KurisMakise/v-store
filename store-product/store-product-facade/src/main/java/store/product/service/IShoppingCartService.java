package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.exception.ValidationException;
import store.product.pojo.vo.CartVO;
import store.product.pojo.vo.ShoppingCartVO;

/**
 * @author violet
 * @since 2019/2/27
 */
@FeignClient(name = "store-product-service/shoppingCartService")
public interface IShoppingCartService {

    @PostMapping("/insertShoppingCart")
    Integer insertShoppingCart(@RequestParam("productSpecNumber") Long productSpecNumber,
                               @RequestParam("userId") Long userId) throws ValidationException;

    @PostMapping("/getCart")
    ShoppingCartVO getCart(@RequestParam("userId") Long userId,
                           @RequestParam("productSpecNumber") Long productSpecNumber);

    @PostMapping("/list")
    CartVO list(@RequestParam("userId") Long userId,
                @RequestParam("checkStatus") Integer checkStatus);

    @PostMapping("/updateBuyNumber")
    Integer updateBuyNumber(@RequestParam("productSpecNumber") Long productSpecNumber,
                            @RequestParam("userId") Long userId,
                            @RequestParam("buyNumber") Integer buyNumber);

    @PostMapping("/updateStatus")
    Integer updateStatus(@RequestParam("productSpecNumber") Long productSpecNumber,
                         @RequestParam("userId") Long userId,
                         @RequestParam("checkStatus") Integer checkStatus);

    @PostMapping("/delete")
    Integer delete(@RequestParam("productSpecNumber") Long productSpecNumber,
                   @RequestParam("userId") Long userId);

    @PostMapping("/deleteCheckProduct")
    Integer deleteCheckProduct(@RequestParam("userId") Long userId);
}
