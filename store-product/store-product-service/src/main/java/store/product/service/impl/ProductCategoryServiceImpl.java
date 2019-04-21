package store.product.service.impl;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.product.mapper.CategoryMapper;
import store.product.mapper.ProductCategoryMapper;
import store.product.pojo.vo.ProductVO;
import store.product.service.IProductCategoryService;

/**
 * @creator violet
 * @createTime 2019/3/7
 * @description
 */
@RestController
@Api(tags = {"商品分类"})
@RequestMapping("/productCategoryService")
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @ApiOperation("商品列表")
    @PostMapping("/listProducts")
    public BasePageDTO<ProductVO> listProducts(Long categoryId, PageInfo pageInfo) {

        return null;
    }

    @Override
    @ApiOperation("搜索")
    @PostMapping("/listBySearch")
    public BasePageDTO<ProductVO> listBySearch(String search, PageInfo pageInfo) {
        return null;
    }
}
