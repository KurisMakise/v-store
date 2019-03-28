package store.product.service;

import store.order.entity.Order;
import store.order.entity.OrderShipment;
import store.order.pojo.vo.OrderShoppingCartVO;
import store.product.pojo.vo.CartVO;
import store.product.pojo.vo.ShoppingCartVO;

import java.util.List;

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
