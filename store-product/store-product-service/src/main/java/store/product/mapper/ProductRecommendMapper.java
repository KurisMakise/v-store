package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.ProductRecommend;
import store.product.pojo.vo.ProductVO;

import java.util.Date;
import java.util.List;

public interface ProductRecommendMapper extends BaseMapper<ProductRecommend> {
    /**
     * @param recommendId 推荐id
     * @param showNumber  显示数量
     * @param status      状态
     * @param date        显示日期
     * @return
     */
    List<ProductVO> listByRecommendId(long recommendId, int showNumber, int status, Date date);

    /**
     *
     * @param productId 推荐id
     * @param commentType 评论类型
     * @param status 状态
     * @return
     */
    ProductVO getHotComment(long productId,int commentType,int status);

    int deleteByPrimaryKey(Long recommendProductId);

    int insertSelective(ProductRecommend record);

    ProductRecommend selectByPrimaryKey(Long recommendProductId);

    int updateByPrimaryKeySelective(ProductRecommend record);

    int updateByPrimaryKey(ProductRecommend record);
}