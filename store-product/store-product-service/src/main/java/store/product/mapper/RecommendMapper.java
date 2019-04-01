package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.Recommend;

public interface RecommendMapper extends BaseMapper<Recommend> {
    int deleteByPrimaryKey(Long recommendId);

    int insertSelective(Recommend record);

    Recommend selectByPrimaryKey(Long recommendId);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);
}