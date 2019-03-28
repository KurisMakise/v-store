package store.product.service;

import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.product.pojo.vo.ProductVO;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
public interface IProductCategoryService {
    /**
     * 根据类目ID、排序、分页查找显示商品列表
     *
     * @param categoryId 类目ID
     * @param pageInfo   分页实体
     * @return
     */
    BasePageDTO<ProductVO> listProducts(Long categoryId, PageInfo pageInfo);

    /**
     * 根据搜索内容、排序、分页查找商品
     *
     * @param search   搜索内容
     * @param pageInfo 排序、分页方式
     * @return
     */
    BasePageDTO<ProductVO> listBySearch(String search, PageInfo pageInfo);
}
