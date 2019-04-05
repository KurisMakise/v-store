package store.user.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import store.common.base.BasePageDTO;
import store.common.constant.CommonReturnCode;
import store.common.exception.ValidationException;
import store.common.support.page.PageInfo;
import store.product.pojo.vo.ProductVO;
import store.user.entity.Favorite;
import store.user.mapper.FavoriteMapper;
import store.user.mapper.UserMapper;
import store.user.pojo.vo.UserVO;
import store.user.service.IFavoriteService;

import java.util.Date;

/**
 * author  violet
 * createTime 2019/3/28 10:47
 * description
 * version 1.0
 */
@Service
public class FavoriteServiceImpl implements IFavoriteService {

    private final FavoriteMapper favoriteMapper;

    private final UserMapper userMapper;


    public FavoriteServiceImpl(FavoriteMapper favoriteMapper, UserMapper userMapper) {
        this.favoriteMapper = favoriteMapper;
        this.userMapper = userMapper;
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

    @Override
    public boolean exists(Long productNumber, Long userId) {
        if (userId == null)
            return false;
        Integer exists = favoriteMapper.exists(productNumber, userId);
        if (exists == null)
            return false;
        return true;
    }

    @Override
    public Integer insert(ProductVO productVO, Long userId) throws ValidationException {
        if (userId == null) {
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);
        }
        if (productVO == null) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM);
        }
        UserVO userVO = userMapper.getUserVOById(userId);
        if (userVO == null) {
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);
        }

        //如果存在不操作
        Favorite favorite = favoriteMapper.get(productVO.getProductId());
        if (favorite != null) {
            throw new ValidationException(CommonReturnCode.SUCCESS.getCode(), "收藏成功");
        }
        favorite = new Favorite();
        favorite.setCreateBy(userVO.getUserName());
        favorite.setCreateTime(new Date());
        favorite.setProductId(productVO.getProductId());
        favorite.setPicImg(productVO.getPicImg());
        favorite.setShowPrice(productVO.getShowPrice());
        favorite.setProductNumber(productVO.getProductNumber());
        favorite.setName(productVO.getName());
        favorite.setUserId(userId);
        return favoriteMapper.insert(favorite);
    }

    @Override
    public Integer delete(Long productNumber, Long userId) throws ValidationException {
        if (productNumber == null) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM);
        }
        if (userId == null) {
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);
        }
        return favoriteMapper.delete(productNumber, userId);
    }
}
