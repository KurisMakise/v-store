package store.product.service;

import store.product.pojo.vo.CartVO;
import store.product.pojo.vo.ShoppingCartVO;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
public interface IShoppingCartService {
    Integer insertShoppingCart(Long productSpecNumber, Long userId);

    ShoppingCartVO getCart(Long userId, Long productSpecNumber);

    CartVO list(Long userId, Integer checkStatus);

    Integer updateBuyNumber(Long productSpecNumber, Long userId, Integer buyNumber);

    Integer updateStatus(Long productSpecNumber, Long userId, Integer checkStatus);

    Integer delete(Long productSpecNumber, Long userId);

    Integer deleteCheckProduct(Long userId);
}
