package store.product.common.enums;

import store.common.enums.OrderSortEnum;

/**
 * author  violet
 * createTime 2019/4/4 10:54
 * description 评论排序
 * version 1.0
 */
public enum CommentSortTypeEnum {
    COMMENT_NEW(0, "最新评论", OrderSortEnum.DESC.getOrder(), "create_time"),
    COMMENT_HOT(1, "热门评论", OrderSortEnum.DESC.getOrder(), "good_count"),
    COMMENT_UNKNOWN(-1, "未知评论类型", "", "");

    private Integer type;

    private String typeInfo;

    /**
     * 排序字段
     */
    private String order;

    /**
     * 排序类型
     */
    private String sort;

    CommentSortTypeEnum(Integer type, String typeInfo, String order, String sort) {
        this.type = type;
        this.typeInfo = typeInfo;
        this.order = order;
        this.sort = sort;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public String getOrder() {
        return order;
    }

    public String getSort() {
        return sort;
    }

    public static CommentSortTypeEnum typeOf(int type) {
        for (CommentSortTypeEnum typeEnum : values()) {
            if (type == typeEnum.getType()) {
                return typeEnum;
            }
        }
        return CommentSortTypeEnum.COMMENT_UNKNOWN;
    }
}
