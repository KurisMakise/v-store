package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.ProductParameter;
import store.product.pojo.vo.ProductParameterVO;

import java.util.List;

public interface ProductParameterMapper extends BaseMapper<ProductParameter> {

    List<ProductParameterVO> listProductParameterVO(Long productId, Integer status);

}