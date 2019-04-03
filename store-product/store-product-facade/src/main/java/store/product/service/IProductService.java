package store.product.service;

import store.product.pojo.vo.ProductVO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public interface IProductService {

    ProductVO getProductVO(Long productNumber);

}
