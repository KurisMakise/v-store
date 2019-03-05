package store.online.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("os_advert")
public class Advert {
    @TableId("advert_id")
    private Long advertId;

    private String name;

    private Integer width;

    private Integer height;

    private String description;

    private String code;

    private Integer defultNumber;

    private Integer number;

    private Byte status;

    private Byte type;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private String template;

    public Advert(Long advertId, String name, Integer width, Integer height, String description, String code, Integer defultNumber, Integer number, Byte status, Byte type, Date createTime, String createBy, Date updateTime, String updateBy) {
        this.advertId = advertId;
        this.name = name;
        this.width = width;
        this.height = height;
        this.description = description;
        this.code = code;
        this.defultNumber = defultNumber;
        this.number = number;
        this.status = status;
        this.type = type;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
    }

    public Advert(Long advertId, String name, Integer width, Integer height, String description, String code, Integer defultNumber, Integer number, Byte status, Byte type, Date createTime, String createBy, Date updateTime, String updateBy, String template) {
        this.advertId = advertId;
        this.name = name;
        this.width = width;
        this.height = height;
        this.description = description;
        this.code = code;
        this.defultNumber = defultNumber;
        this.number = number;
        this.status = status;
        this.type = type;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.template = template;
    }

    public Advert() {
        super();
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getDefultNumber() {
        return defultNumber;
    }

    public void setDefultNumber(Integer defultNumber) {
        this.defultNumber = defultNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }
}