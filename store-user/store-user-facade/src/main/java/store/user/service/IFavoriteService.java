package store.user.service;

import store.common.base.BasePageDTO;
import store.common.exception.ValidationException;
import store.common.support.page.PageInfo;
import store.product.pojo.vo.ProductVO;
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

    boolean exists(Long productNumber, Long userId);

    Integer insert(ProductVO productVO, Long userId) throws ValidationException;

    Integer delete(Long productNumber, Long userId) throws ValidationException;
}
