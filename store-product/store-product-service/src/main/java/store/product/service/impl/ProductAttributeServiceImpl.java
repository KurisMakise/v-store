package store.product.service.impl;

import org.springframework.stereotype.Service;
import store.product.mapper.ProductAttributeMapper;
import store.product.pojo.vo.ProductAttributeVO;
import store.product.service.IProductAttributeService;

/**
 * author  violet
 * createTime 2019/4/2 23:22
 * description
 * version 1.0
 */
@Service
public class ProductAttributeServiceImpl implements IProductAttributeService {

    private final ProductAttributeMapper productAttributeMapper;

    public ProductAttributeServiceImpl(ProductAttributeMapper productAttributeMapper) {
        this.productAttributeMapper = productAttributeMapper;
    }

    @Override
    public ProductAttributeVO getProductAttrVO(Long productId) {
        return productAttributeMapper.getProductAttrVO(productId);
    }
}
