package store.os.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.base.BaseController;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.order.common.enums.OrderTypeEnum;
import store.order.entity.Order;
import store.order.pojo.vo.OrderVO;
import store.order.service.IOrderService;
import store.os.controller.common.util.SingletonLoginUtils;

/**
 * author  violet
 * createTime 2019/3/26 16:23
 * description 订单中心
 * version 1.0
 */

@Controller
@Api(tags = {"用户订单"})
@RequestMapping("/uc/order")
public class UserOrderController extends BaseController {

    private final IOrderService orderService;

    public UserOrderController(IOrderService orderService) {
        this.orderService = orderService;
    }


    @ApiOperation("我的订单")
    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "6") Integer limit,
                       @RequestParam(defaultValue = "1") Integer type,
                       @RequestParam(required = false) String search) {
        PageInfo pageInfo = new PageInfo(limit, page);
        BasePageDTO<OrderVO> orderBasePageDTO = orderService.listOrderPage(SingletonLoginUtils.getUserId(), OrderTypeEnum.typeOf(type).getTypeValue(), pageInfo, search);

        model.addAttribute("orderVOs", orderBasePageDTO.getList());
        model.addAttribute("pageInfo", orderBasePageDTO.getPageInfo());
        model.addAttribute("type", type);
        model.addAttribute("search", search);
        return "/modules/usercenter/user_order";
    }

    @ApiOperation("订单详情")
    @GetMapping("/{orderNumber}")
    public String orderView(Model model, @PathVariable Long orderNumber) {
        OrderVO orderVO = orderService.getOrderVO(orderNumber, SingletonLoginUtils.getUserId());
        model.addAttribute("orderVO", orderVO);
        return "/modules/usercenter/user_order_view";
    }

}
