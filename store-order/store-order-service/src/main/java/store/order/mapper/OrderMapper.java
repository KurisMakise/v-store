package store.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.common.support.page.PageInfo;
import store.order.entity.Order;
import store.order.pojo.vo.OrderVO;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order> {
    /**
     * @param userId   用户id
     * @param type     订单状态
     * @param pageInfo 分页信息
     * @param search   搜索信息
     * @return 分页结果
     */
    List<OrderVO> listOrder(Long userId, String type, PageInfo pageInfo, String search);

    /**
     * @param userId 用户id
     * @param type   订单状态
     * @param search 搜索信息
     * @return 用户订单数
     */
    Integer getCount(Long userId, String type, String search);

    OrderVO getOrderVO(Long orderNumber, Long userId);
}