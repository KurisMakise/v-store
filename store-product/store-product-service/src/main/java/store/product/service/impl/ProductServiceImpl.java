package store.product.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.product.mapper.ProductMapper;
import store.product.pojo.vo.ProductVO;
import store.product.service.IProductService;

import java.util.List;

/**
 * author  violet
 * createTime 2019/4/2 14:38
 * description
 * version 1.0
 */
@RestController
@Api("商品服务")
@RequestMapping("/productService")
public class ProductServiceImpl implements IProductService {

    private final ProductMapper productMapper;


    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    @Override
    @ApiOperation("获取商品")
    @GetMapping("/getProductVO")
    public ProductVO getProductVO(Long productNumber) {
        ProductVO productVO = productMapper.getProductVOByNumber(productNumber);
        if (productVO == null)
            productVO = getProductVOById(productNumber);
        return productVO;
    }

    @Override
    @ApiOperation("获取商品(by ID)")
    @GetMapping("/getProductVOById")
    public ProductVO getProductVOById(Long productId) {
        ProductVO productVO = productMapper.getProductVOById(productId);
        if (productVO == null)
            productVO = getProductVO(productId);
        return productVO;
    }

    @Override
    @ApiOperation("商品列表")
    @GetMapping("/listProductVO")
    public void listProductVO(List<Long> categoryIds, Integer showInShelve, String search, Page<ProductVO> page) {
        List<ProductVO> productVOS = productMapper.listProductVO(categoryIds, showInShelve, search, page);
        page.setRecords(productVOS);
    }
}
