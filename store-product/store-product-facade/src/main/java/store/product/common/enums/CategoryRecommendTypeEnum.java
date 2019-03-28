package store.product.common.enums;

/**
 * @creator violet
 * @createTime 2019/3/8
 * @description
 */
public enum CategoryRecommendTypeEnum {

    /**
     * 是否置顶
     */
    SHOW_IN_TOP(1, "是"),
    HIDE_IN_TOP(0, "否"),

    /**
     * 是否导航
     */
    SHOW_IN_NAV(1, "是"),
    HIDE_IN_NAV(0, "否"),

    /**
     * 是否热门
     */
    SHOW_IN_HOT(1, "是"),
    HIDE_IN_HOT(0, "否");

    private int type;
    private String typeInfo;

    public int getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    CategoryRecommendTypeEnum(int type, String typeInfo) {
        this.type = type;
        this.typeInfo = typeInfo;
    }
}
