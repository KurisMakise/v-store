package store.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.user.entity.Favorite;

public interface FavoriteMapper extends BaseMapper<Favorite> {

    Integer exists(Long productNumber, Long userId);

    Favorite get(Long productId);

    Integer delete(Long productNumber, Long userId);
}