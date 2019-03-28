package store.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.order.entity.OrderShipment;

public interface OrderShipmentMapper extends BaseMapper<OrderShipment> {
    int deleteByPrimaryKey(Long orderShipmentId);

    int insert(OrderShipment record);

    int insertSelective(OrderShipment record);

    OrderShipment selectByPrimaryKey(Long orderShipmentId);

    int updateByPrimaryKeySelective(OrderShipment record);

    int updateByPrimaryKey(OrderShipment record);
}