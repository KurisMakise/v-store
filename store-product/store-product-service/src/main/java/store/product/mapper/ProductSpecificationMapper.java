package store.product.mapper;

import store.product.pojo.vo.ProductSpecificationVO;
import store.product.pojo.vo.SpecificationVO;

import java.util.List;

public interface ProductSpecificationMapper {

    List<ProductSpecificationVO> listProductSpecVO(Long productId, Integer status);

    List<SpecificationVO> listSpecVO(Integer status);
}