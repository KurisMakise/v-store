package store.product.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
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
@Service
public class ProductServiceImpl implements IProductService {

    private final ProductMapper productMapper;


    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }


    @Override
    public ProductVO getProductVO(Long productNumber) {
        ProductVO productVO = productMapper.getProductVOByNumber(productNumber);
        if (productVO == null)
            productVO = getProductVOById(productNumber);
        return productVO;
    }

    @Override
    public ProductVO getProductVOById(Long productId) {
        ProductVO productVO = productMapper.getProductVOById(productId);
        if (productVO == null)
            productVO = getProductVO(productId);
        return productVO;
    }

    @Override
    public void listProductVO(List<Long> categoryIds, Integer showInShelve, String search, Page<ProductVO> page) {
        List<ProductVO> productVOS = productMapper.listProductVO(categoryIds, showInShelve, search, page);
        page.setRecords(productVOS);
    }
}
