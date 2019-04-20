package store.product.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.common.enums.StatusEnum;
import store.product.common.enums.CategoryRecommendTypeEnum;
import store.product.common.enums.CategoryTypeEnum;
import store.product.common.enums.ProductRecommendTypeEnum;
import store.product.mapper.CategoryMapper;
import store.product.mapper.ProductCategoryMapper;
import store.product.pojo.vo.CategoryVO;
import store.product.pojo.vo.ProductVO;
import store.product.service.ICategoryRecommendService;

import java.util.Date;
import java.util.List;

/**
 * @creator violet
 * @createTime 2019/3/13
 * @description
 */

@RestController
@Api(tags = {"分类推荐"})
@RequestMapping("/categoryRecommendService")
public class CategoryRecommendServiceImpl implements ICategoryRecommendService {

    private final CategoryMapper categoryMapper;

    private final ProductCategoryMapper productCategoryMapper;

    public CategoryRecommendServiceImpl(CategoryMapper categoryMapper, ProductCategoryMapper productCategoryMapper) {
        this.categoryMapper = categoryMapper;
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    @ApiOperation("分类推荐列表")
    @GetMapping("/listTop")
    public List<CategoryVO> listTop(int showNumber, int advertNumber) {

        //查询置顶分类广告
        List<CategoryVO> categoryVOS = categoryMapper.listTopCategoryAdvert(StatusEnum.SHOW.getStatus(), CategoryTypeEnum.FIRST_CATEGORY.getType(),
                CategoryRecommendTypeEnum.SHOW_IN_TOP.getType(), advertNumber, new Date());
        if (!categoryVOS.isEmpty()) {
            for (CategoryVO categoryVO : categoryVOS) {
                //查询子分类ID-
                List<Long> categoryIds = categoryMapper.listSubCategoryIds(categoryVO.getCategoryId(), StatusEnum.SHOW.getStatus());

                //查询子分类下的产品
                List<ProductVO> productVOS = productCategoryMapper.listTopProductByCategoryId(categoryIds, StatusEnum.SHOW.getStatus(),
                        CategoryRecommendTypeEnum.SHOW_IN_TOP.getType(), showNumber);
                categoryVO.setProducts(productVOS);
            }
            return categoryVOS;
        }
        return null;
    }

    @Override
    @ApiOperation("热门商品")
    @GetMapping("/listHot")
    public List<CategoryVO> listHot(int showNumber, int advertNumber, int type) {
        return null;
    }
}
