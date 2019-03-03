package store.product.mapper;

import store.product.entity.Recommend;

public interface RecommendMapper {
    int deleteByPrimaryKey(Long recommendId);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    Recommend selectByPrimaryKey(Long recommendId);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}