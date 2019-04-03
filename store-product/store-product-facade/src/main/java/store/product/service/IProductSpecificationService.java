package store.product.service;

import store.product.pojo.dto.ProductSpecificationDTO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public interface IProductSpecificationService {

    ProductSpecificationDTO listProductSpec(Long productId, Integer status);
}
