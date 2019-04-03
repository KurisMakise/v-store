package store.product.pojo.vo;

import java.util.List;

/**
 * author  violet
 * createTime 2019/4/2 22:56
 * description 规格属性
 * version 1.0
 */
public class SpecificationVO {
    //规格ID
    private Long specificationId;
    //规格名称
    private String specName;

    private List<SpecificationAttributeVO> specificationAttributeVOS;

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public List<SpecificationAttributeVO> getSpecificationAttributeVOS() {
        return specificationAttributeVOS;
    }

    public void setSpecificationAttributeVOS(List<SpecificationAttributeVO> specificationAttributeVOS) {
        this.specificationAttributeVOS = specificationAttributeVOS;
    }
}
