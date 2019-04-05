package store.product.service.impl;

import org.springframework.stereotype.Service;
import store.product.mapper.ProductSpecificationMapper;
import store.product.pojo.dto.ProductSpecificationDTO;
import store.product.pojo.vo.ProductSpecificationVO;
import store.product.pojo.vo.SpecificationVO;
import store.product.service.IProductSpecificationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author  violet
 * createTime 2019/4/2 17:29
 * description
 * version 1.0
 */
@Service
public class ProductSpecificationServiceImpl implements IProductSpecificationService {
    private final ProductSpecificationMapper productSpecificationMapper;

    public ProductSpecificationServiceImpl(ProductSpecificationMapper productSpecificationMapper) {
        this.productSpecificationMapper = productSpecificationMapper;
    }

    @Override
    public ProductSpecificationDTO listProductSpec(Long productId, Integer status) {
        //商品详情
        List<ProductSpecificationVO> productSpecificationVOS = productSpecificationMapper.listProductSpecVO(productId, status);

        //商品规格
        List<SpecificationVO> specificationVOS = productSpecificationMapper.listSpecVO(status);

        //将商品规格作为key
        Map<String, ProductSpecificationVO> specificationVOMap = new HashMap<>();
        for (ProductSpecificationVO vo : productSpecificationVOS) {
            String key = String.valueOf(vo.getSpecAttrIds());
            specificationVOMap.put(key, vo);
        }

        return new ProductSpecificationDTO(specificationVOMap, specificationVOS);
    }
}
