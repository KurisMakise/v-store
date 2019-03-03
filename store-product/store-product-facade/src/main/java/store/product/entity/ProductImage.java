package store.product.entity;

import java.util.Date;

public class ProductImage {
    private Long picImgId;

    private Long productId;

    private String picImg;

    private Byte sort;

    private Byte status;

    private Date createTime;

    private String createBy;

    public ProductImage(Long picImgId, Long productId, String picImg, Byte sort, Byte status, Date createTime, String createBy) {
        this.picImgId = picImgId;
        this.productId = productId;
        this.picImg = picImg;
        this.sort = sort;
        this.status = status;
        this.createTime = createTime;
        this.createBy = createBy;
    }

    public ProductImage() {
        super();
    }

    public Long getPicImgId() {
        return picImgId;
    }

    public void setPicImgId(Long picImgId) {
        this.picImgId = picImgId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
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
}