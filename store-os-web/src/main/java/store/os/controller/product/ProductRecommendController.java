package store.os.controller.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.product.common.enums.CommentTypeEnum;
import store.product.common.enums.ProductRecommendTypeEnum;
import store.product.pojo.vo.ProductVO;
import store.product.service.IProductRecommendService;

import java.util.List;

/**
 * @author  violet
 * @since 2019/3/13
 */
@Controller
@Api(tags = {"商品推荐"})
@RequestMapping("/recommend")
public class ProductRecommendController {


    @Autowired
    private IProductRecommendService productRecommendService;

    @ApiOperation("明星产品")
    @GetMapping("/star")
    public String listStar(Model model) {
        List<ProductVO> productVOS = productRecommendService.listByRecommendId(ProductRecommendTypeEnum.STAR.getType());
        model.addAttribute("products", productVOS);
        return "modules/recommend/recommend_star";
    }

    @ApiOperation("为你推荐")
    @GetMapping("/popular")
    public String listPopular(Model model) {
        List<ProductVO> productVOS = productRecommendService.listByRecommendId(ProductRecommendTypeEnum.POPULAR.getType());
        model.addAttribute("products", productVOS);
        return "modules/recommend/recommend_popular";
    }

    @ApiOperation("热评商品")
    @GetMapping("/comment")
    public String listComment(Model model) {
        List<ProductVO> productVOS = productRecommendService.listHotComment(ProductRecommendTypeEnum.COMMENT.getType(), CommentTypeEnum.QUALITY.getType());
        model.addAttribute("products", productVOS);
        return "modules/recommend/recommend_comment";
    }

    @ApiOperation("新品推荐")
    @GetMapping("/new")
    public String listNew(Model model) {
        List<ProductVO> productVOS = productRecommendService.listByRecommendId(ProductRecommendTypeEnum.NEW.getType());
        model.addAttribute("products", productVOS);
        return "modules/recommend/recommend_new";
    }
}
