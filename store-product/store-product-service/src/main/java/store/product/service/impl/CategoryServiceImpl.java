package store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.common.base.BasePageDTO;
import store.common.enums.StatusEnum;
import store.common.support.page.PageInfo;
import store.product.common.enums.CategoryRecommendTypeEnum;
import store.product.common.enums.CategoryTypeEnum;
import store.product.entity.Category;
import store.product.mapper.CategoryMapper;
import store.product.mapper.ProductCategoryMapper;
import store.product.pojo.vo.CategoryVO;
import store.product.pojo.vo.ProductVO;
import store.product.service.ICategoryService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public Integer insertAdvert(Category category, String userName) {
        return null;
    }

    @Override
    public List<CategoryVO> listTop(Integer showNumber, Integer advertNumber) {
        return null;
    }

    @Override
    public List<CategoryVO> listHot(Integer showNumber, Integer advertNumber, Integer type) {
        return null;
    }

    @Override
    public List<CategoryVO> listNav(Integer productNumber, Integer navNumber) {
        // 根据是否导航/类目类型/导航状态/导航显示数量查找显示导航分类
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper
                .select("category_id AS categoryId", "name")
                .eq("type", CategoryTypeEnum.FIRST_CATEGORY.getType())
                .eq("show_in_nav", CategoryRecommendTypeEnum.SHOW_IN_NAV.getType())
                .eq("status", StatusEnum.SHOW.getStatus())
                .apply(false, "limit {0}", navNumber);

        List<Category> categories = categoryMapper.selectList(categoryQueryWrapper);

        List<CategoryVO> categoryVOS = new ArrayList<>();
        for (Category category : categories) {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.loadFields(category);
            categoryVOS.add(categoryVO);
        }

        if (categoryVOS.size() > 0) {
            for (CategoryVO categoryVO : categoryVOS) {
                //查询分类子目录
                List<Long> childCategoryIds = categoryMapper.listSubCategoryIds(categoryVO.getCategoryId(), StatusEnum.SHOW.getStatus());

                //查询分类目录下的置顶商品
                List<ProductVO> productVOS = productCategoryMapper.listNavByCategoryId(childCategoryIds, StatusEnum.SHOW.getStatus(), CategoryRecommendTypeEnum.SHOW_IN_NAV.getType(), productNumber);
                categoryVO.setProducts(productVOS);
            }
        }

        return categoryVOS;
    }

    @Override
    public Category getById(Long categoryId, Integer status) {
        return null;
    }

    @Override
    public List<Category> listLowerCategories(Long categoryId, Integer status) {
        return null;
    }

    @Override
    public List<Category> listUpperCategories(Long categoryId, Integer status) {
        return null;
    }

    @Override
    public List<Category> listUpperByProductId(Long productId, Integer status) {
        List<Category> categories = categoryMapper.selectList(null);
        Category category = categoryMapper.getCategory(productId, status);
        List<Category> upperCategories = upperCategory(category.getCategoryId(), new ArrayList<>(), categories);
        Collections.reverse(upperCategories);
        return upperCategories;
    }


    /**
     * 递归查询父目录
     *
     * @param parentId   父目录Id
     * @param container  存放分类
     * @param categories 分类列表
     * @return 父目录列表
     */
    private List<Category> upperCategory(Long parentId, List<Category> container, List<Category> categories) {
        if (parentId == null)
            return container;
        for (Category category : categories) {
            if (parentId.equals(category.getCategoryId())) {
                if (container.indexOf(category) == -1) { //防止无限循环
                    container.add(category);
                    upperCategory(category.getParentId(), container, categories);
                } else {
                    return container;
                }
            }
        }
        return container;
    }


    @Override
    public BasePageDTO<Category> listParentByPage(PageInfo pageInfo, String search, Long parentId) {
        return null;
    }

    @Override
    public Integer updateStatus(Long categoryId) {
        return null;
    }

    @Override
    public Integer updateCategory(Category category, String userName) {
        return null;
    }
}
