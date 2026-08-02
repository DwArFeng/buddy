package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.UserCompositeLookupInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Date;
import java.util.Objects;

/**
 * WebInput 用户组合查询信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputUserCompositeLookupInfo implements Dto {

    private static final long serialVersionUID = 3198324961801799798L;

    public static UserCompositeLookupInfo toStackBean(WebInputUserCompositeLookupInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new UserCompositeLookupInfo(
                    webInput.getStringIdPattern(),
                    webInput.getRemarkPattern(),
                    webInput.getReservedStringAlphaPattern(),
                    webInput.getReservedStringBravoPattern(),
                    webInput.getReservedStringCharliePattern(),
                    webInput.getReservedStringDeltaPattern(),
                    webInput.getReservedLongAlphaMin(),
                    webInput.getReservedLongAlphaMax(),
                    webInput.getReservedLongBravoMin(),
                    webInput.getReservedLongBravoMax(),
                    webInput.getReservedIntegerAlphaMin(),
                    webInput.getReservedIntegerAlphaMax(),
                    webInput.getReservedIntegerBravoMin(),
                    webInput.getReservedIntegerBravoMax(),
                    webInput.getReservedBooleanAlpha(),
                    webInput.getReservedBooleanBravo(),
                    webInput.getReservedDateAlphaMin(),
                    webInput.getReservedDateAlphaMax(),
                    webInput.getReservedDateBravoMin(),
                    webInput.getReservedDateBravoMax()
            );
        }
    }

    @JSONField(name = "string_id_pattern", ordinal = 1)
    private String stringIdPattern;

    @JSONField(name = "remark_pattern", ordinal = 2)
    private String remarkPattern;

    @JSONField(name = "reserved_string_alpha_pattern", ordinal = 3)
    private String reservedStringAlphaPattern;

    @JSONField(name = "reserved_string_bravo_pattern", ordinal = 4)
    private String reservedStringBravoPattern;

    @JSONField(name = "reserved_string_charlie_pattern", ordinal = 5)
    private String reservedStringCharliePattern;

    @JSONField(name = "reserved_string_delta_pattern", ordinal = 6)
    private String reservedStringDeltaPattern;

    @JSONField(name = "reserved_long_alpha_min", ordinal = 7)
    private Long reservedLongAlphaMin;

    @JSONField(name = "reserved_long_alpha_max", ordinal = 8)
    private Long reservedLongAlphaMax;

    @JSONField(name = "reserved_long_bravo_min", ordinal = 9)
    private Long reservedLongBravoMin;

    @JSONField(name = "reserved_long_bravo_max", ordinal = 10)
    private Long reservedLongBravoMax;

    @JSONField(name = "reserved_integer_alpha_min", ordinal = 11)
    private Integer reservedIntegerAlphaMin;

    @JSONField(name = "reserved_integer_alpha_max", ordinal = 12)
    private Integer reservedIntegerAlphaMax;

    @JSONField(name = "reserved_integer_bravo_min", ordinal = 13)
    private Integer reservedIntegerBravoMin;

    @JSONField(name = "reserved_integer_bravo_max", ordinal = 14)
    private Integer reservedIntegerBravoMax;

    @JSONField(name = "reserved_boolean_alpha", ordinal = 15)
    private Boolean reservedBooleanAlpha;

    @JSONField(name = "reserved_boolean_bravo", ordinal = 16)
    private Boolean reservedBooleanBravo;

    @JSONField(name = "reserved_date_alpha_min", ordinal = 17)
    private Date reservedDateAlphaMin;

    @JSONField(name = "reserved_date_alpha_max", ordinal = 18)
    private Date reservedDateAlphaMax;

    @JSONField(name = "reserved_date_bravo_min", ordinal = 19)
    private Date reservedDateBravoMin;

    @JSONField(name = "reserved_date_bravo_max", ordinal = 20)
    private Date reservedDateBravoMax;

    public WebInputUserCompositeLookupInfo() {
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
        return "WebInputUserCompositeLookupInfo{" +
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
