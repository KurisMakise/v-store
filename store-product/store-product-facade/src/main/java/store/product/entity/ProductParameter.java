package store.product.entity;

import java.util.Date;

public class ProductParameter {
    private Long productParameterId;

    private Long productId;

    private String name;

    private String value;

    private Byte status;

    private Integer sort;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public ProductParameter(Long productParameterId, Long productId, String name, String value, Byte status, Integer sort, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.productParameterId = productParameterId;
        this.productId = productId;
        this.name = name;
        this.value = value;
        this.status = status;
        this.sort = sort;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public ProductParameter() {
        super();
    }

    public Long getProductParameterId() {
        return productParameterId;
    }

    public void setProductParameterId(Long productParameterId) {
        this.productParameterId = productParameterId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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