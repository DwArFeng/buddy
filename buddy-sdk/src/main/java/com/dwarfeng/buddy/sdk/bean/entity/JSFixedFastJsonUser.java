package com.dwarfeng.buddy.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * JSFixed FastJson 用户。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class JSFixedFastJsonUser implements Bean {

    private static final long serialVersionUID = 5823707238340488094L;

    public static JSFixedFastJsonUser of(User user) {
        if (Objects.isNull(user)) {
            return null;
        } else {
            return new JSFixedFastJsonUser(
                    FastJsonStringIdKey.of(user.getKey()),
                    user.getRemark(),
                    user.getReservedStringAlpha(),
                    user.getReservedStringBravo(),
                    user.getReservedStringCharlie(),
                    user.getReservedStringDelta(),
                    user.getReservedLongAlpha(),
                    user.getReservedLongBravo(),
                    user.getReservedIntegerAlpha(),
                    user.getReservedIntegerBravo(),
                    user.getReservedBooleanAlpha(),
                    user.getReservedBooleanBravo(),
                    user.getReservedDateAlpha(),
                    user.getReservedDateBravo()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonStringIdKey key;

    @JSONField(name = "remark", ordinal = 2)
    private String remark;

    @JSONField(name = "reserved_string_alpha", ordinal = 3)
    private String reservedStringAlpha;

    @JSONField(name = "reserved_string_bravo", ordinal = 4)
    private String reservedStringBravo;

    @JSONField(name = "reserved_string_charlie", ordinal = 5)
    private String reservedStringCharlie;

    @JSONField(name = "reserved_string_delta", ordinal = 6)
    private String reservedStringDelta;

    @JSONField(name = "reserved_long_alpha", ordinal = 7, serializeUsing = ToStringSerializer.class)
    private Long reservedLongAlpha;

    @JSONField(name = "reserved_long_bravo", ordinal = 8, serializeUsing = ToStringSerializer.class)
    private Long reservedLongBravo;

    @JSONField(name = "reserved_integer_alpha", ordinal = 9)
    private Integer reservedIntegerAlpha;

    @JSONField(name = "reserved_integer_bravo", ordinal = 10)
    private Integer reservedIntegerBravo;

    @JSONField(name = "reserved_boolean_alpha", ordinal = 11)
    private Boolean reservedBooleanAlpha;

    @JSONField(name = "reserved_boolean_bravo", ordinal = 12)
    private Boolean reservedBooleanBravo;

    @JSONField(name = "reserved_date_alpha", ordinal = 13)
    private Date reservedDateAlpha;

    @JSONField(name = "reserved_date_bravo", ordinal = 14)
    private Date reservedDateBravo;

    public JSFixedFastJsonUser() {
    }

    public JSFixedFastJsonUser(
            FastJsonStringIdKey key, String remark, String reservedStringAlpha, String reservedStringBravo,
            String reservedStringCharlie, String reservedStringDelta, Long reservedLongAlpha, Long reservedLongBravo,
            Integer reservedIntegerAlpha, Integer reservedIntegerBravo, Boolean reservedBooleanAlpha,
            Boolean reservedBooleanBravo, Date reservedDateAlpha, Date reservedDateBravo
    ) {
        this.key = key;
        this.remark = remark;
        this.reservedStringAlpha = reservedStringAlpha;
        this.reservedStringBravo = reservedStringBravo;
        this.reservedStringCharlie = reservedStringCharlie;
        this.reservedStringDelta = reservedStringDelta;
        this.reservedLongAlpha = reservedLongAlpha;
        this.reservedLongBravo = reservedLongBravo;
        this.reservedIntegerAlpha = reservedIntegerAlpha;
        this.reservedIntegerBravo = reservedIntegerBravo;
        this.reservedBooleanAlpha = reservedBooleanAlpha;
        this.reservedBooleanBravo = reservedBooleanBravo;
        this.reservedDateAlpha = reservedDateAlpha;
        this.reservedDateBravo = reservedDateBravo;
    }

    public FastJsonStringIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonStringIdKey key) {
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
        return "JSFixedFastJsonUser{" +
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
