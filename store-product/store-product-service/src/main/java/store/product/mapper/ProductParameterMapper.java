package store.product.mapper;

import store.product.entity.ProductParameter;

public interface ProductParameterMapper {
    int deleteByPrimaryKey(Long productParameterId);

    int insert(ProductParameter record);

    int insertSelective(ProductParameter record);

    ProductParameter selectByPrimaryKey(Long productParameterId);

    int updateByPrimaryKeySelective(ProductParameter record);

    int updateByPrimaryKey(ProductParameter record);
}