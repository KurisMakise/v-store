package store.product.entity;

import java.util.Date;

public class Recommend {
    private Long recommendId;

    private String name;

    private String code;

    private Integer number;

    private Integer showNumber;

    private Byte status;

    private String remarks;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Recommend(Long recommendId, String name, String code, Integer number, Integer showNumber, Byte status, String remarks, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.recommendId = recommendId;
        this.name = name;
        this.code = code;
        this.number = number;
        this.showNumber = showNumber;
        this.status = status;
        this.remarks = remarks;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public Recommend() {
        super();
    }

    public Long getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Long recommendId) {
        this.recommendId = recommendId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(Integer showNumber) {
        this.showNumber = showNumber;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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