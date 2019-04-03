package store.product.pojo.vo;

/**
 * author  violet
 * createTime 2019/4/3 14:57
 * description 规格属性
 * version 1.0
 */
public class SpecificationAttributeVO {

    /**
     * 规格属性
     */
    private Long specAttrId;

    /**
     * 规格属性ID
     */
    private String specAttrName;

    public Long getSpecAttrId() {
        return specAttrId;
    }

    public void setSpecAttrId(Long specAttrId) {
        this.specAttrId = specAttrId;
    }

    public String getSpecAttrName() {
        return specAttrName;
    }

    public void setSpecAttrName(String specAttrName) {
        this.specAttrName = specAttrName;
    }
}
