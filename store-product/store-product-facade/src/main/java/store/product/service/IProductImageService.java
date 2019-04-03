package store.product.service;

import store.product.pojo.vo.ProductImageVO;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public interface IProductImageService {
    List<ProductImageVO> getProductImageVO(Long productId);
}
