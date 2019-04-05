package store.os.controller.webfront;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import store.online.common.enums.AdvertTypeEnum;
import store.online.common.enums.NavigationBarTypeEnum;
import store.online.entity.AdvertDetail;
import store.online.entity.NavigationBar;
import store.online.service.IAdvertDetailService;
import store.online.service.INavigationBarService;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */

@Controller
@Api(value = "商城首页")
public class WebFrontController {

    private final IAdvertDetailService advertDetailService;
    private final INavigationBarService navigationBarService;

    public WebFrontController(IAdvertDetailService advertDetailService, INavigationBarService navigationBarService) {
        this.advertDetailService = advertDetailService;
        this.navigationBarService = navigationBarService;
    }

    @ApiOperation(value = "商城首页", notes = "商城首页展示页面")
    @GetMapping("/index")
    public String index(Model model) {
        //首页-广告栏-左部导航栏
        List<NavigationBar> indexAdvertLeft = navigationBarService.listByNavigationId(NavigationBarTypeEnum.INDEX_ADVERT_LEFT.getType());
        model.addAttribute("indexAdvertLeft", indexAdvertLeft);

        //首页轮播广告列表
        List<AdvertDetail> indexCarousel = advertDetailService.listByAdvertId(AdvertTypeEnum.INDEX_CAROUSEL.getType());
        model.addAttribute("indexCarousel", indexCarousel);

        //首页热点广告列表
        List<AdvertDetail> indexHotAdvertImgs = advertDetailService.listByAdvertId(AdvertTypeEnum.INDEX_HOT_ADVERT.getType());
        model.addAttribute("indexHotAdvert", indexHotAdvertImgs);

        return "modules/webfront/index";
    }
}
