package store.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("os_product_recommend")
public class ProductRecommend {
    @TableId
    private Long recommendProductId;

    private Long recommendId;

    private Long productId;

    private Integer sort;

    private Byte status;

    private Date beginTime;

    private Date endTime;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public ProductRecommend(Long recommendProductId, Long recommendId, Long productId, Integer sort, Byte status, Date beginTime, Date endTime, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.recommendProductId = recommendProductId;
        this.recommendId = recommendId;
        this.productId = productId;
        this.sort = sort;
        this.status = status;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public ProductRecommend() {
        super();
    }

    public Long getRecommendProductId() {
        return recommendProductId;
    }

    public void setRecommendProductId(Long recommendProductId) {
        this.recommendProductId = recommendProductId;
    }

    public Long getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(Long recommendId) {
        this.recommendId = recommendId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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