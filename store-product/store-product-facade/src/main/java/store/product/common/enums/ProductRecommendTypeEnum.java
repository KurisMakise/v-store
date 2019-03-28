package store.product.common.enums;

/**
 * @creator violet
 * @createTime 2019/3/15
 * @description
 */
public enum ProductRecommendTypeEnum {

    STAR(1L, "明星产品", "star"),

    POPULAR(2L, "为你推荐", "popular"),

    COMMENT(3L, "热评产品", "comment"),

    NEW(4L, "新品推荐", "new");

    private long type;

    private String typeInfo;

    private String code;

    ProductRecommendTypeEnum(long type, String typeInfo, String code) {
        this.type = type;
        this.typeInfo = typeInfo;
        this.code = code;
    }

    public long getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public String getCode() {
        return code;
    }
}
