package store.os.controller.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.constant.CommonReturnCode;
import store.common.enums.StatusEnum;
import store.os.common.result.OsResult;
import store.os.common.security.AuthorizingUser;
import store.os.controller.common.util.SingletonLoginUtils;
import store.product.pojo.vo.CartVO;
import store.product.service.IShoppingCartService;

/**
 * creator violet
 * createTime 2019/3/21
 * description
 */
@Controller
@RequestMapping("/cart")
@Api("商品购物车")
public class ProductShoppingCartController {

    private final IShoppingCartService shoppingCartService;

    @Autowired
    public ProductShoppingCartController(IShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @ApiOperation("加入购物车")
    @GetMapping("/create")
    @ResponseBody
    public Object Create(Model model, @RequestParam Long productSpecNumber) {
        AuthorizingUser authorizingUser = SingletonLoginUtils.getUser();
        if (authorizingUser != null) {
            shoppingCartService.insertShoppingCart(productSpecNumber, authorizingUser.getUserId());
        }
        return null;
    }

    @ApiOperation("购物车数量")
    @GetMapping("/cartNumber")
    @ResponseBody
    public Object cartNumber() {
        CartVO cartVO = shoppingCartService.list(1L, StatusEnum.ALL.getStatus());
        return cartVO.getTotalNumber();
    }

    @ApiOperation("导航栏购物车")
    @GetMapping("/topBar")
    public String topBar(Model model) {
        CartVO cartVO = shoppingCartService.list(1L, StatusEnum.ALL.getStatus());
        model.addAttribute("cartVO", cartVO);
        return "modules/product/product_cart_topBar";
    }

    @ApiOperation("购物车列表")
    @GetMapping("/list")
    public String list(Model model) {
        CartVO list = shoppingCartService.list(1L, StatusEnum.ALL.getStatus());
        model.addAttribute("cartVO", list);
        return "modules/product/product_cart_list";
    }

    @ApiOperation("更新购物车数量")
    @PutMapping("/{productSpecNumber}")
    @ResponseBody
    public Object updateBuyNumber(@PathVariable long productSpecNumber, int buyNumber) {
        Integer count = shoppingCartService.updateBuyNumber(productSpecNumber, 1L, buyNumber);
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
