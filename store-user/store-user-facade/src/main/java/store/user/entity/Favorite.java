package store.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

@TableName("os_favorite")
public class Favorite {
    @TableId
    private Long favoriteId;

    private Long userId;

    private Long productId;

    private Long productNumber;

    private String name;

    private String picImg;

    private BigDecimal showPrice;

    private Byte status;

    private Date createTime;

    private String createBy;

    public Favorite(Long favoriteId, Long userId, Long productId, Long productNumber, String name, String picImg, BigDecimal showPrice, Byte status, Date createTime, String createBy) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.productId = productId;
        this.productNumber = productNumber;
        this.name = name;
        this.picImg = picImg;
        this.showPrice = showPrice;
        this.status = status;
        this.createTime = createTime;
        this.createBy = createBy;
    }

    public Favorite() {
        super();
    }

    public Long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
    }

    public BigDecimal getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(BigDecimal showPrice) {
        this.showPrice = showPrice;
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