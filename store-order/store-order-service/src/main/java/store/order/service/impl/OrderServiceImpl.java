package store.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.common.base.BasePageDTO;
import store.common.constant.CommonReturnCode;
import store.common.exception.ValidationException;
import store.common.support.page.PageInfo;
import store.order.common.enums.OrderStatusEnum;
import store.order.common.util.OrderUtils;
import store.order.entity.Order;
import store.order.entity.OrderShipment;
import store.order.entity.OrderStatus;
import store.order.mapper.OrderMapper;
import store.order.mapper.OrderProductMapper;
import store.order.mapper.OrderShipmentMapper;
import store.order.mapper.OrderStatusMapper;
import store.order.pojo.vo.OrderShoppingCartVO;
import store.order.pojo.vo.OrderVO;
import store.order.service.IOrderService;

import java.util.Date;
import java.util.List;

/**
 * author  violet
 * createTime 2019/3/23 19:47
 * description
 * version 1.0
 */
@RestController
@Api(tags = {"订单服务"})
@RequestMapping("orderService")
public class OrderServiceImpl implements IOrderService {

    private final OrderMapper orderMapper;

    private final OrderShipmentMapper orderShipmentMapper;

    private final OrderStatusMapper orderStatusMapper;

    private final OrderProductMapper orderProductMapper;

    public OrderServiceImpl(OrderMapper orderMapper, OrderShipmentMapper orderShipmentMapper, OrderStatusMapper orderStatusMapper, OrderProductMapper orderProductMapper) {
        this.orderMapper = orderMapper;
        this.orderShipmentMapper = orderShipmentMapper;
        this.orderStatusMapper = orderStatusMapper;
        this.orderProductMapper = orderProductMapper;
    }

    @Override
    @GetMapping("/getOrderVO")
    @ApiOperation("获取订单")
    public OrderVO getOrderVO(Long orderNumber, Long userId) {
        if (userId == null)
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);
        if (orderNumber == null)
            throw new ValidationException(CommonReturnCode.BAD_PARAM);

        return orderMapper.getOrderVO(orderNumber, userId);
    }

    @Override
    @GetMapping("/insertOrder")
    @ApiOperation("新增订单")
    public Long insertOrder(Order order, OrderShipment orderShipment, List<OrderShoppingCartVO> orderShoppingCartVOS, Long userId) {
        //创建订单
        Long orderNumber = OrderUtils.getOrderNumber();
        order.setOrderNumber(orderNumber);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setUserId(userId);
        order.setPayAmount(order.getOrderAmount().add(order.getShipmentAmount()));
        order.setOrderStatus(OrderStatusEnum.SUBMIT_ORDERS.getStatus().byteValue());
        orderMapper.insert(order);

        //创建订单配送表
        orderShipment.setOrderId(order.getOrderId());
        orderShipment.setUpdateTime(new Date());
        orderShipmentMapper.insert(orderShipment);

        //添加商品详情
        orderProductMapper.insertProducts(orderShoppingCartVOS, order.getOrderId());

        //添加订单记录
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setOrderStatus(OrderStatusEnum.SUBMIT_ORDERS.getStatus().byteValue());
        orderStatus.setCreateBy(userId.toString());
        orderStatus.setCreateStatus(OrderStatusEnum.SUBMIT_ORDERS.getStatus().byteValue());
        orderStatus.setCreateTime(new Date());
        orderStatus.setRemarks(OrderStatusEnum.SUBMIT_ORDERS.getStatusInfo());
        orderStatus.setOrderId(order.getOrderId());
        orderStatusMapper.insert(orderStatus);

        return orderNumber;
    }

    @Override
    @GetMapping("/listOrderPage")
    @ApiOperation("订单列表")
    public BasePageDTO<OrderVO> listOrderPage(Long userId, String type, PageInfo pageInfo, String search) {
        List<OrderVO> orders = orderMapper.listOrder(userId, type, pageInfo, search);
        pageInfo.setTotal(orderMapper.getCount(userId, type, search));
        return new BasePageDTO<>(pageInfo, orders);
    }

    @Override
    @GetMapping("/getOrder")
    @ApiOperation("获取订单")
    public Order getOrder(Long userId, Long orderNumber) {
        if (userId == null)
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);
        if (orderNumber == null)
            throw new ValidationException(CommonReturnCode.BAD_PARAM);

        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("user_id", userId);
        orderQueryWrapper.eq("order_number", orderNumber);
        return orderMapper.selectOne(orderQueryWrapper);
    }

}
