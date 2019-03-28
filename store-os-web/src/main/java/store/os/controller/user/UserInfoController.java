package store.os.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.constant.CommonReturnCode;
import store.os.common.result.OsResult;
import store.os.controller.common.util.SingletonLoginUtils;
import store.user.entity.Address;
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
    public String favorite(Model model, @RequestParam int page, @RequestParam int limit) {

        return "/modules/usercenter/user_favorite";
    }

    @ApiOperation("删除收藏")
    @PutMapping("/delete/favorite/{productNumber}")
    @ResponseBody
    public Object deleteFavorite(@PathVariable Long productNumber) {

        return new OsResult(CommonReturnCode.SUCCESS);
    }

    @ApiOperation("收货地址页面")
    @GetMapping("/address")
    public String address(Model model, @RequestParam int page, @RequestParam int limit) {

        return "/modules/usercenter/user_address";
    }

    @ApiOperation("新增收货地址")
    @PostMapping("/address")
    @ResponseBody
    public Object addressCreate(Address address) {
        return new OsResult(CommonReturnCode.SUCCESS);
    }

    @ApiOperation("修改收货地址")
    @GetMapping("/address/{address}")
    @ResponseBody
    public Object addressUpdate(@PathVariable Address address) {
        return new OsResult(CommonReturnCode.SUCCESS);
    }

    @ApiOperation("删除收货地址")
    @RequestMapping(value = "/address/{address}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteUpdate(@PathVariable Address address) {

        return new OsResult(CommonReturnCode.SUCCESS);
    }


}
