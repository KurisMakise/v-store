package store.order.pojo.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * author  violet
 * createTime 2019/3/23 17:54
 * description
 * version 1.0
 */
public class OrderShoppingCartVO {

    private Long orderShipmentId;

    private Long productSpecNumber;
    /**
     * 购买数量
     */
    private Integer buyNumber;
    /**
     * 商品ID
     */
    private Long productNumber;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 展示图片
     */
    private String picImg;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 销售量
     */
    private Integer salesVolume;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 商品总金额
     */
    private BigDecimal productAmount;
    /**
     * 积分
     */
    private Integer score;
    /**
     * 商品总积分
     */
    private Integer productScore;
    /**
     * 规格：规格ID，以“,”相隔
     */
    private String spec;
    /**
     * 规格名称
     */
    private List<String> specificationName;
    /**
     * 商品规格名称
     */
    private String productSpecName;


    public Long getOrderShipmentId() {
        return orderShipmentId;
    }

    public void setOrderShipmentId(Long orderShipmentId) {
        this.orderShipmentId = orderShipmentId;
    }

    public Long getProductSpecNumber() {
        return productSpecNumber;
    }

    public void setProductSpecNumber(Long productSpecNumber) {
        this.productSpecNumber = productSpecNumber;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getProductScore() {
        return productScore;
    }

    public void setProductScore(Integer productScore) {
        this.productScore = productScore;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public List<String> getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(List<String> specificationName) {
        this.specificationName = specificationName;
    }

    public String getProductSpecName() {
        return productSpecName;
    }

    public void setProductSpecName(String productSpecName) {
        this.productSpecName = productSpecName;
    }
}
