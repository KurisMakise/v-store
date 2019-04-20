package store.product.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RestController
@Api(tags = {"商品规格"})
@RequestMapping("/productSpecificationService")
public class ProductSpecificationServiceImpl implements IProductSpecificationService {
    private final ProductSpecificationMapper productSpecificationMapper;

    public ProductSpecificationServiceImpl(ProductSpecificationMapper productSpecificationMapper) {
        this.productSpecificationMapper = productSpecificationMapper;
    }

    @Override
    @ApiOperation("商品规格列表")
    @GetMapping("/listProductSpec")
    public ProductSpecificationDTO listProductSpec(Long productId, Integer status) {
        //商品详情
        List<ProductSpecificationVO> productSpecificationVOS = productSpecificationMapper.listProductSpecVO(productId, status);

        //商品规格
        List<SpecificationVO> specificationVOS = productSpecificationMapper.listSpecVO(productId, status);

        //将商品规格作为key
        Map<String, ProductSpecificationVO> specificationVOMap = new HashMap<>();
        for (ProductSpecificationVO vo : productSpecificationVOS) {
            String key = String.valueOf(vo.getSpecAttrIds());
            if ("[]".equals(key)) {
                key = "default";
            }
            specificationVOMap.put(key, vo);
        }

        return new ProductSpecificationDTO(specificationVOMap, specificationVOS);
    }
}
