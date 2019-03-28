package store.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.user.entity.Favorite;

public interface FavoriteMapper extends BaseMapper<Favorite> {
    int deleteByPrimaryKey(Long favoriteId);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(Long favoriteId);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);
}