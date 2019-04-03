package store.product.pojo.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * author  violet
 * createTime 2019/4/2 17:31
 * description 商品规格VO
 * version 1.0
 */
public class ProductSpecificationVO {

    private Long productSpecNumber;

    /**
     * 规格属性ID
     */
    private List<Long> specAttrIds;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 积分
     */
    private Long score;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 销售量
     */
    private Integer salesVolume;

    public Long getProductSpecNumber() {
        return productSpecNumber;
    }

    public void setProductSpecNumber(Long productSpecNumber) {
        this.productSpecNumber = productSpecNumber;
    }

    public List<Long> getSpecAttrIds() {
        return specAttrIds;
    }

    public void setSpecAttrIds(List<Long> specAttrIds) {
        this.specAttrIds = specAttrIds;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }
}
