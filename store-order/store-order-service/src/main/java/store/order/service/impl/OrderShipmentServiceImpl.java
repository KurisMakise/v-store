package store.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import store.common.constant.CommonReturnCode;
import store.common.exception.ValidationException;
import store.order.entity.OrderShipment;
import store.order.mapper.OrderShipmentMapper;
import store.order.service.IOrderShipmentService;

/**
 * author  violet
 * createTime 2019/3/23 19:50
 * description 订单配送表
 * version 1.0
 */
@Service
public class OrderShipmentServiceImpl implements IOrderShipmentService {
    private final OrderShipmentMapper orderShipmentMapper;

    public OrderShipmentServiceImpl(OrderShipmentMapper orderShipmentMapper) {
        this.orderShipmentMapper = orderShipmentMapper;
    }


    @Override
    public OrderShipment getByOrderId(Long orderId) {
        if (orderId == null)
            throw new ValidationException(CommonReturnCode.BAD_PARAM);
        QueryWrapper<OrderShipment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        return orderShipmentMapper.selectOne(queryWrapper);
    }
}
