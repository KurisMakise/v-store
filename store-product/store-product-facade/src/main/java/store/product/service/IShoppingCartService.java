package store.product.service;

import store.common.exception.ValidationException;
import store.product.pojo.vo.CartVO;
import store.product.pojo.vo.ShoppingCartVO;

/**
 * @author  violet
 * @since  2019/2/27
 */
public interface IShoppingCartService {
    Integer insertShoppingCart(Long productSpecNumber, Long userId) throws ValidationException;

    ShoppingCartVO getCart(Long userId, Long productSpecNumber);

    CartVO list(Long userId, Integer checkStatus);

    Integer updateBuyNumber(Long productSpecNumber, Long userId, Integer buyNumber);

    Integer updateStatus(Long productSpecNumber, Long userId, Integer checkStatus);

    Integer delete(Long productSpecNumber, Long userId);

    Integer deleteCheckProduct(Long userId);
}
