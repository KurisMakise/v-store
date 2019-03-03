package store.online.entity;

import java.util.Date;

public class Navigation {
    private Long navigationId;

    private String code;

    private String name;

    private Byte status;

    private Integer number;

    private Integer showNumber;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String remarks;

    public Navigation(Long navigationId, String code, String name, Byte status, Integer number, Integer showNumber, Date createTime, String createBy, Date updateTime, String updateBy, String remarks) {
        this.navigationId = navigationId;
        this.code = code;
        this.name = name;
        this.status = status;
        this.number = number;
        this.showNumber = showNumber;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.remarks = remarks;
    }

    public Navigation() {
        super();
    }

    public Long getNavigationId() {
        return navigationId;
    }

    public void setNavigationId(Long navigationId) {
        this.navigationId = navigationId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}