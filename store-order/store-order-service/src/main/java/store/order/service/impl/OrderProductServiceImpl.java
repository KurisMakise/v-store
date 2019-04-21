package store.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.common.constant.CommonReturnCode;
import store.common.exception.ValidationException;
import store.common.util.JSONUtil;
import store.order.entity.Order;
import store.order.entity.OrderProduct;
import store.order.mapper.OrderProductMapper;
import store.order.service.IOrderProductService;

import java.util.List;
import java.util.Map;

/**
 * author  violet
 * createTime 2019/3/23 19:51
 * description 订单商品
 * version 1.0
 */
@RestController
@Api(tags = {"订单商品"})
@RequestMapping("/orderProductService")
public class OrderProductServiceImpl implements IOrderProductService {

    private final OrderProductMapper orderProductMapper;

    public OrderProductServiceImpl(OrderProductMapper orderProductMapper) {
        this.orderProductMapper = orderProductMapper;
    }

    @PostMapping("/hello")
    public String hello(@RequestBody Map<String, Object> maps) {

        Order order = JSONUtil.parseObject(maps.get("order"), Order.class);
        OrderProduct orderProduct = JSONUtil.parseObject(maps.get("orderProduct"), OrderProduct.class);

        return order.getOrderId() + "  " + orderProduct.getBuyNumber();
    }

    @Override
    @PostMapping("/listByOrderId")
    @ApiOperation("订单商品列表")
    public List<OrderProduct> listByOrderId(Long orderId) {
        if (orderId == null)
            throw new ValidationException(CommonReturnCode.BAD_PARAM);
        QueryWrapper<OrderProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        return orderProductMapper.selectList(queryWrapper);
    }
}
