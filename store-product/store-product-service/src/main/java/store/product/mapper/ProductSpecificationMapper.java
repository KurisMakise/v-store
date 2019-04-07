package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.ProductSpecification;
import store.product.pojo.vo.ProductSpecificationVO;
import store.product.pojo.vo.SpecificationVO;

import java.util.List;

public interface ProductSpecificationMapper extends BaseMapper<ProductSpecification> {

    List<ProductSpecificationVO> listProductSpecVO(Long productId, Integer status);

    List<SpecificationVO> listSpecVO(Long productId, Integer status);

}