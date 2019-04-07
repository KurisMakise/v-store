package store.order.service;

import store.order.entity.OrderShipment;

/**
 * author  violet
 * createTime 2019/3/23 19:48
 * description 订单配送
 * version 1.0
 */
public interface IOrderShipmentService {
    OrderShipment getByOrderId(Long orderNumber);

}
