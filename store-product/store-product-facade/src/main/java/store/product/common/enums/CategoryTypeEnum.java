package store.product.common.enums;

/**
 * @creator violet
 * @createTime 2019/3/8
 * @description
 */
public enum CategoryTypeEnum {

    FIRST_CATEGORY(1, "一级分类"),
    SECOND_CATEGORY(2, "二级分类"),
    ALL_CATEGORY(3, "所有分类");

    private int type;
    private String typeInfo;
    public int getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    CategoryTypeEnum(int type, String typeInfo) {
        this.type = type;
        this.typeInfo = typeInfo;
    }
}
