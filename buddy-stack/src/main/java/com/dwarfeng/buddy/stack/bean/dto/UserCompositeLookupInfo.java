package com.dwarfeng.buddy.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Date;

/**
 * 用户组合查询信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class UserCompositeLookupInfo implements Dto {

    private static final long serialVersionUID = 5928459975558228765L;

    /**
     * 主键模糊匹配。
     */
    private String stringIdPattern;

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
     * 预留字段 Boolean 类型 1#。
     */
    private Boolean reservedBooleanAlpha;

    /**
     * 预留字段 Boolean 类型 2#。
     */
    private Boolean reservedBooleanBravo;

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

    public UserCompositeLookupInfo() {
    }

    public UserCompositeLookupInfo(
            String stringIdPattern, String remarkPattern, String reservedStringAlphaPattern,
            String reservedStringBravoPattern, String reservedStringCharliePattern, String reservedStringDeltaPattern,
            Long reservedLongAlphaMin, Long reservedLongAlphaMax, Long reservedLongBravoMin, Long reservedLongBravoMax,
            Integer reservedIntegerAlphaMin, Integer reservedIntegerAlphaMax, Integer reservedIntegerBravoMin,
            Integer reservedIntegerBravoMax, Boolean reservedBooleanAlpha, Boolean reservedBooleanBravo,
            Date reservedDateAlphaMin, Date reservedDateAlphaMax, Date reservedDateBravoMin, Date reservedDateBravoMax
    ) {
        this.stringIdPattern = stringIdPattern;
        this.remarkPattern = remarkPattern;
        this.reservedStringAlphaPattern = reservedStringAlphaPattern;
        this.reservedStringBravoPattern = reservedStringBravoPattern;
        this.reservedStringCharliePattern = reservedStringCharliePattern;
        this.reservedStringDeltaPattern = reservedStringDeltaPattern;
        this.reservedLongAlphaMin = reservedLongAlphaMin;
        this.reservedLongAlphaMax = reservedLongAlphaMax;
        this.reservedLongBravoMin = reservedLongBravoMin;
        this.reservedLongBravoMax = reservedLongBravoMax;
        this.reservedIntegerAlphaMin = reservedIntegerAlphaMin;
        this.reservedIntegerAlphaMax = reservedIntegerAlphaMax;
        this.reservedIntegerBravoMin = reservedIntegerBravoMin;
        this.reservedIntegerBravoMax = reservedIntegerBravoMax;
        this.reservedBooleanAlpha = reservedBooleanAlpha;
        this.reservedBooleanBravo = reservedBooleanBravo;
        this.reservedDateAlphaMin = reservedDateAlphaMin;
        this.reservedDateAlphaMax = reservedDateAlphaMax;
        this.reservedDateBravoMin = reservedDateBravoMin;
        this.reservedDateBravoMax = reservedDateBravoMax;
    }

    public String getStringIdPattern() {
        return stringIdPattern;
    }

    public void setStringIdPattern(String stringIdPattern) {
        this.stringIdPattern = stringIdPattern;
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

    @SuppressWarnings("DuplicatedCode")
    @Override
    public String toString() {
        return "UserCompositeLookupInfo{" +
                "stringIdPattern='" + stringIdPattern + '\'' +
                ", remarkPattern='" + remarkPattern + '\'' +
                ", reservedStringAlphaPattern='" + reservedStringAlphaPattern + '\'' +
                ", reservedStringBravoPattern='" + reservedStringBravoPattern + '\'' +
                ", reservedStringCharliePattern='" + reservedStringCharliePattern + '\'' +
                ", reservedStringDeltaPattern='" + reservedStringDeltaPattern + '\'' +
                ", reservedLongAlphaMin=" + reservedLongAlphaMin +
                ", reservedLongAlphaMax=" + reservedLongAlphaMax +
                ", reservedLongBravoMin=" + reservedLongBravoMin +
                ", reservedLongBravoMax=" + reservedLongBravoMax +
                ", reservedIntegerAlphaMin=" + reservedIntegerAlphaMin +
                ", reservedIntegerAlphaMax=" + reservedIntegerAlphaMax +
                ", reservedIntegerBravoMin=" + reservedIntegerBravoMin +
                ", reservedIntegerBravoMax=" + reservedIntegerBravoMax +
                ", reservedBooleanAlpha=" + reservedBooleanAlpha +
                ", reservedBooleanBravo=" + reservedBooleanBravo +
                ", reservedDateAlphaMin=" + reservedDateAlphaMin +
                ", reservedDateAlphaMax=" + reservedDateAlphaMax +
                ", reservedDateBravoMin=" + reservedDateBravoMin +
                ", reservedDateBravoMax=" + reservedDateBravoMax +
                '}';
    }
}
