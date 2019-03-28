package store.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("os_shopping_cart")
public class ShoppingCart {
    @TableId
    private Long cartId;

    private Long productSpecNumber;

    private Long userId;

    private Integer buyNumber;

    private Date createTime;

    private Date updateTime;

    private Byte checkStatus;

    public ShoppingCart(Long cartId, Long productSpecNumber, Long userId, Integer buyNumber, Date createTime, Date updateTime, Byte checkStatus) {
        this.cartId = cartId;
        this.productSpecNumber = productSpecNumber;
        this.userId = userId;
        this.buyNumber = buyNumber;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.checkStatus = checkStatus;
    }

    public ShoppingCart() {
        super();
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductSpecNumber() {
        return productSpecNumber;
    }

    public void setProductSpecNumber(Long productSpecNumber) {
        this.productSpecNumber = productSpecNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }
}