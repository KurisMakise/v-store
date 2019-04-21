package store.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
@FeignClient(name = "STORE-ORDER-SERVICE/orderService")
public interface IOrderService {

    @PostMapping("/getOrderVO")
    OrderVO getOrderVO(@RequestParam("orderNumber") Long orderNumber,
                       @RequestParam("userId") Long userId);

    /**
     * @param order                订单
     * @param orderShipment        收货地址
     * @param orderShoppingCartVOS 购物车
     * @param userId               用户Id
     * @return 插入结果
     */
    @PostMapping("/insertOrder")
    Long insertOrder(@RequestParam("order") Order order,
                     @RequestParam("orderShipment") OrderShipment orderShipment,
                     @RequestParam("orderShoppingCartVOS") List<OrderShoppingCartVO> orderShoppingCartVOS,
                     @RequestParam("userId") Long userId);

    /**
     * @param userId   用户Id
     * @param type     排序类型
     * @param pageInfo 分页信息
     * @param search   搜索条件
     * @return 订单分页列表
     */
    @PostMapping("/listOrderPage")
    BasePageDTO<OrderVO> listOrderPage(@RequestParam("userId") Long userId,
                                       @RequestParam("type") String type,
                                       @RequestBody PageInfo pageInfo,
                                       @RequestParam("search") String search);

    /**
     * @param userId      用户ID
     * @param orderNumber 订单编号
     * @return 订单
     */
    @PostMapping("/getOrder")
    Order getOrder(@RequestParam("userId") Long userId,
                   @RequestParam("orderNumber") Long orderNumber);
}
