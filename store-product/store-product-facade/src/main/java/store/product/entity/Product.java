package store.product.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Long productId;

    private Long productNumber;

    private Integer labelId;

    private String name;

    private Integer showScore;

    private BigDecimal showPrice;

    private String introduce;

    private String picImg;

    private Byte showInTop;

    private Byte showInNav;

    private Byte showInHot;

    private Byte showInShelve;

    private Date createTime;

    private String createBy;

    private Date shelveTime;

    private String shelveBy;

    private Date updateTime;

    private String updateBy;

    private String searchKey;

    private String pageTitle;

    private String pageDescription;

    private String pageKeyword;

    private String remarks;

    public Product(Long productId, Long productNumber, Integer labelId, String name, Integer showScore, BigDecimal showPrice, String introduce, String picImg, Byte showInTop, Byte showInNav, Byte showInHot, Byte showInShelve, Date createTime, String createBy, Date shelveTime, String shelveBy, Date updateTime, String updateBy, String searchKey, String pageTitle, String pageDescription, String pageKeyword, String remarks) {
        this.productId = productId;
        this.productNumber = productNumber;
        this.labelId = labelId;
        this.name = name;
        this.showScore = showScore;
        this.showPrice = showPrice;
        this.introduce = introduce;
        this.picImg = picImg;
        this.showInTop = showInTop;
        this.showInNav = showInNav;
        this.showInHot = showInHot;
        this.showInShelve = showInShelve;
        this.createTime = createTime;
        this.createBy = createBy;
        this.shelveTime = shelveTime;
        this.shelveBy = shelveBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.searchKey = searchKey;
        this.pageTitle = pageTitle;
        this.pageDescription = pageDescription;
        this.pageKeyword = pageKeyword;
        this.remarks = remarks;
    }

    public Product() {
        super();
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

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getShowScore() {
        return showScore;
    }

    public void setShowScore(Integer showScore) {
        this.showScore = showScore;
    }

    public BigDecimal getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(BigDecimal showPrice) {
        this.showPrice = showPrice;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg == null ? null : picImg.trim();
    }

    public Byte getShowInTop() {
        return showInTop;
    }

    public void setShowInTop(Byte showInTop) {
        this.showInTop = showInTop;
    }

    public Byte getShowInNav() {
        return showInNav;
    }

    public void setShowInNav(Byte showInNav) {
        this.showInNav = showInNav;
    }

    public Byte getShowInHot() {
        return showInHot;
    }

    public void setShowInHot(Byte showInHot) {
        this.showInHot = showInHot;
    }

    public Byte getShowInShelve() {
        return showInShelve;
    }

    public void setShowInShelve(Byte showInShelve) {
        this.showInShelve = showInShelve;
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

    public Date getShelveTime() {
        return shelveTime;
    }

    public void setShelveTime(Date shelveTime) {
        this.shelveTime = shelveTime;
    }

    public String getShelveBy() {
        return shelveBy;
    }

    public void setShelveBy(String shelveBy) {
        this.shelveBy = shelveBy == null ? null : shelveBy.trim();
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

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey == null ? null : searchKey.trim();
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle == null ? null : pageTitle.trim();
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription == null ? null : pageDescription.trim();
    }

    public String getPageKeyword() {
        return pageKeyword;
    }

    public void setPageKeyword(String pageKeyword) {
        this.pageKeyword = pageKeyword == null ? null : pageKeyword.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}