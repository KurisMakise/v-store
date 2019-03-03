package store.product.mapper;

import store.product.entity.ProductSpecification;

public interface ProductSpecificationMapper {
    int deleteByPrimaryKey(Long productSpecId);

    int insert(ProductSpecification record);

    int insertSelective(ProductSpecification record);

    ProductSpecification selectByPrimaryKey(Long productSpecId);

    int updateByPrimaryKeySelective(ProductSpecification record);

    int updateByPrimaryKey(ProductSpecification record);
}