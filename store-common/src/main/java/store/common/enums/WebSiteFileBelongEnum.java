package store.common.enums;

/**
 * author  violet
 * createTime 2019/3/27 10:44
 * description 网站文件存放归属枚举
 * version 1.0
 */
public enum WebSiteFileBelongEnum {
    DEFAULT(1, "一级目录", "default", "默认"),
    IMAGES(1, "一级目录", "images", "图片"),
    VIDEO(1, "一级目录", "video", "视频"),
    AVATAR(2, "二级目录", "avatar", "头像"),
    ICO(2, "二级目录", "ico", "缩略标志"),
    GOODS(2, "二级目录", "goods", "商品"),
    ADVERT(2, "二级目录", "advert", "广告");


    private Integer type;

    private String typeInfo;

    private String belong;

    private String belongInfo;


    WebSiteFileBelongEnum(Integer type, String typeInfo, String belong, String belongInfo) {
        this.type = type;
        this.typeInfo = typeInfo;
        this.belong = belong;
        this.belongInfo = belongInfo;
    }

    public Integer getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public String getBelong() {
        return belong;
    }

    public String getBelongInfo() {
        return belongInfo;
    }
}
