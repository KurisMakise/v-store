package store.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.order.entity.OrderStatus;

public interface OrderStatusMapper extends BaseMapper<OrderStatus> {
    int deleteByPrimaryKey(Long orderStatusId);

    int insert(OrderStatus record);

    int insertSelective(OrderStatus record);

    OrderStatus selectByPrimaryKey(Long orderStatusId);

    int updateByPrimaryKeySelective(OrderStatus record);

    int updateByPrimaryKey(OrderStatus record);
}