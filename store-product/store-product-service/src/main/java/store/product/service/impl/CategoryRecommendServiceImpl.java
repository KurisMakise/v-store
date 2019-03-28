package store.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Service
public class CategoryRecommendServiceImpl implements ICategoryRecommendService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
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
    public List<CategoryVO> listHot(int showNumber, int advertNumber, int type) {


        return null;
    }
}
