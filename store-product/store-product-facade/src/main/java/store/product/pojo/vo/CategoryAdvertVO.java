package store.product.pojo.vo;

/**
 * @creator violet
 * @createTime 2019/3/8
 * @description
 */
public class CategoryAdvertVO {
    private static final long serialVersionUID = 1L;

    /**
     * 类目广告ID
     */
    private Long categoryAdvertId;

    /**
     * 标题
     */
    private String title;

    /**
     * 链接地址
     */
    private String href;

    /**
     * 展示图片
     */
    private String picImg;


    public void setCategoryAdvertId(Long categoryAdvertId) {
        this.categoryAdvertId = categoryAdvertId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }
}
