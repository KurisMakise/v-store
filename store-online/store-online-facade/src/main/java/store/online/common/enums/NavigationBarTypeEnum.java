package store.online.common.enums;

/**
 * @creator violet
 * @createTime 2019/2/28
 * @description
 */
public enum NavigationBarTypeEnum {
    INDEX_TOP(1L, "首页-顶部", "indexTop"),
    INDEX_ADVERT_LEFT(2L, "首页-广告栏-左部", "indexAdvertLeft"),
    INDEX_BOTTOM(3L, "首页-底部", "indexBottom"),
    LOGIN_TOP(4L, "登录-顶部", "loginTop"),
    INDEX_CLASSIFY(5L, "首页-分类", "indexClassify");


    private long type;

    private String typeInfo;

    private String code;

    public long getType() {
        return type;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public String getCode() {
        return code;
    }

    NavigationBarTypeEnum(long type, String typeInfo, String code) {
        this.type = type;
        this.typeInfo = typeInfo;
        this.code = code;
    }


    public static NavigationBarTypeEnum stateOf(int index) {
        for (NavigationBarTypeEnum typeEnum : values()) {
            if (typeEnum.getType() == index) {
                return typeEnum;
            }
        }
        return null;
    }
}
