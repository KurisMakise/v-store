package store.product.mapper;

import store.product.entity.Kind;

public interface KindMapper {
    int deleteByPrimaryKey(Long kindId);

    int insertSelective(Kind record);

    Kind selectByPrimaryKey(Long kindId);

    int updateByPrimaryKeySelective(Kind record);

    int updateByPrimaryKey(Kind record);
}