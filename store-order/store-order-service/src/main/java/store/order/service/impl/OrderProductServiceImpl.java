package store.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import store.common.constant.CommonReturnCode;
import store.common.exception.ValidationException;
import store.order.entity.OrderProduct;
import store.order.mapper.OrderProductMapper;
import store.order.service.IOrderProductService;

import java.util.List;

/**
 * author  violet
 * createTime 2019/3/23 19:51
 * description 订单商品
 * version 1.0
 */
@Service
public class OrderProductServiceImpl implements IOrderProductService {

    private final OrderProductMapper orderProductMapper;

    public OrderProductServiceImpl(OrderProductMapper orderProductMapper) {
        this.orderProductMapper = orderProductMapper;
    }

    @Override
    public List<OrderProduct> listByOrderId(Long orderId) {
        if (orderId == null)
            throw new ValidationException(CommonReturnCode.BAD_PARAM);
        QueryWrapper<OrderProduct> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        return orderProductMapper.selectList(queryWrapper);
    }
}
