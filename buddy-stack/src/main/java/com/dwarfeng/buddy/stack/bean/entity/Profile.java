package com.dwarfeng.buddy.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

import java.util.Date;

/**
 * 个人简介。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class Profile implements Entity<StringIdKey> {

    private static final long serialVersionUID = 2430452362849146858L;

    private StringIdKey key;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String remark;

    /**
     * 预留字段 String 类型 1#。
     */
    private String reservedStringAlpha;

    /**
     * 预留字段 String 类型 2#。
     */
    private String reservedStringBravo;

    /**
     * 预留字段 String 类型 3#。
     */
    private String reservedStringCharlie;

    /**
     * 预留字段 String 类型 4#。
     */
    private String reservedStringDelta;

    /**
     * 预留字段 String 类型 5#。
     */
    private String reservedStringEcho;

    /**
     * 预留字段 String 类型 6#。
     */
    private String reservedStringFoxtrot;

    /**
     * 预留字段 String 类型 7#。
     */
    private String reservedStringGolf;

    /**
     * 预留字段 String 类型 8#。
     */
    private String reservedStringHotel;

    /**
     * 预留字段 Long 类型 1#。
     */
    private Long reservedLongAlpha;

    /**
     * 预留字段 Long 类型 2#。
     */
    private Long reservedLongBravo;

    /**
     * 预留字段 Long 类型 3#。
     */
    private Long reservedLongCharlie;

    /**
     * 预留字段 Long 类型 4
     */
    private Long reservedLongDelta;

    /**
     * 预留字段 Integer 类型 1#。
     */
    private Integer reservedIntegerAlpha;

    /**
     * 预留字段 Integer 类型 2#。
     */
    private Integer reservedIntegerBravo;

    /**
     * 预留字段 Integer 类型 3#。
     */
    private Integer reservedIntegerCharlie;

    /**
     * 预留字段 Integer 类型 4#。
     */
    private Integer reservedIntegerDelta;

    /**
     * 预留字段 Boolean 类型 1#。
     */
    private Boolean reservedBooleanAlpha;

    /**
     * 预留字段 Boolean 类型 2#。
     */
    private Boolean reservedBooleanBravo;

    /**
     * 预留字段 Boolean 类型 3#。
     */
    private Boolean reservedBooleanCharlie;

    /**
     * 预留字段 Boolean 类型 4#。
     */
    private Boolean reservedBooleanDelta;

    /**
     * 预留字段 Date 类型 1#。
     */
    private Date reservedDateAlpha;

    /**
     * 预留字段 Date 类型 2#。
     */
    private Date reservedDateBravo;

    /**
     * 预留字段 Date 类型 3#。
     */
    private Date reservedDateCharlie;

    /**
     * 预留字段 Date 类型 4#。
     */
    private Date reservedDateDelta;

    public Profile() {
    }

    public Profile(
            StringIdKey key, String name, String phoneNumber, String emailAddress, String remark,
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

    @Override
    public StringIdKey getKey() {
        return key;
    }

    @Override
    public void setKey(StringIdKey key) {
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
        return "Profile{" +
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
