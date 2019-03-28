package store.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("os_category_advert")
public class CategoryAdvert {
    @TableId
    private Long categoryAdvertId;

    private Long categoryId;

    private String title;

    private Integer sort;

    private String href;

    private Byte status;

    private String picImg;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Date beginTime;

    private Date endTime;

    private String remarks;

    public CategoryAdvert(Long categoryAdvertId, Long categoryId, String title, Integer sort, String href, Byte status, String picImg, Date createTime, String createBy, Date updateTime, String updateBy, Date beginTime, Date endTime, String remarks) {
        this.categoryAdvertId = categoryAdvertId;
        this.categoryId = categoryId;
        this.title = title;
        this.sort = sort;
        this.href = href;
        this.status = status;
        this.picImg = picImg;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.remarks = remarks;
    }

    public CategoryAdvert() {
        super();
    }

    public Long getCategoryAdvertId() {
        return categoryAdvertId;
    }

    public void setCategoryAdvertId(Long categoryAdvertId) {
        this.categoryAdvertId = categoryAdvertId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}