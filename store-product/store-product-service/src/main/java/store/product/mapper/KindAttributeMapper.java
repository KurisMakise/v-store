package store.product.mapper;

import store.product.entity.KindAttribute;

public interface KindAttributeMapper {
    int deleteByPrimaryKey(Long kindAttrId);

    int insert(KindAttribute record);

    int insertSelective(KindAttribute record);

    KindAttribute selectByPrimaryKey(Long kindAttrId);

    int updateByPrimaryKeySelective(KindAttribute record);

    int updateByPrimaryKey(KindAttribute record);
}