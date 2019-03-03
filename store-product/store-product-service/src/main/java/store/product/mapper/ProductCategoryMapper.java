package store.product.mapper;

import store.product.entity.ProductCategory;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Long productCategoryId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Long productCategoryId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}