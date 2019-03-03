package store.product.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ProductSpecification {
    private Long productSpecId;

    private Long productSpecNumber;

    private Long productId;

    private String spec;

    private Integer stock;

    private Integer salesVolume;

    private BigDecimal price;

    private Integer score;

    private Byte defaultStatus;

    private Byte status;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public ProductSpecification(Long productSpecId, Long productSpecNumber, Long productId, String spec, Integer stock, Integer salesVolume, BigDecimal price, Integer score, Byte defaultStatus, Byte status, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.productSpecId = productSpecId;
        this.productSpecNumber = productSpecNumber;
        this.productId = productId;
        this.spec = spec;
        this.stock = stock;
        this.salesVolume = salesVolume;
        this.price = price;
        this.score = score;
        this.defaultStatus = defaultStatus;
        this.status = status;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public ProductSpecification() {
        super();
    }

    public Long getProductSpecId() {
        return productSpecId;
    }

    public void setProductSpecId(Long productSpecId) {
        this.productSpecId = productSpecId;
    }

    public Long getProductSpecNumber() {
        return productSpecNumber;
    }

    public void setProductSpecNumber(Long productSpecNumber) {
        this.productSpecNumber = productSpecNumber;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Byte getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Byte defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}