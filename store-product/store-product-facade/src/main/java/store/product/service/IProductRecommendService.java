package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.product.pojo.vo.ProductVO;

import java.util.Date;
import java.util.List;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */

@FeignClient("store-product-service/productRecommendService")
public interface IProductRecommendService {

    /**
     *
     * @param recommendId 推荐ID
     * @return
     */

    @PostMapping("/listByRecommendId")
    List<ProductVO> listByRecommendId(@RequestParam("recommendId") long recommendId);

    /**
     *
     * @param recommendId 推荐ID
     * @param commentType 评论类型
     * @return
     */
    @PostMapping("/listHotComment")
    List<ProductVO> listHotComment(@RequestParam("recommendId") long recommendId,
                                   @RequestParam("commentType") int commentType);
}
