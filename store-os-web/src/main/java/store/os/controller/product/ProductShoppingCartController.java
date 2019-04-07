package store.os.controller.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.base.BaseController;
import store.common.constant.CommonReturnCode;
import store.common.enums.StatusEnum;
import store.common.exception.ValidationException;
import store.os.common.result.OsResult;
import store.os.controller.common.util.SingletonLoginUtils;
import store.product.pojo.vo.CartVO;
import store.product.pojo.vo.ShoppingCartVO;
import store.product.service.IShoppingCartService;

/**
 * creator violet
 * createTime 2019/3/21
 * description
 */
@Controller
@RequestMapping("/cart")
@Api(tags = {"商品购物车"})
public class ProductShoppingCartController extends BaseController {

    private final IShoppingCartService shoppingCartService;

    @Autowired
    public ProductShoppingCartController(IShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @ApiOperation("购物车信息")
    @GetMapping("/{productSpecNumber}")
    public String view(Model model, @PathVariable Long productSpecNumber) {
        ShoppingCartVO shoppingCartVO = shoppingCartService.getCart(SingletonLoginUtils.getUserId(), productSpecNumber);
        model.addAttribute("shoppingCartVO", shoppingCartVO);
        return "/modules/product/product_cart_info";
    }


    @ApiOperation("加入购物车")
    @PostMapping("/{productSpecNumber}")
    @ResponseBody
    public Object create(@PathVariable Long productSpecNumber) {
        try {
            Integer count = shoppingCartService.insertShoppingCart(productSpecNumber, SingletonLoginUtils.getUserId());
            if (count != null && count > 0) {
                return new OsResult(CommonReturnCode.SUCCESS, productSpecNumber);
            }
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
            return new OsResult(e.getCode(), e.getMessage());
        }
        return new OsResult(CommonReturnCode.UNKNOWN);
    }

    @ApiOperation("购物车数量")
    @GetMapping("/cartNumber")
    @ResponseBody
    public Object cartNumber() {
        try {
            CartVO cartVO = shoppingCartService.list(SingletonLoginUtils.getUserId(), StatusEnum.ALL.getStatus());
            return new OsResult(CommonReturnCode.SUCCESS, cartVO.getTotalNumber());
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
            return new OsResult(CommonReturnCode.UNKNOWN, 0);
        }
    }

    @ApiOperation("导航栏购物车")
    @GetMapping("/topBar")
    public String topBar(Model model) {
        CartVO cartVO = shoppingCartService.list(SingletonLoginUtils.getUserId(), StatusEnum.ALL.getStatus());
        model.addAttribute("cartVO", cartVO);
        return "modules/product/product_cart_topBar";
    }

    @ApiOperation("购物车列表")
    @GetMapping("/list")
    public String list(Model model) {
        try {
            CartVO list = shoppingCartService.list(SingletonLoginUtils.getUserId(), StatusEnum.ALL.getStatus());
            model.addAttribute("cartVO", list);
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
        }
        return "modules/product/product_cart_list";
    }

    @ApiOperation("更新购物车数量")
    @PutMapping("/{productSpecNumber}")
    @ResponseBody
    public Object updateBuyNumber(@PathVariable long productSpecNumber, int buyNumber) {
        Integer count = shoppingCartService.updateBuyNumber(productSpecNumber, SingletonLoginUtils.getUserId(), buyNumber);
        if (count != null) {
            return new OsResult(CommonReturnCode.SUCCESS, count);
        }
        return new OsResult(CommonReturnCode.UNKNOWN);
    }


    @ApiOperation("修改商品状态")
    @PutMapping("/{productSpecNumber}/status")
    @ResponseBody
    public Object updateStatus(Model model, @PathVariable long productSpecNumber, @RequestParam(value = "checkStatus") int checkStatus) {
        Integer status = null;
        if (checkStatus == StatusEnum.CHECKED.getStatus()) {
            status = StatusEnum.UNCHECKED.getStatus();
        } else if (StatusEnum.UNCHECKED.getStatus() == checkStatus) {
            status = StatusEnum.CHECKED.getStatus();
        }
        if (status != null) {
            int count = shoppingCartService.updateStatus(productSpecNumber, 1L, status);
            return new OsResult(CommonReturnCode.SUCCESS, count);
        }
        return new OsResult(CommonReturnCode.BAD_PARAM);
    }
}
