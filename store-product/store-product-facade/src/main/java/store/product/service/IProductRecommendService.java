package store.product.service;

import store.product.pojo.vo.ProductVO;

import java.util.Date;
import java.util.List;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
public interface IProductRecommendService {

    /**
     *
     * @param recommendId 推荐ID
     * @return
     */
    List<ProductVO> listByRecommendId(long recommendId);

    /**
     *
     * @param recommendId 推荐ID
     * @param commentType 评论类型
     * @return
     */
    List<ProductVO> listHotComment(long recommendId, int commentType);
}
