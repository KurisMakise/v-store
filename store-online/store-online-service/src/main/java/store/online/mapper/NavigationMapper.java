package store.online.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.online.entity.Navigation;

public interface NavigationMapper extends BaseMapper<Navigation> {
    int deleteByPrimaryKey(Long navigationId);

    int insert(Navigation record);

    int insertSelective(Navigation record);

    Navigation selectByPrimaryKey(Long navigationId);

    int updateByPrimaryKeySelective(Navigation record);

    int updateByPrimaryKey(Navigation record);
}