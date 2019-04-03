package store.product.service.impl;

import org.springframework.stereotype.Service;
import store.product.mapper.ProductMapper;
import store.product.pojo.vo.ProductVO;
import store.product.service.IProductService;

/**
 * author  violet
 * createTime 2019/4/2 14:38
 * description
 * version 1.0
 */
@Service
public class ProductServiceImpl implements IProductService {

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    @Override
    public ProductVO getProductVO(Long productNumber) {
        return productMapper.getProductVOByNumber(productNumber);
    }
}
