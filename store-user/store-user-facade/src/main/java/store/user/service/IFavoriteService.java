package store.user.service;

import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.user.entity.Favorite;

/**
 * author  violet
 * createTime 2019/3/28 10:47
 * description
 * version 1.0
 */
public interface IFavoriteService {

    BasePageDTO<Favorite> listByUserId(Long userId, PageInfo pageInfo);

    Integer deleteByProductNumber(Long productNumber, Long userId);
}
