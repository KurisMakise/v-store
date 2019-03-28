package store.product.common.enums;

/**
 * @creator violet
 * @createTime 2019/3/15
 * @description
 */
public enum CommentTypeEnum {
    QUALITY(1, "优质评论"),

    ORDINARY(0, "普通评论");


    private int type;

    private String typeInfo;

    CommentTypeEnum(int type, String typeInfo) {
        this.type = type;
        this.typeInfo = typeInfo;
    }

    public int getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }
}
