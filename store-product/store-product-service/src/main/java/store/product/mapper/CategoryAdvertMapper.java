package store.product.mapper;

import store.product.entity.CategoryAdvert;

public interface CategoryAdvertMapper {
    int deleteByPrimaryKey(Long categoryAdvertId);

    int insert(CategoryAdvert record);

    int insertSelective(CategoryAdvert record);

    CategoryAdvert selectByPrimaryKey(Long categoryAdvertId);

    int updateByPrimaryKeySelective(CategoryAdvert record);

    int updateByPrimaryKey(CategoryAdvert record);
}