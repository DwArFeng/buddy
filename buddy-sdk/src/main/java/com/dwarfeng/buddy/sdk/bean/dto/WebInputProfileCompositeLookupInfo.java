package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.ProfileCompositeLookupInfo;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Date;
import java.util.Objects;

/**
 * WebInput 个人简介组合查询信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputProfileCompositeLookupInfo implements Dto {

    private static final long serialVersionUID = -5155250994922426162L;

    public static ProfileCompositeLookupInfo toStackBean(WebInputProfileCompositeLookupInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            ProfileCompositeLookupInfo info = new ProfileCompositeLookupInfo();
            info.setStringIdPattern(webInput.getStringIdPattern());
            info.setNamePattern(webInput.getNamePattern());
            info.setPhoneNumberPattern(webInput.getPhoneNumberPattern());
            info.setEmailAddressPattern(webInput.getEmailAddressPattern());
            info.setRemarkPattern(webInput.getRemarkPattern());
            info.setReservedStringAlphaPattern(webInput.getReservedStringAlphaPattern());
            info.setReservedStringBravoPattern(webInput.getReservedStringBravoPattern());
            info.setReservedStringCharliePattern(webInput.getReservedStringCharliePattern());
            info.setReservedStringDeltaPattern(webInput.getReservedStringDeltaPattern());
            info.setReservedStringEchoPattern(webInput.getReservedStringEchoPattern());
            info.setReservedStringFoxtrotPattern(webInput.getReservedStringFoxtrotPattern());
            info.setReservedStringGolfPattern(webInput.getReservedStringGolfPattern());
            info.setReservedStringHotelPattern(webInput.getReservedStringHotelPattern());
            info.setReservedLongAlphaMin(webInput.getReservedLongAlphaMin());
            info.setReservedLongAlphaMax(webInput.getReservedLongAlphaMax());
            info.setReservedLongBravoMin(webInput.getReservedLongBravoMin());
            info.setReservedLongBravoMax(webInput.getReservedLongBravoMax());
            info.setReservedLongCharlieMin(webInput.getReservedLongCharlieMin());
            info.setReservedLongCharlieMax(webInput.getReservedLongCharlieMax());
            info.setReservedLongDeltaMin(webInput.getReservedLongDeltaMin());
            info.setReservedLongDeltaMax(webInput.getReservedLongDeltaMax());
            info.setReservedIntegerAlphaMin(webInput.getReservedIntegerAlphaMin());
            info.setReservedIntegerAlphaMax(webInput.getReservedIntegerAlphaMax());
            info.setReservedIntegerBravoMin(webInput.getReservedIntegerBravoMin());
            info.setReservedIntegerBravoMax(webInput.getReservedIntegerBravoMax());
            info.setReservedIntegerCharlieMin(webInput.getReservedIntegerCharlieMin());
            info.setReservedIntegerCharlieMax(webInput.getReservedIntegerCharlieMax());
            info.setReservedIntegerDeltaMin(webInput.getReservedIntegerDeltaMin());
            info.setReservedIntegerDeltaMax(webInput.getReservedIntegerDeltaMax());
            info.setReservedBooleanAlpha(webInput.getReservedBooleanAlpha());
            info.setReservedBooleanBravo(webInput.getReservedBooleanBravo());
            info.setReservedBooleanCharlie(webInput.getReservedBooleanCharlie());
            info.setReservedBooleanDelta(webInput.getReservedBooleanDelta());
            info.setReservedDateAlphaMin(webInput.getReservedDateAlphaMin());
            info.setReservedDateAlphaMax(webInput.getReservedDateAlphaMax());
            info.setReservedDateBravoMin(webInput.getReservedDateBravoMin());
            info.setReservedDateBravoMax(webInput.getReservedDateBravoMax());
            info.setReservedDateCharlieMin(webInput.getReservedDateCharlieMin());
            info.setReservedDateCharlieMax(webInput.getReservedDateCharlieMax());
            info.setReservedDateDeltaMin(webInput.getReservedDateDeltaMin());
            info.setReservedDateDeltaMax(webInput.getReservedDateDeltaMax());
            return info;
        }
    }

    @JSONField(name = "string_id_pattern", ordinal = 1)
    private String stringIdPattern;

    @JSONField(name = "name_pattern", ordinal = 2)
    private String namePattern;

    @JSONField(name = "phone_number_pattern", ordinal = 3)
    private String phoneNumberPattern;

    @JSONField(name = "email_address_pattern", ordinal = 4)
    private String emailAddressPattern;

    @JSONField(name = "remark_pattern", ordinal = 5)
    private String remarkPattern;

    @JSONField(name = "reserved_string_alpha_pattern", ordinal = 6)
    private String reservedStringAlphaPattern;

    @JSONField(name = "reserved_string_bravo_pattern", ordinal = 7)
    private String reservedStringBravoPattern;

    @JSONField(name = "reserved_string_charlie_pattern", ordinal = 8)
    private String reservedStringCharliePattern;

    @JSONField(name = "reserved_string_delta_pattern", ordinal = 9)
    private String reservedStringDeltaPattern;

    @JSONField(name = "reserved_string_echo_pattern", ordinal = 10)
    private String reservedStringEchoPattern;

    @JSONField(name = "reserved_string_foxtrot_pattern", ordinal = 11)
    private String reservedStringFoxtrotPattern;

    @JSONField(name = "reserved_string_golf_pattern", ordinal = 12)
    private String reservedStringGolfPattern;

    @JSONField(name = "reserved_string_hotel_pattern", ordinal = 13)
    private String reservedStringHotelPattern;

    @JSONField(name = "reserved_long_alpha_min", ordinal = 14)
    private Long reservedLongAlphaMin;

    @JSONField(name = "reserved_long_alpha_max", ordinal = 15)
    private Long reservedLongAlphaMax;

    @JSONField(name = "reserved_long_bravo_min", ordinal = 16)
    private Long reservedLongBravoMin;

    @JSONField(name = "reserved_long_bravo_max", ordinal = 17)
    private Long reservedLongBravoMax;

    @JSONField(name = "reserved_long_charlie_min", ordinal = 18)
    private Long reservedLongCharlieMin;

    @JSONField(name = "reserved_long_charlie_max", ordinal = 19)
    private Long reservedLongCharlieMax;

    @JSONField(name = "reserved_long_delta_min", ordinal = 20)
    private Long reservedLongDeltaMin;

    @JSONField(name = "reserved_long_delta_max", ordinal = 21)
    private Long reservedLongDeltaMax;

    @JSONField(name = "reserved_integer_alpha_min", ordinal = 22)
    private Integer reservedIntegerAlphaMin;

    @JSONField(name = "reserved_integer_alpha_max", ordinal = 23)
    private Integer reservedIntegerAlphaMax;

    @JSONField(name = "reserved_integer_bravo_min", ordinal = 24)
    private Integer reservedIntegerBravoMin;

    @JSONField(name = "reserved_integer_bravo_max", ordinal = 25)
    private Integer reservedIntegerBravoMax;

    @JSONField(name = "reserved_integer_charlie_min", ordinal = 26)
    private Integer reservedIntegerCharlieMin;

    @JSONField(name = "reserved_integer_charlie_max", ordinal = 27)
    private Integer reservedIntegerCharlieMax;

    @JSONField(name = "reserved_integer_delta_min", ordinal = 28)
    private Integer reservedIntegerDeltaMin;

    @JSONField(name = "reserved_integer_delta_max", ordinal = 29)
    private Integer reservedIntegerDeltaMax;

    @JSONField(name = "reserved_boolean_alpha", ordinal = 30)
    private Boolean reservedBooleanAlpha;

    @JSONField(name = "reserved_boolean_bravo", ordinal = 31)
    private Boolean reservedBooleanBravo;

    @JSONField(name = "reserved_boolean_charlie", ordinal = 32)
    private Boolean reservedBooleanCharlie;

    @JSONField(name = "reserved_boolean_delta", ordinal = 33)
    private Boolean reservedBooleanDelta;

    @JSONField(name = "reserved_date_alpha_min", ordinal = 34)
    private Date reservedDateAlphaMin;

    @JSONField(name = "reserved_date_alpha_max", ordinal = 35)
    private Date reservedDateAlphaMax;

    @JSONField(name = "reserved_date_bravo_min", ordinal = 36)
    private Date reservedDateBravoMin;

    @JSONField(name = "reserved_date_bravo_max", ordinal = 37)
    private Date reservedDateBravoMax;

    @JSONField(name = "reserved_date_charlie_min", ordinal = 38)
    private Date reservedDateCharlieMin;

    @JSONField(name = "reserved_date_charlie_max", ordinal = 39)
    private Date reservedDateCharlieMax;

    @JSONField(name = "reserved_date_delta_min", ordinal = 40)
    private Date reservedDateDeltaMin;

    @JSONField(name = "reserved_date_delta_max", ordinal = 41)
    private Date reservedDateDeltaMax;

    public WebInputProfileCompositeLookupInfo() {
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
        return "WebInputProfileCompositeLookupInfo{" +
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
