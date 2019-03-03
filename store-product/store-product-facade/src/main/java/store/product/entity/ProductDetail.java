package store.product.entity;

import java.util.Date;

public class ProductDetail {
    private Long productDetailId;

    private Long productId;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String description;

    public ProductDetail(Long productDetailId, Long productId, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.productDetailId = productDetailId;
        this.productId = productId;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public ProductDetail(Long productDetailId, Long productId, Date createTime, String createBy, Date updateTime, String updateBy, String description) {
        this.productDetailId = productDetailId;
        this.productId = productId;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.description = description;
    }

    public ProductDetail() {
        super();
    }

    public Long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}