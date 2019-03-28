package store.product.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.product.entity.Category;
import store.product.mapper.CategoryMapper;
import store.product.mapper.ProductCategoryMapper;
import store.product.pojo.vo.ProductVO;
import store.product.service.IProductCategoryService;

import java.util.List;

/**
 * @creator violet
 * @createTime 2019/3/7
 * @description
 */
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public BasePageDTO<ProductVO> listProducts(Long categoryId, PageInfo pageInfo) {

        return null;
    }

    @Override
    public BasePageDTO<ProductVO> listBySearch(String search, PageInfo pageInfo) {
        return null;
    }
}
