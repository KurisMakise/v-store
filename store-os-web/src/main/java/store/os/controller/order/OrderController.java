package store.os.controller.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.base.BaseController;
import store.common.constant.CommonReturnCode;
import store.common.enums.StatusEnum;
import store.common.exception.ValidationException;
import store.order.entity.Order;
import store.order.entity.OrderProduct;
import store.order.entity.OrderShipment;
import store.order.pojo.vo.OrderShoppingCartVO;
import store.order.service.IOrderProductService;
import store.order.service.IOrderService;
import store.order.service.IOrderShipmentService;
import store.order.service.IOrderStatusService;
import store.os.common.result.OsResult;
import store.os.controller.common.util.SingletonLoginUtils;
import store.product.pojo.vo.CartVO;
import store.product.pojo.vo.ShoppingCartVO;
import store.product.service.IShoppingCartService;
import store.user.entity.Address;
import store.user.service.IAddressService;

import java.util.ArrayList;
import java.util.List;

/**
 * author  violet
 * createTime 2019/3/22 23:22
 * description
 * version 1.0
 */
@Controller
@RequestMapping("/buy")
@Api("购买商品")
public class OrderController extends BaseController {

    private final IShoppingCartService shoppingCartService;

    private final IAddressService addressService;

    private final IOrderStatusService orderStatusService;

    private final IOrderProductService orderProductService;

    private final IOrderShipmentService orderShipmentService;

    private final IOrderService orderService;

    public OrderController(IShoppingCartService shoppingCartService, IAddressService addressService, IOrderStatusService orderStatusService, IOrderProductService orderProductService, IOrderShipmentService orderShipmentService, IOrderService orderService) {
        this.shoppingCartService = shoppingCartService;
        this.addressService = addressService;
        this.orderStatusService = orderStatusService;
        this.orderProductService = orderProductService;
        this.orderShipmentService = orderShipmentService;
        this.orderService = orderService;
    }


    @ApiOperation("填写订单信息")
    @GetMapping("/checkout")
    public String checkout(Model model) {
        //收货地址
        List<Address> addresses = addressService.listAddress(SingletonLoginUtils.getUserId());
        model.addAttribute("addresses", addresses);
        //购物车选中商品
        CartVO cartVO = shoppingCartService.list(SingletonLoginUtils.getUserId(), StatusEnum.CHECKED.getStatus());
        model.addAttribute("cartVO", cartVO);

        return "modules/order/order_buy_checkout";
    }

    @ApiOperation("确认订单信息")
    @PostMapping("/confirm")
    @ResponseBody
    public Object confirm(@RequestParam(value = "addressId") Long addressId, Order order) {
        //收货地址
        Long userId = SingletonLoginUtils.getUserId();
        Address address = addressService.getAddress(addressId, userId);
        if (address != null) {
            OrderShipment orderShipment = new OrderShipment();
            BeanUtils.copyProperties(address, orderShipment);
            //购物车选中商品
            CartVO cartVO = shoppingCartService.list(userId, StatusEnum.CHECKED.getStatus());
            order.setBuyNumber(cartVO.getTotalNumber());
            order.setOrderAmount(cartVO.getTotalPrice());
            order.setOrderScore(cartVO.getTotalScore());

            List<OrderShoppingCartVO> orderShoppingCartVOS = new ArrayList<>();
            for (ShoppingCartVO shoppingCartVO : cartVO.getShoppingCartVOs()) {
                OrderShoppingCartVO orderShoppingCartVO = new OrderShoppingCartVO();
                BeanUtils.copyProperties(shoppingCartVO, orderShoppingCartVO);
                orderShoppingCartVOS.add(orderShoppingCartVO);
            }
            if (orderShoppingCartVOS.isEmpty()) {
                return new OsResult(CommonReturnCode.BAD_PARAM.getCode(), "购物车商品不存在");
            }
            //生成订单
            Long orderNumber = orderService.insertOrder(order, orderShipment, orderShoppingCartVOS, userId);

            if (orderNumber != null) {
                shoppingCartService.deleteCheckProduct(userId);
                //TODO orderNumber有时候会丢失精度
                return new OsResult(CommonReturnCode.SUCCESS, orderNumber.toString());
            } else {
                return new OsResult(CommonReturnCode.UNKNOWN);
            }
        } else {
            return new OsResult(CommonReturnCode.BAD_PARAM.getCode(), "请选择收货地址");
        }
    }

    public static void main(String[] args) {
    }

    @ApiOperation("订单确认")
    @GetMapping("/confirm/{orderNumber}")
    public String confirmView(Model model, @PathVariable Long orderNumber) {
        try {
            Order order = orderService.getOrder(SingletonLoginUtils.getUserId(), orderNumber);
            OrderShipment orderShipment = orderShipmentService.getByOrderId(order.getOrderId());
            List<OrderProduct> orderProducts = orderProductService.listByOrderId(order.getOrderId());

            model.addAttribute("orderShipment", orderShipment);
            model.addAttribute("orderProducts", orderProducts);
            model.addAttribute("order", order);
            return "/modules/order/order_buy_confirm";
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
            return "/modules/order/order_buy_confirm";
        }
    }
}
