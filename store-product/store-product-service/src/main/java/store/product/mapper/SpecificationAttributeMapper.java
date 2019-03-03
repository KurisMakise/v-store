package store.product.mapper;

import store.product.entity.SpecificationAttribute;

public interface SpecificationAttributeMapper {
    int deleteByPrimaryKey(Long specificationId);

    int insert(SpecificationAttribute record);

    int insertSelective(SpecificationAttribute record);

    SpecificationAttribute selectByPrimaryKey(Long specificationId);

    int updateByPrimaryKeySelective(SpecificationAttribute record);

    int updateByPrimaryKey(SpecificationAttribute record);
}