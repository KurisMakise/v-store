package store.os.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.base.BaseController;
import store.common.constant.CommonReturnCode;
import store.common.exception.ValidationException;
import store.os.common.result.OsResult;
import store.os.controller.common.util.SingletonLoginUtils;
import store.product.pojo.vo.ProductVO;
import store.product.service.IProductService;
import store.user.service.IFavoriteService;

/**
 * author  violet
 * createTime 2019/4/3 16:51
 * description
 * version 1.0
 */
@Api(tags = {"商品收藏"})
@Controller
public class UserFavoriteController extends BaseController {


    private final IFavoriteService favoriteService;

    private final IProductService productService;


    public UserFavoriteController(IFavoriteService favoriteService, IProductService productService) {
        this.favoriteService = favoriteService;
        this.productService = productService;
    }


    @ApiOperation("删除收藏")
    @DeleteMapping("/favorite/{productNumber}")
    @ResponseBody
    public Object favoriteDelete(@PathVariable Long productNumber) {
        try {
            Integer count = favoriteService.delete(productNumber, SingletonLoginUtils.getUserId());
             if (count != null && count > 0)
                return new OsResult(CommonReturnCode.SUCCESS);
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
            return new OsResult(e.getCode(), e.getMessage());
        }
        return new OsResult(CommonReturnCode.UNKNOWN);
    }

    @ApiOperation("判断是否收藏")
    @GetMapping("/favorite/{productNumber}")
    @ResponseBody
    public Object favoriteExists(@PathVariable Long productNumber) {

        boolean exists = favoriteService.exists(productNumber, SingletonLoginUtils.getUserId());
        return new OsResult(CommonReturnCode.SUCCESS, exists);
    }

    @ApiOperation("更新收藏")
    @PutMapping("/favorite")
    @ResponseBody
    public Object favoriteUpdate(Long favoriteId) {

        return null;
    }

    @ApiOperation("添加收藏")
    @PostMapping("/favorite/{productId}")
    @ResponseBody
    public Object favoriteAdd(@PathVariable Long productId) {
        try {
            ProductVO productVO = productService.getProductVOById(productId);
            favoriteService.insert(productVO, SingletonLoginUtils.getUserId());
            return new OsResult(CommonReturnCode.SUCCESS.getCode(), "收藏成功");
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
            return new OsResult(e.getCode(), e.getMessage());
        }
    }
}
