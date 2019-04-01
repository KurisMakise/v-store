package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.CategoryAdvert;

public interface CategoryAdvertMapper extends BaseMapper<CategoryAdvert> {
    int deleteByPrimaryKey(Long categoryAdvertId);

    int insertSelective(CategoryAdvert record);

    CategoryAdvert selectByPrimaryKey(Long categoryAdvertId);

    int updateByPrimaryKeySelective(CategoryAdvert record);

    int updateByPrimaryKey(CategoryAdvert record);
}