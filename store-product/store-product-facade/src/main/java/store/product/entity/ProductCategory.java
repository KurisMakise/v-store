package store.product.entity;

import java.util.Date;

public class ProductCategory {
    private Long productCategoryId;

    private Long productId;

    private Long categoryId;

    private Date createTime;

    private String createBy;

    public ProductCategory(Long productCategoryId, Long productId, Long categoryId, Date createTime, String createBy) {
        this.productCategoryId = productCategoryId;
        this.productId = productId;
        this.categoryId = categoryId;
        this.createTime = createTime;
        this.createBy = createBy;
    }

    public ProductCategory() {
        super();
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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
}