package store.product.mapper;

import store.product.entity.Specification;

public interface SpecificationMapper {
    int deleteByPrimaryKey(Long specificationId);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Long specificationId);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}