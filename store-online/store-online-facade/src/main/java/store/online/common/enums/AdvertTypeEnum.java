package store.online.common.enums;

/**
 * @creator violet
 * @createTime 2019/2/28
 * @description
 */
public enum AdvertTypeEnum {
    INDEX_CAROUSEL(1L, "首页-轮播广告", "indexCAROUSEL"),
    INDEX_HOT_ADVERT(2L, "首页-热点广告", "indexHotAdvert");

    private long type;

    private String typeInfo;

    private String code;

    AdvertTypeEnum(long type, String typeInfo, String code) {
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

    public AdvertTypeEnum stateOf(int index) {
        for (AdvertTypeEnum typeEnum : values()) {
            if (typeEnum.getType() == index)
                return typeEnum;
        }
        return null;
    }
}
