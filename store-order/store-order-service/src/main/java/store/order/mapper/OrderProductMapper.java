package store.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.order.entity.OrderProduct;
import store.order.pojo.vo.OrderShoppingCartVO;

import java.util.List;

public interface OrderProductMapper extends BaseMapper<OrderProduct> {

    int insertProducts(List<OrderShoppingCartVO> orderShoppingCartVOS, long orderId);


}