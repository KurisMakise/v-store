package store.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.order.common.enums.OrderStatusEnum;
import store.order.common.util.OrderUtils;
import store.order.entity.Order;
import store.order.entity.OrderShipment;
import store.order.entity.OrderStatus;
import store.order.mapper.OrderMapper;
import store.order.mapper.OrderProductMapper;
import store.order.mapper.OrderShipmentMapper;
import store.order.mapper.OrderStatusMapper;
import store.order.pojo.vo.OrderShoppingCartVO;
import store.order.pojo.vo.OrderVO;
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

    private final OrderMapper orderMapper;

    private final OrderShipmentMapper orderShipmentMapper;

    private final OrderStatusMapper orderStatusMapper;

    private final OrderProductMapper orderProductMapper;

    public OrderServiceImpl(OrderMapper orderMapper, OrderShipmentMapper orderShipmentMapper, OrderStatusMapper orderStatusMapper, OrderProductMapper orderProductMapper) {
        this.orderMapper = orderMapper;
        this.orderShipmentMapper = orderShipmentMapper;
        this.orderStatusMapper = orderStatusMapper;
        this.orderProductMapper = orderProductMapper;
    }


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

    @Override
    public BasePageDTO<OrderVO> listOrderPage(Long userId, String type, PageInfo pageInfo, String search) {
        List<OrderVO> orders = orderMapper.listOrder(userId, type, pageInfo, search);
        pageInfo.setTotal(orderMapper.getCount(userId, type, search));
        return new BasePageDTO<>(pageInfo, orders);
    }

    @Override
    public Order getOrder(Long userId, Long orderNumber) {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("user_id", userId);
        orderQueryWrapper.eq("order_number", orderNumber);
        return orderMapper.selectOne(orderQueryWrapper);
    }

}
