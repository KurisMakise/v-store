package store.product.common.enums;

import store.common.enums.OrderSortEnum;

/**
 * <p>
 * 商品排序枚举
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/5 16:27
 */
public enum ProductSortTypeEnum {
    RECOMMEND(0, "推荐", OrderSortEnum.DESC.getOrder(), "sort"),
    NEW(1, "新品", OrderSortEnum.DESC.getOrder(), "p.create_time"),
    SALES_VOLUME(2, "销量", OrderSortEnum.DESC.getOrder(), "sales_volume"),
    COMMENT_NUMBER(3, "评论数", OrderSortEnum.DESC.getOrder(), "comment_number"),
    PRICE_ASC(6, "价格升序", OrderSortEnum.ASC.getOrder(), "show_price"),
    PRICE_DESC(7, "价格降序", OrderSortEnum.DESC.getOrder(), "show_price"),
    UNKNOWN(-1, "未知排序", "", "");


    private Integer type;

    private String typeInfo;

    private String sort;

    private String order;

    ProductSortTypeEnum(Integer type, String typeInfo, String order, String sort) {
        this.type = type;
        this.typeInfo = typeInfo;
        this.sort = sort;
        this.order = order;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public String getSort() {
        return sort;
    }

    public String getOrder() {
        return order;
    }

    public static ProductSortTypeEnum typeOf(int type) {
        for (ProductSortTypeEnum typeEnum : values()) {
            if (typeEnum.getType() == type) {
                return typeEnum;
            }
        }
        return ProductSortTypeEnum.UNKNOWN;
    }
}
