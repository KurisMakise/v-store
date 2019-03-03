package store.product.entity;

import java.util.Date;

public class KindAttribute {
    private Long kindAttrId;

    private Long kindId;

    private Long specAttrId;

    private String name;

    private Byte status;

    private Integer sort;

    private String createBy;

    private Date createTime;

    public KindAttribute(Long kindAttrId, Long kindId, Long specAttrId, String name, Byte status, Integer sort, String createBy, Date createTime) {
        this.kindAttrId = kindAttrId;
        this.kindId = kindId;
        this.specAttrId = specAttrId;
        this.name = name;
        this.status = status;
        this.sort = sort;
        this.createBy = createBy;
        this.createTime = createTime;
    }

    public KindAttribute() {
        super();
    }

    public Long getKindAttrId() {
        return kindAttrId;
    }

    public void setKindAttrId(Long kindAttrId) {
        this.kindAttrId = kindAttrId;
    }

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public Long getSpecAttrId() {
        return specAttrId;
    }

    public void setSpecAttrId(Long specAttrId) {
        this.specAttrId = specAttrId;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}