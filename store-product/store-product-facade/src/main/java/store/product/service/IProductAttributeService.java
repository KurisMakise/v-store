package store.product.service;

import store.product.pojo.vo.ProductAttributeVO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public interface IProductAttributeService {

    ProductAttributeVO getProductAttrVO(Long productId);

}
