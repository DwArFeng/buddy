package com.dwarfeng.buddy.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Date;
import java.util.Objects;

/**
 * FastJson 个人简介。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class FastJsonProfile implements Bean {

    private static final long serialVersionUID = -8635853358688772350L;

    public static FastJsonProfile of(Profile profile) {
        if (Objects.isNull(profile)) {
            return null;
        } else {
            return new FastJsonProfile(
                    FastJsonStringIdKey.of(profile.getKey()),
                    profile.getName(),
                    profile.getPhoneNumber(),
                    profile.getEmailAddress(),
                    profile.getRemark(),
                    profile.getReservedStringAlpha(),
                    profile.getReservedStringBravo(),
                    profile.getReservedStringCharlie(),
                    profile.getReservedStringDelta(),
                    profile.getReservedStringEcho(),
                    profile.getReservedStringFoxtrot(),
                    profile.getReservedStringGolf(),
                    profile.getReservedStringHotel(),
                    profile.getReservedLongAlpha(),
                    profile.getReservedLongBravo(),
                    profile.getReservedLongCharlie(),
                    profile.getReservedLongDelta(),
                    profile.getReservedIntegerAlpha(),
                    profile.getReservedIntegerBravo(),
                    profile.getReservedIntegerCharlie(),
                    profile.getReservedIntegerDelta(),
                    profile.getReservedBooleanAlpha(),
                    profile.getReservedBooleanBravo(),
                    profile.getReservedBooleanCharlie(),
                    profile.getReservedBooleanDelta(),
                    profile.getReservedDateAlpha(),
                    profile.getReservedDateBravo(),
                    profile.getReservedDateCharlie(),
                    profile.getReservedDateDelta()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonStringIdKey key;

    @JSONField(name = "name", ordinal = 2)
    private String name;

    @JSONField(name = "phone_number", ordinal = 3)
    private String phoneNumber;

    @JSONField(name = "email_address", ordinal = 4)
    private String emailAddress;

    @JSONField(name = "remark", ordinal = 5)
    private String remark;

    @JSONField(name = "reserved_string_alpha", ordinal = 6)
    private String reservedStringAlpha;

    @JSONField(name = "reserved_string_bravo", ordinal = 7)
    private String reservedStringBravo;

    @JSONField(name = "reserved_string_charlie", ordinal = 8)
    private String reservedStringCharlie;

    @JSONField(name = "reserved_string_delta", ordinal = 9)
    private String reservedStringDelta;

    @JSONField(name = "reserved_string_echo", ordinal = 10)
    private String reservedStringEcho;

    @JSONField(name = "reserved_string_foxtrot", ordinal = 11)
    private String reservedStringFoxtrot;

    @JSONField(name = "reserved_string_golf", ordinal = 12)
    private String reservedStringGolf;

    @JSONField(name = "reserved_string_hotel", ordinal = 13)
    private String reservedStringHotel;

    @JSONField(name = "reserved_long_alpha", ordinal = 14)
    private Long reservedLongAlpha;

    @JSONField(name = "reserved_long_bravo", ordinal = 15)
    private Long reservedLongBravo;

    @JSONField(name = "reserved_long_charlie", ordinal = 16)
    private Long reservedLongCharlie;

    @JSONField(name = "reserved_long_delta", ordinal = 17)
    private Long reservedLongDelta;

    @JSONField(name = "reserved_integer_alpha", ordinal = 18)
    private Integer reservedIntegerAlpha;

    @JSONField(name = "reserved_integer_bravo", ordinal = 19)
    private Integer reservedIntegerBravo;

    @JSONField(name = "reserved_integer_charlie", ordinal = 20)
    private Integer reservedIntegerCharlie;

    @JSONField(name = "reserved_integer_delta", ordinal = 21)
    private Integer reservedIntegerDelta;

    @JSONField(name = "reserved_boolean_alpha", ordinal = 22)
    private Boolean reservedBooleanAlpha;

    @JSONField(name = "reserved_boolean_bravo", ordinal = 23)
    private Boolean reservedBooleanBravo;

    @JSONField(name = "reserved_boolean_charlie", ordinal = 24)
    private Boolean reservedBooleanCharlie;

    @JSONField(name = "reserved_boolean_delta", ordinal = 25)
    private Boolean reservedBooleanDelta;

    @JSONField(name = "reserved_date_alpha", ordinal = 26)
    private Date reservedDateAlpha;

    @JSONField(name = "reserved_date_bravo", ordinal = 27)
    private Date reservedDateBravo;

    @JSONField(name = "reserved_date_charlie", ordinal = 28)
    private Date reservedDateCharlie;

    @JSONField(name = "reserved_date_delta", ordinal = 29)
    private Date reservedDateDelta;

    public FastJsonProfile() {
    }

    public FastJsonProfile(
            FastJsonStringIdKey key, String name, String phoneNumber, String emailAddress, String remark,
            String reservedStringAlpha, String reservedStringBravo, String reservedStringCharlie,
            String reservedStringDelta, String reservedStringEcho, String reservedStringFoxtrot,
            String reservedStringGolf, String reservedStringHotel, Long reservedLongAlpha, Long reservedLongBravo,
            Long reservedLongCharlie, Long reservedLongDelta, Integer reservedIntegerAlpha,
            Integer reservedIntegerBravo, Integer reservedIntegerCharlie, Integer reservedIntegerDelta,
            Boolean reservedBooleanAlpha, Boolean reservedBooleanBravo, Boolean reservedBooleanCharlie,
            Boolean reservedBooleanDelta, Date reservedDateAlpha, Date reservedDateBravo, Date reservedDateCharlie,
            Date reservedDateDelta
    ) {
        this.key = key;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.remark = remark;
        this.reservedStringAlpha = reservedStringAlpha;
        this.reservedStringBravo = reservedStringBravo;
        this.reservedStringCharlie = reservedStringCharlie;
        this.reservedStringDelta = reservedStringDelta;
        this.reservedStringEcho = reservedStringEcho;
        this.reservedStringFoxtrot = reservedStringFoxtrot;
        this.reservedStringGolf = reservedStringGolf;
        this.reservedStringHotel = reservedStringHotel;
        this.reservedLongAlpha = reservedLongAlpha;
        this.reservedLongBravo = reservedLongBravo;
        this.reservedLongCharlie = reservedLongCharlie;
        this.reservedLongDelta = reservedLongDelta;
        this.reservedIntegerAlpha = reservedIntegerAlpha;
        this.reservedIntegerBravo = reservedIntegerBravo;
        this.reservedIntegerCharlie = reservedIntegerCharlie;
        this.reservedIntegerDelta = reservedIntegerDelta;
        this.reservedBooleanAlpha = reservedBooleanAlpha;
        this.reservedBooleanBravo = reservedBooleanBravo;
        this.reservedBooleanCharlie = reservedBooleanCharlie;
        this.reservedBooleanDelta = reservedBooleanDelta;
        this.reservedDateAlpha = reservedDateAlpha;
        this.reservedDateBravo = reservedDateBravo;
        this.reservedDateCharlie = reservedDateCharlie;
        this.reservedDateDelta = reservedDateDelta;
    }

    public FastJsonStringIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonStringIdKey key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getReservedStringEcho() {
        return reservedStringEcho;
    }

    public void setReservedStringEcho(String reservedStringEcho) {
        this.reservedStringEcho = reservedStringEcho;
    }

    public String getReservedStringFoxtrot() {
        return reservedStringFoxtrot;
    }

    public void setReservedStringFoxtrot(String reservedStringFoxtrot) {
        this.reservedStringFoxtrot = reservedStringFoxtrot;
    }

    public String getReservedStringGolf() {
        return reservedStringGolf;
    }

    public void setReservedStringGolf(String reservedStringGolf) {
        this.reservedStringGolf = reservedStringGolf;
    }

    public String getReservedStringHotel() {
        return reservedStringHotel;
    }

    public void setReservedStringHotel(String reservedStringHotel) {
        this.reservedStringHotel = reservedStringHotel;
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

    public Long getReservedLongCharlie() {
        return reservedLongCharlie;
    }

    public void setReservedLongCharlie(Long reservedLongCharlie) {
        this.reservedLongCharlie = reservedLongCharlie;
    }

    public Long getReservedLongDelta() {
        return reservedLongDelta;
    }

    public void setReservedLongDelta(Long reservedLongDelta) {
        this.reservedLongDelta = reservedLongDelta;
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

    public Integer getReservedIntegerCharlie() {
        return reservedIntegerCharlie;
    }

    public void setReservedIntegerCharlie(Integer reservedIntegerCharlie) {
        this.reservedIntegerCharlie = reservedIntegerCharlie;
    }

    public Integer getReservedIntegerDelta() {
        return reservedIntegerDelta;
    }

    public void setReservedIntegerDelta(Integer reservedIntegerDelta) {
        this.reservedIntegerDelta = reservedIntegerDelta;
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

    public Boolean getReservedBooleanCharlie() {
        return reservedBooleanCharlie;
    }

    public void setReservedBooleanCharlie(Boolean reservedBooleanCharlie) {
        this.reservedBooleanCharlie = reservedBooleanCharlie;
    }

    public Boolean getReservedBooleanDelta() {
        return reservedBooleanDelta;
    }

    public void setReservedBooleanDelta(Boolean reservedBooleanDelta) {
        this.reservedBooleanDelta = reservedBooleanDelta;
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

    public Date getReservedDateCharlie() {
        return reservedDateCharlie;
    }

    public void setReservedDateCharlie(Date reservedDateCharlie) {
        this.reservedDateCharlie = reservedDateCharlie;
    }

    public Date getReservedDateDelta() {
        return reservedDateDelta;
    }

    public void setReservedDateDelta(Date reservedDateDelta) {
        this.reservedDateDelta = reservedDateDelta;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public String toString() {
        return "FastJsonProfile{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", remark='" + remark + '\'' +
                ", reservedStringAlpha='" + reservedStringAlpha + '\'' +
                ", reservedStringBravo='" + reservedStringBravo + '\'' +
                ", reservedStringCharlie='" + reservedStringCharlie + '\'' +
                ", reservedStringDelta='" + reservedStringDelta + '\'' +
                ", reservedStringEcho='" + reservedStringEcho + '\'' +
                ", reservedStringFoxtrot='" + reservedStringFoxtrot + '\'' +
                ", reservedStringGolf='" + reservedStringGolf + '\'' +
                ", reservedStringHotel='" + reservedStringHotel + '\'' +
                ", reservedLongAlpha=" + reservedLongAlpha +
                ", reservedLongBravo=" + reservedLongBravo +
                ", reservedLongCharlie=" + reservedLongCharlie +
                ", reservedLongDelta=" + reservedLongDelta +
                ", reservedIntegerAlpha=" + reservedIntegerAlpha +
                ", reservedIntegerBravo=" + reservedIntegerBravo +
                ", reservedIntegerCharlie=" + reservedIntegerCharlie +
                ", reservedIntegerDelta=" + reservedIntegerDelta +
                ", reservedBooleanAlpha=" + reservedBooleanAlpha +
                ", reservedBooleanBravo=" + reservedBooleanBravo +
                ", reservedBooleanCharlie=" + reservedBooleanCharlie +
                ", reservedBooleanDelta=" + reservedBooleanDelta +
                ", reservedDateAlpha=" + reservedDateAlpha +
                ", reservedDateBravo=" + reservedDateBravo +
                ", reservedDateCharlie=" + reservedDateCharlie +
                ", reservedDateDelta=" + reservedDateDelta +
                '}';
    }
}
