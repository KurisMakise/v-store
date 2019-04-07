package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import store.product.entity.Product;
import store.product.pojo.vo.ProductVO;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {
    ProductVO getProductVOByNumber(Long productNumber);

    ProductVO getProductVOById(Long productId);

    List<ProductVO> listProductVO(List<Long> categoryIds, Integer showInShelve, String search, Page<ProductVO> page);

}