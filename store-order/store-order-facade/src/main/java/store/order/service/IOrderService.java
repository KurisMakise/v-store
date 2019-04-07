package store.order.service;

import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.order.entity.Order;
import store.order.entity.OrderShipment;
import store.order.pojo.vo.OrderShoppingCartVO;
import store.order.pojo.vo.OrderVO;

import java.util.List;

/**
 * author  violet
 * createTime 2019/3/23 19:47
 * description 订单服务
 * version 1.0
 */
public interface IOrderService {

    OrderVO getOrderVO(Long orderNumber, Long userId);

    /**
     * @param order                订单
     * @param orderShipment        收货地址
     * @param orderShoppingCartVOS 购物车
     * @param userId               用户Id
     * @return 插入结果
     */
    Long insertOrder(Order order, OrderShipment orderShipment, List<OrderShoppingCartVO> orderShoppingCartVOS, Long userId);

    /**
     * @param userId   用户Id
     * @param type     排序类型
     * @param pageInfo 分页信息
     * @param search   搜索条件
     * @return 订单分页列表
     */
    BasePageDTO<OrderVO> listOrderPage(Long userId, String type, PageInfo pageInfo, String search);

    /**
     * @param userId      用户ID
     * @param orderNumber 订单编号
     * @return 订单
     */
    Order getOrder(Long userId, Long orderNumber);
}
