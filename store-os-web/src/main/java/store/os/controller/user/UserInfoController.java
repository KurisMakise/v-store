package store.os.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.base.BasePageDTO;
import store.common.constant.CommonReturnCode;
import store.common.support.page.PageInfo;
import store.os.common.result.OsResult;
import store.os.controller.common.util.SingletonLoginUtils;
import store.user.entity.Address;
import store.user.entity.Favorite;
import store.user.pojo.vo.UserVO;
import store.user.service.IAddressService;
import store.user.service.IFavoriteService;
import store.user.service.IUserService;

/**
 * author  violet
 * createTime 2019/3/26 16:22
 * description 用户中心
 * version 1.0
 */
@Controller
@Api("用户信息")
@RequestMapping("/uc/user")
public class UserInfoController {
    private final IUserService userService;
    private final IFavoriteService favoriteService;
    private final IAddressService addressService;

    public UserInfoController(IAddressService addressService, IUserService userService, IFavoriteService favoriteService) {
        this.addressService = addressService;
        this.userService = userService;
        this.favoriteService = favoriteService;
    }

    @ApiOperation("个人中心")
    @GetMapping("/portal")
    public String portal(Model model) {
        UserVO user = userService.getUserVOById(SingletonLoginUtils.getUserId());
        model.addAttribute("userVO", user);
        return "/modules/usercenter/user_portal";
    }

    @ApiOperation("收藏的商品")
    @GetMapping("/favorite")
    public String favorite(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        PageInfo pageInfo = new PageInfo(limit, page);
        BasePageDTO<Favorite> favoriteBasePageDTO = favoriteService.listByUserId(SingletonLoginUtils.getUserId(), pageInfo);

        model.addAttribute("favorites", favoriteBasePageDTO.getList());
        model.addAttribute("pageInfo", favoriteBasePageDTO.getPageInfo());

        return "/modules/usercenter/user_favorite";
    }

    @ApiOperation("删除收藏")
    @DeleteMapping("/favorite/{productNumber}")
    @ResponseBody
    public Object deleteFavorite(@PathVariable Long productNumber) {
        Integer count = favoriteService.deleteByProductNumber(productNumber, SingletonLoginUtils.getUserId());
        return new OsResult(CommonReturnCode.SUCCESS, count);
    }

    @ApiOperation("收货地址页面")
    @GetMapping("/address")
    public String address(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "12") int limit) {
        PageInfo pageInfo = new PageInfo(limit, page);
        BasePageDTO<Address> addressBasePageDTO = addressService.listByUserId(SingletonLoginUtils.getUserId(), pageInfo);

        model.addAttribute("addresses", addressBasePageDTO.getList());
        model.addAttribute("pageInfo", addressBasePageDTO.getPageInfo());

        return "/modules/usercenter/user_address";
    }

    @ApiOperation("新增收货地址")
    @PostMapping("/address")
    @ResponseBody
    public Object addressCreate(Address address) {
        int count = addressService.insertAddress(address, SingletonLoginUtils.getUserId());
        return new OsResult(CommonReturnCode.SUCCESS, count);
    }

    @ApiOperation("修改收货地址")
    @PutMapping("/address/{addressId}")
    @ResponseBody
    public Object addressUpdate(@RequestParam Address address, @PathVariable Long addressId) {
        address.setAddressId(addressId);
        int count = addressService.updateAddress(address, SingletonLoginUtils.getUserId());
        if (count == 0) {
            return new OsResult(CommonReturnCode.UNKNOWN.getCode(), "更新收货地址失败，请联系管理员");
        } else {
            return new OsResult(CommonReturnCode.SUCCESS, count);
        }
    }

    @ApiOperation("删除收货地址")
    @DeleteMapping("/address/{addressId}")
    @ResponseBody
    public Object addressDelete(@PathVariable Long addressId) {
        int count = addressService.deleteByAddressId(addressId, SingletonLoginUtils.getUserId());
        return new OsResult(CommonReturnCode.SUCCESS, count);
    }
}
