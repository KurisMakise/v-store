package store.os.controller.order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.constant.CommonReturnCode;
import store.common.enums.StatusEnum;
import store.order.entity.Order;
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
public class OrderBuyController {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IOrderStatusService orderStatusService;

    @Autowired
    private IOrderProductService orderProductService;

    @Autowired
    private IOrderShipmentService orderShipmentService;

    @Autowired
    private IOrderService orderService;


    @ApiOperation("填写订单信息")
    @GetMapping("/checkout")
    public String checkout(Model model) {
        //收货地址
        List<Address> addresses = addressService.listAddress(1L);
        model.addAttribute("addresses", addresses);

        //购物车选中商品
        CartVO cartVO = shoppingCartService.list(1L, StatusEnum.CHECKED.getStatus());
        model.addAttribute("cartVO", cartVO);
        return "modules/order/order_buy_checkout";
    }

    @ApiOperation("确认订单信息")
    @PostMapping("/confirm")
    @ResponseBody
    public Object confirm(@RequestParam(value = "addressId") Long addressId, Order order) {
        //收货地址
        long userId = SingletonLoginUtils.getUserId();
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

            //生成订单
            Long orderNumber = orderService.insertOrder(order, orderShipment, orderShoppingCartVOS, userId);

            if (orderNumber != null) {
                shoppingCartService.deleteCheckProduct(userId);
                return new OsResult(CommonReturnCode.SUCCESS);
            } else {
                return new OsResult(CommonReturnCode.UNKNOWN);
            }
        } else {
            return new OsResult(CommonReturnCode.BAD_PARAM.getCode(), "请选择收货地址");
        }
    }

}
