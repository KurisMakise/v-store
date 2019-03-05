package store.online.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("os_advert_detail")
public class AdvertDetail {
    @TableId("advert_detail_id")
    private Long advertDetailId;

    @TableField("advert_id")
    private Long advertId;

    private String title;

    private Integer sort;

    private String href;

    private Byte status;

    private String picImg;

    @TableField("create_time")
    private Date createTime;

    @TableField("create_by")
    private String createBy;

    @TableField("update_time")
    private Date updateTime;

    @TableField("update_by")
    private String updateBy;

    private String remarks;

    @TableField("begin_time")
    private Date beginTime;

    @TableField("end_time")
    private Date endTime;

    private String content;

    public AdvertDetail(Long advertDetailId, Long advertId, String title, Integer sort, String href, Byte status, String picImg, Date createTime, String createBy, Date updateTime, String updateBy, String remarks, Date beginTime, Date endTime, String content) {
        this.advertDetailId = advertDetailId;
        this.advertId = advertId;
        this.title = title;
        this.sort = sort;
        this.href = href;
        this.status = status;
        this.picImg = picImg;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.remarks = remarks;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.content = content;
    }

    public AdvertDetail() {
        super();
    }

    public Long getAdvertDetailId() {
        return advertDetailId;
    }

    public void setAdvertDetailId(Long advertDetailId) {
        this.advertDetailId = advertDetailId;
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}