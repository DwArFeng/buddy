package com.dwarfeng.buddy.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Date;

/**
 * 个人简介组合查询信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class ProfileCompositeLookupInfo implements Dto {

    private static final long serialVersionUID = -2799631022373239164L;

    /**
     * 主键模糊匹配。
     */
    private String stringIdPattern;

    /**
     * 名称模糊匹配。
     */
    private String namePattern;

    /**
     * 电话号码模糊匹配。
     */
    private String phoneNumberPattern;

    /**
     * 电子邮件地址模糊匹配。
     */
    private String emailAddressPattern;

    /**
     * 备注模糊匹配。
     */
    private String remarkPattern;

    /**
     * 预留字段 String 类型 1# 模糊匹配。
     */
    private String reservedStringAlphaPattern;

    /**
     * 预留字段 String 类型 2# 模糊匹配。
     */
    private String reservedStringBravoPattern;

    /**
     * 预留字段 String 类型 3# 模糊匹配。
     */
    private String reservedStringCharliePattern;

    /**
     * 预留字段 String 类型 4# 模糊匹配。
     */
    private String reservedStringDeltaPattern;

    /**
     * 预留字段 String 类型 5# 模糊匹配。
     */
    private String reservedStringEchoPattern;

    /**
     * 预留字段 String 类型 6# 模糊匹配。
     */
    private String reservedStringFoxtrotPattern;

    /**
     * 预留字段 String 类型 7# 模糊匹配。
     */
    private String reservedStringGolfPattern;

    /**
     * 预留字段 String 类型 8# 模糊匹配。
     */
    private String reservedStringHotelPattern;

    /**
     * 预留字段 Long 类型 1# 最小值。
     */
    private Long reservedLongAlphaMin;

    /**
     * 预留字段 Long 类型 1# 最大值。
     */
    private Long reservedLongAlphaMax;

    /**
     * 预留字段 Long 类型 2# 最小值。
     */
    private Long reservedLongBravoMin;

    /**
     * 预留字段 Long 类型 2# 最大值。
     */
    private Long reservedLongBravoMax;

    /**
     * 预留字段 Long 类型 3# 最小值。
     */
    private Long reservedLongCharlieMin;

    /**
     * 预留字段 Long 类型 3# 最大值。
     */
    private Long reservedLongCharlieMax;

    /**
     * 预留字段 Long 类型 4# 最小值。
     */
    private Long reservedLongDeltaMin;

    /**
     * 预留字段 Long 类型 4# 最大值。
     */
    private Long reservedLongDeltaMax;

    /**
     * 预留字段 Integer 类型 1# 最小值。
     */
    private Integer reservedIntegerAlphaMin;

    /**
     * 预留字段 Integer 类型 1# 最大值。
     */
    private Integer reservedIntegerAlphaMax;

    /**
     * 预留字段 Integer 类型 2# 最小值。
     */
    private Integer reservedIntegerBravoMin;

    /**
     * 预留字段 Integer 类型 2# 最大值。
     */
    private Integer reservedIntegerBravoMax;

    /**
     * 预留字段 Integer 类型 3# 最小值。
     */
    private Integer reservedIntegerCharlieMin;

    /**
     * 预留字段 Integer 类型 3# 最大值。
     */
    private Integer reservedIntegerCharlieMax;

    /**
     * 预留字段 Integer 类型 4# 最小值。
     */
    private Integer reservedIntegerDeltaMin;

    /**
     * 预留字段 Integer 类型 4# 最大值。
     */
    private Integer reservedIntegerDeltaMax;

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
     * 预留字段 Date 类型 1# 最小值。
     */
    private Date reservedDateAlphaMin;

    /**
     * 预留字段 Date 类型 1# 最大值。
     */
    private Date reservedDateAlphaMax;

    /**
     * 预留字段 Date 类型 2# 最小值。
     */
    private Date reservedDateBravoMin;

    /**
     * 预留字段 Date 类型 2# 最大值。
     */
    private Date reservedDateBravoMax;

    /**
     * 预留字段 Date 类型 3# 最小值。
     */
    private Date reservedDateCharlieMin;

    /**
     * 预留字段 Date 类型 3# 最大值。
     */
    private Date reservedDateCharlieMax;

    /**
     * 预留字段 Date 类型 4# 最小值。
     */
    private Date reservedDateDeltaMin;

    /**
     * 预留字段 Date 类型 4# 最大值。
     */
    private Date reservedDateDeltaMax;

    public ProfileCompositeLookupInfo() {
    }

    public String getStringIdPattern() {
        return stringIdPattern;
    }

    public void setStringIdPattern(String stringIdPattern) {
        this.stringIdPattern = stringIdPattern;
    }

    public String getNamePattern() {
        return namePattern;
    }

    public void setNamePattern(String namePattern) {
        this.namePattern = namePattern;
    }

    public String getPhoneNumberPattern() {
        return phoneNumberPattern;
    }

    public void setPhoneNumberPattern(String phoneNumberPattern) {
        this.phoneNumberPattern = phoneNumberPattern;
    }

    public String getEmailAddressPattern() {
        return emailAddressPattern;
    }

    public void setEmailAddressPattern(String emailAddressPattern) {
        this.emailAddressPattern = emailAddressPattern;
    }

    public String getRemarkPattern() {
        return remarkPattern;
    }

    public void setRemarkPattern(String remarkPattern) {
        this.remarkPattern = remarkPattern;
    }

    public String getReservedStringAlphaPattern() {
        return reservedStringAlphaPattern;
    }

    public void setReservedStringAlphaPattern(String reservedStringAlphaPattern) {
        this.reservedStringAlphaPattern = reservedStringAlphaPattern;
    }

    public String getReservedStringBravoPattern() {
        return reservedStringBravoPattern;
    }

    public void setReservedStringBravoPattern(String reservedStringBravoPattern) {
        this.reservedStringBravoPattern = reservedStringBravoPattern;
    }

    public String getReservedStringCharliePattern() {
        return reservedStringCharliePattern;
    }

    public void setReservedStringCharliePattern(String reservedStringCharliePattern) {
        this.reservedStringCharliePattern = reservedStringCharliePattern;
    }

    public String getReservedStringDeltaPattern() {
        return reservedStringDeltaPattern;
    }

    public void setReservedStringDeltaPattern(String reservedStringDeltaPattern) {
        this.reservedStringDeltaPattern = reservedStringDeltaPattern;
    }

    public String getReservedStringEchoPattern() {
        return reservedStringEchoPattern;
    }

    public void setReservedStringEchoPattern(String reservedStringEchoPattern) {
        this.reservedStringEchoPattern = reservedStringEchoPattern;
    }

    public String getReservedStringFoxtrotPattern() {
        return reservedStringFoxtrotPattern;
    }

    public void setReservedStringFoxtrotPattern(String reservedStringFoxtrotPattern) {
        this.reservedStringFoxtrotPattern = reservedStringFoxtrotPattern;
    }

    public String getReservedStringGolfPattern() {
        return reservedStringGolfPattern;
    }

    public void setReservedStringGolfPattern(String reservedStringGolfPattern) {
        this.reservedStringGolfPattern = reservedStringGolfPattern;
    }

    public String getReservedStringHotelPattern() {
        return reservedStringHotelPattern;
    }

    public void setReservedStringHotelPattern(String reservedStringHotelPattern) {
        this.reservedStringHotelPattern = reservedStringHotelPattern;
    }

    public Long getReservedLongAlphaMin() {
        return reservedLongAlphaMin;
    }

    public void setReservedLongAlphaMin(Long reservedLongAlphaMin) {
        this.reservedLongAlphaMin = reservedLongAlphaMin;
    }

    public Long getReservedLongAlphaMax() {
        return reservedLongAlphaMax;
    }

    public void setReservedLongAlphaMax(Long reservedLongAlphaMax) {
        this.reservedLongAlphaMax = reservedLongAlphaMax;
    }

    public Long getReservedLongBravoMin() {
        return reservedLongBravoMin;
    }

    public void setReservedLongBravoMin(Long reservedLongBravoMin) {
        this.reservedLongBravoMin = reservedLongBravoMin;
    }

    public Long getReservedLongBravoMax() {
        return reservedLongBravoMax;
    }

    public void setReservedLongBravoMax(Long reservedLongBravoMax) {
        this.reservedLongBravoMax = reservedLongBravoMax;
    }

    public Long getReservedLongCharlieMin() {
        return reservedLongCharlieMin;
    }

    public void setReservedLongCharlieMin(Long reservedLongCharlieMin) {
        this.reservedLongCharlieMin = reservedLongCharlieMin;
    }

    public Long getReservedLongCharlieMax() {
        return reservedLongCharlieMax;
    }

    public void setReservedLongCharlieMax(Long reservedLongCharlieMax) {
        this.reservedLongCharlieMax = reservedLongCharlieMax;
    }

    public Long getReservedLongDeltaMin() {
        return reservedLongDeltaMin;
    }

    public void setReservedLongDeltaMin(Long reservedLongDeltaMin) {
        this.reservedLongDeltaMin = reservedLongDeltaMin;
    }

    public Long getReservedLongDeltaMax() {
        return reservedLongDeltaMax;
    }

    public void setReservedLongDeltaMax(Long reservedLongDeltaMax) {
        this.reservedLongDeltaMax = reservedLongDeltaMax;
    }

    public Integer getReservedIntegerAlphaMin() {
        return reservedIntegerAlphaMin;
    }

    public void setReservedIntegerAlphaMin(Integer reservedIntegerAlphaMin) {
        this.reservedIntegerAlphaMin = reservedIntegerAlphaMin;
    }

    public Integer getReservedIntegerAlphaMax() {
        return reservedIntegerAlphaMax;
    }

    public void setReservedIntegerAlphaMax(Integer reservedIntegerAlphaMax) {
        this.reservedIntegerAlphaMax = reservedIntegerAlphaMax;
    }

    public Integer getReservedIntegerBravoMin() {
        return reservedIntegerBravoMin;
    }

    public void setReservedIntegerBravoMin(Integer reservedIntegerBravoMin) {
        this.reservedIntegerBravoMin = reservedIntegerBravoMin;
    }

    public Integer getReservedIntegerBravoMax() {
        return reservedIntegerBravoMax;
    }

    public void setReservedIntegerBravoMax(Integer reservedIntegerBravoMax) {
        this.reservedIntegerBravoMax = reservedIntegerBravoMax;
    }

    public Integer getReservedIntegerCharlieMin() {
        return reservedIntegerCharlieMin;
    }

    public void setReservedIntegerCharlieMin(Integer reservedIntegerCharlieMin) {
        this.reservedIntegerCharlieMin = reservedIntegerCharlieMin;
    }

    public Integer getReservedIntegerCharlieMax() {
        return reservedIntegerCharlieMax;
    }

    public void setReservedIntegerCharlieMax(Integer reservedIntegerCharlieMax) {
        this.reservedIntegerCharlieMax = reservedIntegerCharlieMax;
    }

    public Integer getReservedIntegerDeltaMin() {
        return reservedIntegerDeltaMin;
    }

    public void setReservedIntegerDeltaMin(Integer reservedIntegerDeltaMin) {
        this.reservedIntegerDeltaMin = reservedIntegerDeltaMin;
    }

    public Integer getReservedIntegerDeltaMax() {
        return reservedIntegerDeltaMax;
    }

    public void setReservedIntegerDeltaMax(Integer reservedIntegerDeltaMax) {
        this.reservedIntegerDeltaMax = reservedIntegerDeltaMax;
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

    public Date getReservedDateAlphaMin() {
        return reservedDateAlphaMin;
    }

    public void setReservedDateAlphaMin(Date reservedDateAlphaMin) {
        this.reservedDateAlphaMin = reservedDateAlphaMin;
    }

    public Date getReservedDateAlphaMax() {
        return reservedDateAlphaMax;
    }

    public void setReservedDateAlphaMax(Date reservedDateAlphaMax) {
        this.reservedDateAlphaMax = reservedDateAlphaMax;
    }

    public Date getReservedDateBravoMin() {
        return reservedDateBravoMin;
    }

    public void setReservedDateBravoMin(Date reservedDateBravoMin) {
        this.reservedDateBravoMin = reservedDateBravoMin;
    }

    public Date getReservedDateBravoMax() {
        return reservedDateBravoMax;
    }

    public void setReservedDateBravoMax(Date reservedDateBravoMax) {
        this.reservedDateBravoMax = reservedDateBravoMax;
    }

    public Date getReservedDateCharlieMin() {
        return reservedDateCharlieMin;
    }

    public void setReservedDateCharlieMin(Date reservedDateCharlieMin) {
        this.reservedDateCharlieMin = reservedDateCharlieMin;
    }

    public Date getReservedDateCharlieMax() {
        return reservedDateCharlieMax;
    }

    public void setReservedDateCharlieMax(Date reservedDateCharlieMax) {
        this.reservedDateCharlieMax = reservedDateCharlieMax;
    }

    public Date getReservedDateDeltaMin() {
        return reservedDateDeltaMin;
    }

    public void setReservedDateDeltaMin(Date reservedDateDeltaMin) {
        this.reservedDateDeltaMin = reservedDateDeltaMin;
    }

    public Date getReservedDateDeltaMax() {
        return reservedDateDeltaMax;
    }

    public void setReservedDateDeltaMax(Date reservedDateDeltaMax) {
        this.reservedDateDeltaMax = reservedDateDeltaMax;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public String toString() {
        return "ProfileCompositeLookupInfo{" +
                "stringIdPattern='" + stringIdPattern + '\'' +
                ", namePattern='" + namePattern + '\'' +
                ", phoneNumberPattern='" + phoneNumberPattern + '\'' +
                ", emailAddressPattern='" + emailAddressPattern + '\'' +
                ", remarkPattern='" + remarkPattern + '\'' +
                ", reservedStringAlphaPattern='" + reservedStringAlphaPattern + '\'' +
                ", reservedStringBravoPattern='" + reservedStringBravoPattern + '\'' +
                ", reservedStringCharliePattern='" + reservedStringCharliePattern + '\'' +
                ", reservedStringDeltaPattern='" + reservedStringDeltaPattern + '\'' +
                ", reservedStringEchoPattern='" + reservedStringEchoPattern + '\'' +
                ", reservedStringFoxtrotPattern='" + reservedStringFoxtrotPattern + '\'' +
                ", reservedStringGolfPattern='" + reservedStringGolfPattern + '\'' +
                ", reservedStringHotelPattern='" + reservedStringHotelPattern + '\'' +
                ", reservedLongAlphaMin=" + reservedLongAlphaMin +
                ", reservedLongAlphaMax=" + reservedLongAlphaMax +
                ", reservedLongBravoMin=" + reservedLongBravoMin +
                ", reservedLongBravoMax=" + reservedLongBravoMax +
                ", reservedLongCharlieMin=" + reservedLongCharlieMin +
                ", reservedLongCharlieMax=" + reservedLongCharlieMax +
                ", reservedLongDeltaMin=" + reservedLongDeltaMin +
                ", reservedLongDeltaMax=" + reservedLongDeltaMax +
                ", reservedIntegerAlphaMin=" + reservedIntegerAlphaMin +
                ", reservedIntegerAlphaMax=" + reservedIntegerAlphaMax +
                ", reservedIntegerBravoMin=" + reservedIntegerBravoMin +
                ", reservedIntegerBravoMax=" + reservedIntegerBravoMax +
                ", reservedIntegerCharlieMin=" + reservedIntegerCharlieMin +
                ", reservedIntegerCharlieMax=" + reservedIntegerCharlieMax +
                ", reservedIntegerDeltaMin=" + reservedIntegerDeltaMin +
                ", reservedIntegerDeltaMax=" + reservedIntegerDeltaMax +
                ", reservedBooleanAlpha=" + reservedBooleanAlpha +
                ", reservedBooleanBravo=" + reservedBooleanBravo +
                ", reservedBooleanCharlie=" + reservedBooleanCharlie +
                ", reservedBooleanDelta=" + reservedBooleanDelta +
                ", reservedDateAlphaMin=" + reservedDateAlphaMin +
                ", reservedDateAlphaMax=" + reservedDateAlphaMax +
                ", reservedDateBravoMin=" + reservedDateBravoMin +
                ", reservedDateBravoMax=" + reservedDateBravoMax +
                ", reservedDateCharlieMin=" + reservedDateCharlieMin +
                ", reservedDateCharlieMax=" + reservedDateCharlieMax +
                ", reservedDateDeltaMin=" + reservedDateDeltaMin +
                ", reservedDateDeltaMax=" + reservedDateDeltaMax +
                '}';
    }
}
