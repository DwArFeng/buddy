package com.dwarfeng.buddy.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.sdk.util.Constraints;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

/**
 * WebInput 用户。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputUser implements Bean {

    private static final long serialVersionUID = -4389393361468608135L;

    public static User toStackBean(WebInputUser webInputUser) {
        if (Objects.isNull(webInputUser)) {
            return null;
        } else {
            return new User(
                    WebInputStringIdKey.toStackBean(webInputUser.getKey()),
                    webInputUser.getRemark(),
                    webInputUser.getReservedStringAlpha(),
                    webInputUser.getReservedStringBravo(),
                    webInputUser.getReservedStringCharlie(),
                    webInputUser.getReservedStringDelta(),
                    webInputUser.getReservedLongAlpha(),
                    webInputUser.getReservedLongBravo(),
                    webInputUser.getReservedIntegerAlpha(),
                    webInputUser.getReservedIntegerBravo(),
                    webInputUser.getReservedBooleanAlpha(),
                    webInputUser.getReservedBooleanBravo(),
                    webInputUser.getReservedDateAlpha(),
                    webInputUser.getReservedDateBravo()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputStringIdKey key;

    @JSONField(name = "remark")
    private String remark;

    @JSONField(name = "reserved_string_alpha")
    @Length(max = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringAlpha;

    @JSONField(name = "reserved_string_bravo")
    @Length(max = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringBravo;

    @JSONField(name = "reserved_string_charlie")
    @Length(max = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringCharlie;

    @JSONField(name = "reserved_string_delta")
    @Length(max = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringDelta;

    @JSONField(name = "reserved_long_alpha")
    private Long reservedLongAlpha;

    @JSONField(name = "reserved_long_bravo")
    private Long reservedLongBravo;

    @JSONField(name = "reserved_integer_alpha")
    private Integer reservedIntegerAlpha;

    @JSONField(name = "reserved_integer_bravo")
    private Integer reservedIntegerBravo;

    @JSONField(name = "reserved_boolean_alpha")
    private Boolean reservedBooleanAlpha;

    @JSONField(name = "reserved_boolean_bravo")
    private Boolean reservedBooleanBravo;

    @JSONField(name = "reserved_date_alpha")
    private Date reservedDateAlpha;

    @JSONField(name = "reserved_date_bravo")
    private Date reservedDateBravo;

    public WebInputUser() {
    }

    public WebInputStringIdKey getKey() {
        return key;
    }

    public void setKey(WebInputStringIdKey key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReservedStringAlpha() {
        return reservedStringAlpha;
    }

    public void setReservedStringAlpha(String reservedStringAlpha) {
        this.reservedStringAlpha = reservedStringAlpha;
    }

    public String getReservedStringBravo() {
        return reservedStringBravo;
    }

    public void setReservedStringBravo(String reservedStringBravo) {
        this.reservedStringBravo = reservedStringBravo;
    }

    public String getReservedStringCharlie() {
        return reservedStringCharlie;
    }

    public void setReservedStringCharlie(String reservedStringCharlie) {
        this.reservedStringCharlie = reservedStringCharlie;
    }

    public String getReservedStringDelta() {
        return reservedStringDelta;
    }

    public void setReservedStringDelta(String reservedStringDelta) {
        this.reservedStringDelta = reservedStringDelta;
    }

    public Long getReservedLongAlpha() {
        return reservedLongAlpha;
    }

    public void setReservedLongAlpha(Long reservedLongAlpha) {
        this.reservedLongAlpha = reservedLongAlpha;
    }

    public Long getReservedLongBravo() {
        return reservedLongBravo;
    }

    public void setReservedLongBravo(Long reservedLongBravo) {
        this.reservedLongBravo = reservedLongBravo;
    }

    public Integer getReservedIntegerAlpha() {
        return reservedIntegerAlpha;
    }

    public void setReservedIntegerAlpha(Integer reservedIntegerAlpha) {
        this.reservedIntegerAlpha = reservedIntegerAlpha;
    }

    public Integer getReservedIntegerBravo() {
        return reservedIntegerBravo;
    }

    public void setReservedIntegerBravo(Integer reservedIntegerBravo) {
        this.reservedIntegerBravo = reservedIntegerBravo;
    }

    public Boolean getReservedBooleanAlpha() {
        return reservedBooleanAlpha;
    }

    public void setReservedBooleanAlpha(Boolean reservedBooleanAlpha) {
        this.reservedBooleanAlpha = reservedBooleanAlpha;
    }

    public Boolean getReservedBooleanBravo() {
        return reservedBooleanBravo;
    }

    public void setReservedBooleanBravo(Boolean reservedBooleanBravo) {
        this.reservedBooleanBravo = reservedBooleanBravo;
    }

    public Date getReservedDateAlpha() {
        return reservedDateAlpha;
    }

    public void setReservedDateAlpha(Date reservedDateAlpha) {
        this.reservedDateAlpha = reservedDateAlpha;
    }

    public Date getReservedDateBravo() {
        return reservedDateBravo;
    }

    public void setReservedDateBravo(Date reservedDateBravo) {
        this.reservedDateBravo = reservedDateBravo;
    }

    @Override
    public String toString() {
        return "WebInputUser{" +
                "key=" + key +
                ", remark='" + remark + '\'' +
                ", reservedStringAlpha='" + reservedStringAlpha + '\'' +
                ", reservedStringBravo='" + reservedStringBravo + '\'' +
                ", reservedStringCharlie='" + reservedStringCharlie + '\'' +
                ", reservedStringDelta='" + reservedStringDelta + '\'' +
                ", reservedLongAlpha=" + reservedLongAlpha +
                ", reservedLongBravo=" + reservedLongBravo +
                ", reservedIntegerAlpha=" + reservedIntegerAlpha +
                ", reservedIntegerBravo=" + reservedIntegerBravo +
                ", reservedBooleanAlpha=" + reservedBooleanAlpha +
                ", reservedBooleanBravo=" + reservedBooleanBravo +
                ", reservedDateAlpha=" + reservedDateAlpha +
                ", reservedDateBravo=" + reservedDateBravo +
                '}';
    }
}
