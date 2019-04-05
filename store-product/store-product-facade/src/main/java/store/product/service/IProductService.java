package store.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import store.product.pojo.vo.ProductVO;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public interface IProductService {

    ProductVO getProductVO(Long productNumber);

    ProductVO getProductVOById(Long productId);

    void listProductVO(List<Long> categoryIds, Integer showInShelve, String search, Page<ProductVO> page);
}
