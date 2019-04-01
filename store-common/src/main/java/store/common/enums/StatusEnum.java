package store.common.enums;

/**
 * creator violet
 * createTime 0109/0/08
 * description
 */
public enum StatusEnum {

    NORMAL(1, "正常"),
    FREEZE(0, "冻结"),

    ACTIVATED(1, "激活"),
    NONACTIVATED(0, "未激活"),

    SHOW(1, "显示"),
    HIDDEN(0, "隐藏"),

    VALID(1, "有效"),
    INVALID(0, "无效"),

    CHECKED(1, "选中"),
    UNCHECKED(0, "未选中"),

    DEFAULT(1, "默认"),
    UN_DEFAULT(0, "不默认"),

    SHELVE(1, "上架"),
    OFF_SHELVE(0, "下架"),

    ALL(-1, "全部");

    private Integer status;

    private String stateInfo;

    StatusEnum(int status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
