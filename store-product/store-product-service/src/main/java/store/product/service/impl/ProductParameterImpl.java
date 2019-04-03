package store.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.product.mapper.ProductParameterMapper;
import store.product.pojo.vo.ProductParameterVO;
import store.product.service.IProductParameterService;

import java.util.List;

/**
 * author  violet
 * createTime 2019/4/2 18:31
 * description 商品参数
 * version 1.0
 */
@Service
public class ProductParameterImpl implements IProductParameterService {
    private final ProductParameterMapper productParameterMapper;

    public ProductParameterImpl(ProductParameterMapper productParameterMapper) {
        this.productParameterMapper = productParameterMapper;
    }

    @Override
    public List<ProductParameterVO> listProductParameterVO(Long productId, Integer status) {
        return productParameterMapper.listProductParameterVO(productId, status);
    }
}
