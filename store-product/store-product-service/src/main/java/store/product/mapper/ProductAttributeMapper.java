package store.product.mapper;

import store.product.entity.ProductAttribute;

public interface ProductAttributeMapper {
    int deleteByPrimaryKey(Long attributeId);

    int insert(ProductAttribute record);

    int insertSelective(ProductAttribute record);

    ProductAttribute selectByPrimaryKey(Long attributeId);

    int updateByPrimaryKeySelective(ProductAttribute record);

    int updateByPrimaryKey(ProductAttribute record);
}