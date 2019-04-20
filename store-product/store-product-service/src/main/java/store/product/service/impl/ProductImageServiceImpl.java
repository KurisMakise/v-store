package store.product.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.product.mapper.ProductImageMapper;
import store.product.pojo.vo.ProductImageVO;
import store.product.service.IProductImageService;

import java.util.List;

/**
 * author  violet
 * createTime 2019/4/2 16:23
 * description 商品图片
 * version 1.0
 */
@RestController
@Api(tags = {"商品图片"})
@RequestMapping("/productImageService")
public class ProductImageServiceImpl implements IProductImageService {

    private final ProductImageMapper productImageMapper;

    public ProductImageServiceImpl(ProductImageMapper productImageMapper) {
        this.productImageMapper = productImageMapper;
    }

    @Override
    @ApiOperation("获取商品")
    @GetMapping("/getProductImageVO")
    public List<ProductImageVO> getProductImageVO(Long productId) {
        return productImageMapper.getProductImageVO(productId);
    }
}
