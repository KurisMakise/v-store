package store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * <p>
 * 分类服务
 * </p>
 *
 * @author violet
 * @since 2019/2/27
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryMapper categoryMapper;

    private final ProductCategoryMapper productCategoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper, ProductCategoryMapper productCategoryMapper) {
        this.categoryMapper = categoryMapper;
        this.productCategoryMapper = productCategoryMapper;
    }

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
    public CategoryVO getById(Long categoryId, Integer status) {
        return categoryMapper.getCategoryById(categoryId, status);
    }

    @Override
    public List<CategoryVO> listLowerCategories(Long categoryId, Integer status) {
        CategoryVO category = categoryMapper.getCategoryById(categoryId, status);
        if (category == null)
            return null;

        List<CategoryVO> categoryVOS = categoryMapper.listCategoriesVO(status);

        List<CategoryVO> lowerCategories = listLower(category.getCategoryId(), new ArrayList<>(), categoryVOS);
        Collections.reverse(lowerCategories);

        return lowerCategories;
    }

    @Override
    public List<CategoryVO> listUpperCategories(Long categoryId, Integer status) {
        CategoryVO category = categoryMapper.getCategoryById(categoryId, status);
        if (category == null)
            return null;

        //查询所有分类
        List<CategoryVO> categoryVOS = categoryMapper.listCategoriesVO(status);
        List<CategoryVO> upperCategories = listUpper(category.getParentId(), new ArrayList<>(), categoryVOS);
        Collections.reverse(upperCategories);
        return upperCategories;
    }


    private List<CategoryVO> listUpper(Long parentId, List<CategoryVO> container, List<CategoryVO> categories) {
        if (parentId == null)
            return container;
        for (CategoryVO categoryVO : categories) {
            if (parentId.equals(categoryVO.getCategoryId())) {
                if (container.indexOf(categoryVO) != -1)
                    return container;
                container.add(categoryVO);
                listUpper(categoryVO.getParentId(), container, categories);
            }
        }
        return container;
    }

    private List<CategoryVO> listLower(Long categoryId, List<CategoryVO> container, List<CategoryVO> categories) {
        if (categoryId == null)
            return container;
        for (CategoryVO category : categories) {
            if (categoryId.equals(category.getParentId())) {
                if (container.indexOf(category) != -1)
                    return container;
                container.add(category);
                listLower(category.getCategoryId(), container, categories);
            }
        }
        return container;
    }


    @Override
    public List<Category> listUpperByProductId(Long productId, Integer status) {
        //所有分类
        List<Category> categories = categoryMapper.selectList(null);
        if (categories == null || categories.isEmpty())
            return null;
        //当前分类
        Category category = categoryMapper.getCategory(productId, status);

        //查询父目录
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
