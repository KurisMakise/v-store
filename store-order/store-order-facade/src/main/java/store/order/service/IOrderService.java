package store.order.service;

import store.order.entity.Order;
import store.order.entity.OrderShipment;
import store.order.pojo.vo.OrderShoppingCartVO;

import java.util.List;

/**
 * author  violet
 * createTime 2019/3/23 19:47
 * description TODO
 * version 1.0
 */
public interface IOrderService {

    Long insertOrder(Order order, OrderShipment orderShipment, List<OrderShoppingCartVO> orderShoppingCartVOS, Long userId);

}
