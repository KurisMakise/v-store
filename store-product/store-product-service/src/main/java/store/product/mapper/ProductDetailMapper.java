package store.product.mapper;

import store.product.entity.ProductDetail;

public interface ProductDetailMapper {
    int deleteByPrimaryKey(Long productDetailId);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Long productDetailId);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKeyWithBLOBs(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);
}