package store.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.user.entity.Favorite;
import store.user.mapper.FavoriteMapper;
import store.user.service.IFavoriteService;

/**
 * author  violet
 * createTime 2019/3/28 10:47
 * description
 * version 1.0
 */
@Service
public class FavoriteServiceImpl implements IFavoriteService {

    private final FavoriteMapper favoriteMapper;

    public FavoriteServiceImpl(FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }

    @Override
    public BasePageDTO<Favorite> listByUserId(Long userId, PageInfo pageInfo) {
        QueryWrapper<Favorite> favoriteQueryWrapper = new QueryWrapper<>();
        favoriteQueryWrapper.eq("user_id", userId);

        Page<Favorite> favoritePage = new Page<>(pageInfo.getCurrent(), pageInfo.getLimit());
        IPage<Favorite> favoriteIPage = favoriteMapper.selectPage(favoritePage, favoriteQueryWrapper);
        pageInfo.setTotal(favoriteIPage.getTotal());

        return new BasePageDTO<>(pageInfo, favoriteIPage.getRecords());
    }

    @Override
    public Integer deleteByProductNumber(Long productNumber, Long userId) {

        return null;
    }
}
