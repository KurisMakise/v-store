package store.product.mapper;

import store.product.pojo.vo.ProductVO;

public interface ProductMapper {
    ProductVO getProductVOByNumber(Long productNumber);
}