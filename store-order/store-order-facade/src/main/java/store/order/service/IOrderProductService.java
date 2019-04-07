package store.order.service;

import store.order.entity.OrderProduct;

import java.util.List;

/**
 * author  violet
 * createTime 2019/3/23 19:47
 * description
 * version 1.0
 */
public interface IOrderProductService {

    List<OrderProduct> listByOrderId(Long orderId);
}
