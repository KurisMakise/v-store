package store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import store.common.enums.StatusEnum;
import store.product.entity.Recommend;
import store.product.mapper.ProductRecommendMapper;
import store.product.mapper.RecommendMapper;
import store.product.pojo.vo.ProductVO;
import store.product.service.IProductRecommendService;

import java.util.Date;
import java.util.List;

/**
 * @author  violet
 * @since 2019/3/13
 */
@Service
public class ProductRecommendServiceImpl implements IProductRecommendService {

    private final RecommendMapper recommendMapper;

    private final ProductRecommendMapper productRecommendMapper;

    public ProductRecommendServiceImpl(RecommendMapper recommendMapper, ProductRecommendMapper productRecommendMapper) {
        this.recommendMapper = recommendMapper;
        this.productRecommendMapper = productRecommendMapper;
    }

    @Override
    public List<ProductVO> listByRecommendId(long recommendId) {
        //根据推荐ID得到推荐信息
        QueryWrapper<Recommend> recommendQueryWrapper = new QueryWrapper<>();
        recommendQueryWrapper
                .select("show_number")
                .eq("status", StatusEnum.SHOW.getStatus())
                .eq("recommend_id", recommendId);
        Recommend recommend = recommendMapper.selectOne(recommendQueryWrapper);

        if (recommend != null) {
            return productRecommendMapper.listByRecommendId(recommendId, recommend.getShowNumber(),
                    StatusEnum.SHOW.getStatus(), new Date());
        }
        return null;
    }

    @Override
    public List<ProductVO> listHotComment(long recommendId, int type) {
        List<ProductVO> productVOS = listByRecommendId(recommendId);
        if (productVOS != null) {
            for (ProductVO product : productVOS) {
                ProductVO hotComment = productRecommendMapper.getHotComment(product.getProductId(), type, StatusEnum.SHOW.getStatus());
                if (hotComment != null) {
                    product.setUserName(hotComment.getUserName());
                    product.setCommentId(hotComment.getCommentId());
                    product.setContent(hotComment.getContent());
                }
            }
            return productVOS;
        }
        return null;
    }
}
