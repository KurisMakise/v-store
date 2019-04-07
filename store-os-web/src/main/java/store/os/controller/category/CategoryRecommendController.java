package store.os.controller.category;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import store.product.common.constant.CategoryConstantEnum;
import store.product.common.enums.CategoryRecommendTypeEnum;
import store.product.pojo.vo.CategoryVO;
import store.product.service.ICategoryRecommendService;

import java.util.List;

/**
 * @creator violet
 * @createTime 2019/3/13
 * @description
 */
@Controller
@RequestMapping("/recommend")
@Api(tags = {"分类推荐"})
public class CategoryRecommendController {

    @Autowired
    private ICategoryRecommendService categoryRecommendService;


    @ApiOperation("商品置顶分类")
    @GetMapping("/top")
    public String listTop(Model model) {
        List<CategoryVO> categoryVOS = categoryRecommendService.listTop(CategoryConstantEnum.CATEGORY_RECOMMEND_PRODUCT.getValue(),
                CategoryConstantEnum.CATEGORY_RECOMMEND_ADVERT.getValue());
        model.addAttribute("categories", categoryVOS);
        return "modules/recommend/recommend_top";
    }

    @ApiOperation("商品热门分类")
    @GetMapping("/hot")
    public String listHot(Model model) {
        return "modules/recommend/recommend_hot";
    }

}
