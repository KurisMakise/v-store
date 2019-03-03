package store.online.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.online.entity.NavigationBar;

public interface NavigationBarMapper extends BaseMapper<NavigationBar> {
    int deleteByPrimaryKey(Long navigationBarId);

    int insert(NavigationBar record);

    int insertSelective(NavigationBar record);

    NavigationBar selectByPrimaryKey(Long navigationBarId);

    int updateByPrimaryKeySelective(NavigationBar record);

    int updateByPrimaryKey(NavigationBar record);
}