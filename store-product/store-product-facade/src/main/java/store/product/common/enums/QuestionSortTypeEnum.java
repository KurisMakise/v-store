package store.product.common.enums;

import store.common.enums.OrderSortEnum;

/**
 * author  violet
 * createTime 2019/4/4 10:14
 * description 商品排序
 * version 1.0
 */
public enum QuestionSortTypeEnum {
    QUESTION_NEW(0, "最新提问", OrderSortEnum.DESC.getOrder(), "create_time"),
    QUESTION_HOT(1, "热门提问", OrderSortEnum.DESC.getOrder(), "good_count"),
    QUESTION_UNKNOWN(-1, "未知分类", "", "");


    private Integer type;

    private String typeInfo;

    private String order;

    private String sort;

    QuestionSortTypeEnum(Integer type, String typeInfo, String order, String sort) {
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

    public static QuestionSortTypeEnum typeOf(int type) {
        for (QuestionSortTypeEnum sortEnum : values()) {
            if (type == sortEnum.getType()) {
                return sortEnum;
            }
        }
        return QUESTION_UNKNOWN;
    }
}
