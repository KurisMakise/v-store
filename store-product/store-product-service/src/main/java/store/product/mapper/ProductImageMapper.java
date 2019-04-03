package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.ProductImage;
import store.product.pojo.vo.ProductImageVO;

import java.util.List;

public interface ProductImageMapper extends BaseMapper<ProductImage> {

    /**
     *
     * @param productId 商品ID
     * @return 商品展示图
     */
    List<ProductImageVO> getProductImageVO(Long productId);
}