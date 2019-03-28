package store.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.order.entity.Order;

public interface OrderMapper extends BaseMapper<Order> {
    int deleteByPrimaryKey(Long orderId);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}