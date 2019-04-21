package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.product.pojo.vo.ProductVO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */

@FeignClient(name = "store-product-service/productCategoryService")
public interface IProductCategoryService {
    /**
     * 根据类目ID、排序、分页查找显示商品列表
     *
     * @param categoryId 类目ID
     * @param pageInfo   分页实体
     * @return
     */
    @PostMapping("/listProducts")
    BasePageDTO<ProductVO> listProducts(@RequestParam("categoryId") Long categoryId,
                                        @RequestBody PageInfo pageInfo);

    /**
     * 根据搜索内容、排序、分页查找商品
     *
     * @param search   搜索内容
     * @param pageInfo 排序、分页方式
     * @return
     */
    @PostMapping("/listBySearch")
    BasePageDTO<ProductVO> listBySearch(@RequestParam("search") String search,
                                        @RequestBody PageInfo pageInfo);

}
