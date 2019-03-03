package store.product.entity;

import java.util.Date;

public class Specification {
    private Long specificationId;

    private Long categoryId;

    private String name;

    private Byte status;

    private Integer sort;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Specification(Long specificationId, Long categoryId, String name, Byte status, Integer sort, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.specificationId = specificationId;
        this.categoryId = categoryId;
        this.name = name;
        this.status = status;
        this.sort = sort;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public Specification() {
        super();
    }

    public Long getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Long specificationId) {
        this.specificationId = specificationId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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