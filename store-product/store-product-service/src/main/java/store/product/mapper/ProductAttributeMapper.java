package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.ProductAttribute;
import store.product.pojo.vo.ProductAttributeVO;

public interface ProductAttributeMapper extends BaseMapper<ProductAttribute> {

    ProductAttributeVO getProductAttrVO(Long productId);
}