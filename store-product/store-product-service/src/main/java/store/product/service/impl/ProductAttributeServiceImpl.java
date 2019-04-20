package store.product.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.product.mapper.ProductAttributeMapper;
import store.product.pojo.vo.ProductAttributeVO;
import store.product.service.IProductAttributeService;

/**
 * author  violet
 * createTime 2019/4/2 23:22
 * description
 * version 1.0
 */
@RestController
@Api(tags = {"商品属性"})
@RequestMapping("/productAttributeService")
public class ProductAttributeServiceImpl implements IProductAttributeService {

    private final ProductAttributeMapper productAttributeMapper;

    public ProductAttributeServiceImpl(ProductAttributeMapper productAttributeMapper) {
        this.productAttributeMapper = productAttributeMapper;
    }

    @Override
    @ApiOperation("获取商品属性")
    @GetMapping("/getProductAttrVO")
    public ProductAttributeVO getProductAttrVO(Long productId) {
        return productAttributeMapper.getProductAttrVO(productId);
    }
}
