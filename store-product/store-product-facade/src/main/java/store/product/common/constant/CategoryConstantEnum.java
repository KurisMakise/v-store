package store.product.common.constant;

/**
 * @creator violet
 * @createTime 2019/3/6
 * @description
 */
public enum CategoryConstantEnum {

    CATEGORY_RECOMMEND_PRODUCT(8, "分类推荐产品显示数量"),

    CATEGORY_RECOMMEND_ADVERT(2, "分类推荐广告显示数量"),

    CATEGORY_NAV_PRODUCT(24, "分类导航显示产品数量"),

    CATEGORY_NAV_NUMBER(10, "导航栏分类显示数量");

    private int value;

    private String valueInfo;

    CategoryConstantEnum(int value, String valueInfo) {
        this.value = value;
        this.valueInfo = valueInfo;
    }

    public int getValue() {
        return value;
    }

    public String getValueInfo() {
        return valueInfo;
    }
}
