package store.online.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("os_navigation_bar")
public class NavigationBar {
    @TableId("navigation_bar_id")
    private Long navigationBarId;

    private Long navigationId;

    private String name;

    private String target;

    private Integer sort;

    private String href;

    private Byte status;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String remarks;

    public NavigationBar(Long navigationBarId, Long navigationId, String name, String target, Integer sort, String href, Byte status, Date createTime, String createBy, Date updateTime, String updateBy, String remarks) {
        this.navigationBarId = navigationBarId;
        this.navigationId = navigationId;
        this.name = name;
        this.target = target;
        this.sort = sort;
        this.href = href;
        this.status = status;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.remarks = remarks;
    }

    public NavigationBar() {
        super();
    }

    public Long getNavigationBarId() {
        return navigationBarId;
    }

    public void setNavigationBarId(Long navigationBarId) {
        this.navigationBarId = navigationBarId;
    }

    public Long getNavigationId() {
        return navigationId;
    }

    public void setNavigationId(Long navigationId) {
        this.navigationId = navigationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}