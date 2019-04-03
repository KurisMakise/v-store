package store.product.pojo.vo;

/**
 * author  violet
 * createTime 2019/4/2 16:22
 * description
 * version 1.0
 */
public class ProductImageVO {
    private Long productId;

    private Long picImgId;

    private String picImg;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPicImgId() {
        return picImgId;
    }

    public void setPicImgId(Long picImgId) {
        this.picImgId = picImgId;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }
}
