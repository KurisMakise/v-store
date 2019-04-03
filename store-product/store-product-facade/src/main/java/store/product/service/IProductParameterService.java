package store.product.service;

import store.product.pojo.vo.ProductParameterVO;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public interface IProductParameterService {

    List<ProductParameterVO> listProductParameterVO(Long productId, Integer status);
}
