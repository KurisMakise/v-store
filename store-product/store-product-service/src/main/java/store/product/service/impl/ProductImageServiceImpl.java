package store.product.service.impl;

import org.springframework.stereotype.Service;
import store.product.mapper.ProductImageMapper;
import store.product.pojo.vo.ProductImageVO;
import store.product.service.IProductImageService;

import java.util.List;

/**
 * author  violet
 * createTime 2019/4/2 16:23
 * description TODO
 * version 1.0
 */
@Service
public class ProductImageServiceImpl implements IProductImageService {

    private final ProductImageMapper productImageMapper;

    public ProductImageServiceImpl(ProductImageMapper productImageMapper) {
        this.productImageMapper = productImageMapper;
    }

    @Override
    public List<ProductImageVO> getProductImageVO(Long productId) {
        return productImageMapper.getProductImageVO(productId);
    }
}
