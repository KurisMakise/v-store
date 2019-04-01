package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.Label;

public interface LabelMapper extends BaseMapper<Label> {
    int deleteByPrimaryKey(Integer labelId);

    int insertSelective(Label record);

    Label selectByPrimaryKey(Integer labelId);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}