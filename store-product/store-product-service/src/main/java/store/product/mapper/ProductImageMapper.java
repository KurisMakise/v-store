package store.product.mapper;

import store.product.entity.ProductImage;

public interface ProductImageMapper {
    int deleteByPrimaryKey(Long picImgId);

    int insertSelective(ProductImage record);

    ProductImage selectByPrimaryKey(Long picImgId);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}