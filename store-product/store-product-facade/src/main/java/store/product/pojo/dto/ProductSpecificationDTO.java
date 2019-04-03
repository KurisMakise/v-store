package store.product.pojo.dto;

import store.product.pojo.vo.ProductSpecificationVO;
import store.product.pojo.vo.SpecificationVO;

import java.util.List;
import java.util.Map;

/**
 * author  violet
 * createTime 2019/4/3 15:51
 * description
 * version 1.0
 */
public class ProductSpecificationDTO {
    public ProductSpecificationDTO(){

    }

    public ProductSpecificationDTO(Map<String, ProductSpecificationVO> productSpecificationVOS, List<SpecificationVO> specificationVOS) {
        this.productSpecificationVOS = productSpecificationVOS;
        this.specificationVOS = specificationVOS;
    }

    private Map<String, ProductSpecificationVO> productSpecificationVOS;

    private List<SpecificationVO> specificationVOS;

    public Map<String, ProductSpecificationVO> getProductSpecificationVOS() {
        return productSpecificationVOS;
    }

    public void setProductSpecificationVOS(Map<String, ProductSpecificationVO> productSpecificationVOS) {
        this.productSpecificationVOS = productSpecificationVOS;
    }

    public List<SpecificationVO> getSpecificationVOS() {
        return specificationVOS;
    }

    public void setSpecificationVOS(List<SpecificationVO> specificationVOS) {
        this.specificationVOS = specificationVOS;
    }
}
