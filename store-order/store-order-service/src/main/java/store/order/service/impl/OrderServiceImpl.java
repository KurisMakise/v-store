package store.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.order.common.enums.OrderStatusEnum;
import store.order.common.util.OrderUtils;
import store.order.entity.Order;
import store.order.entity.OrderProduct;
import store.order.entity.OrderShipment;
import store.order.entity.OrderStatus;
import store.order.mapper.OrderMapper;
import store.order.mapper.OrderProductMapper;
import store.order.mapper.OrderShipmentMapper;
import store.order.mapper.OrderStatusMapper;
import store.order.pojo.vo.OrderShoppingCartVO;
import store.order.service.IOrderService;

import java.util.Date;
import java.util.List;

/**
 * author  violet
 * createTime 2019/3/23 19:47
 * description
 * version 1.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderShipmentMapper orderShipmentMapper;

    @Autowired
    private OrderStatusMapper orderStatusMapper;

    @Autowired
    private OrderProductMapper orderProductMapper;


    @Override
    public Long insertOrder(Order order, OrderShipment orderShipment, List<OrderShoppingCartVO> orderShoppingCartVOS, Long userId) {
        //创建订单
        Long orderNumber = OrderUtils.getOrderNumber();
        order.setOrderNumber(orderNumber);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setUserId(userId);
        order.setPayAmount(order.getOrderAmount().add(order.getShipmentAmount()));
        order.setOrderStatus(OrderStatusEnum.SUBMIT_ORDERS.getStatus().byteValue());
        orderMapper.insert(order);

        //创建订单配送表
        orderShipment.setUpdateTime(new Date());
        orderShipmentMapper.insert(orderShipment);

        //添加商品详情
        orderProductMapper.insertProducts(orderShoppingCartVOS, order.getOrderId());

        //添加订单记录
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderStatus(OrderStatusEnum.SUBMIT_ORDERS.getStatus().byteValue());
        orderStatus.setCreateBy(userId.toString());
        orderStatus.setCreateStatus(OrderStatusEnum.SUBMIT_ORDERS.getStatus().byteValue());
        orderStatus.setCreateTime(new Date());
        orderStatus.setRemarks(OrderStatusEnum.SUBMIT_ORDERS.getStatusInfo());
        orderStatus.setOrderId(order.getOrderId());
        orderStatusMapper.insert(orderStatus);

        return orderNumber;
    }

}
