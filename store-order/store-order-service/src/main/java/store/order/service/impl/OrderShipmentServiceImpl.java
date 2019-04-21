package store.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
@Api(tags = {"订单配送信息"})
@RequestMapping("/orderShipmentService")
public class OrderShipmentServiceImpl implements IOrderShipmentService {
    private final OrderShipmentMapper orderShipmentMapper;

    public OrderShipmentServiceImpl(OrderShipmentMapper orderShipmentMapper) {
        this.orderShipmentMapper = orderShipmentMapper;
    }


    @Override
    @PostMapping("/getByOrderId")
    @ApiOperation("获取配送信息")
    public OrderShipment getByOrderId(Long orderId) {
        if (orderId == null)
            throw new ValidationException(CommonReturnCode.BAD_PARAM);
        QueryWrapper<OrderShipment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        return orderShipmentMapper.selectOne(queryWrapper);
    }
}
