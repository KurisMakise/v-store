package store.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("os_product_attribute")
public class ProductAttribute {
    @TableId
    private Long attributeId;

    private Long productId;

    private Integer stock;

    private Integer salesVolume;

    private Integer pageViews;

    private Integer commentNumber;

    private Integer commentTotal;

    private Long commentAverage;

    private Integer favoriteNumber;

    private Integer questionNumber;

    public ProductAttribute(Long attributeId, Long productId, Integer stock, Integer salesVolume, Integer pageViews, Integer commentNumber, Integer commentTotal, Long commentAverage, Integer favoriteNumber, Integer questionNumber) {
        this.attributeId = attributeId;
        this.productId = productId;
        this.stock = stock;
        this.salesVolume = salesVolume;
        this.pageViews = pageViews;
        this.commentNumber = commentNumber;
        this.commentTotal = commentTotal;
        this.commentAverage = commentAverage;
        this.favoriteNumber = favoriteNumber;
        this.questionNumber = questionNumber;
    }

    public ProductAttribute() {
        super();
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Integer getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(Integer commentTotal) {
        this.commentTotal = commentTotal;
    }

    public Long getCommentAverage() {
        return commentAverage;
    }

    public void setCommentAverage(Long commentAverage) {
        this.commentAverage = commentAverage;
    }

    public Integer getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(Integer favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }
}