package com.dwarfeng.buddy.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.sdk.util.Constraints;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

/**
 * WebInput 个人简介。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputProfile implements Bean {

    private static final long serialVersionUID = 3381974463941846498L;

    public static Profile toStackBean(WebInputProfile webInputProfile) {
        if (Objects.isNull(webInputProfile)) {
            return null;
        } else {
            return new Profile(
                    WebInputStringIdKey.toStackBean(webInputProfile.getKey()),
                    webInputProfile.getName(),
                    webInputProfile.getPhoneNumber(),
                    webInputProfile.getEmailAddress(),
                    webInputProfile.getRemark(),
                    webInputProfile.getReservedStringAlpha(),
                    webInputProfile.getReservedStringBravo(),
                    webInputProfile.getReservedStringCharlie(),
                    webInputProfile.getReservedStringDelta(),
                    webInputProfile.getReservedStringEcho(),
                    webInputProfile.getReservedStringFoxtrot(),
                    webInputProfile.getReservedStringGolf(),
                    webInputProfile.getReservedStringHotel(),
                    webInputProfile.getReservedLongAlpha(),
                    webInputProfile.getReservedLongBravo(),
                    webInputProfile.getReservedLongCharlie(),
                    webInputProfile.getReservedLongDelta(),
                    webInputProfile.getReservedIntegerAlpha(),
                    webInputProfile.getReservedIntegerBravo(),
                    webInputProfile.getReservedIntegerCharlie(),
                    webInputProfile.getReservedIntegerDelta(),
                    webInputProfile.getReservedBooleanAlpha(),
                    webInputProfile.getReservedBooleanBravo(),
                    webInputProfile.getReservedBooleanCharlie(),
                    webInputProfile.getReservedBooleanDelta(),
                    webInputProfile.getReservedDateAlpha(),
                    webInputProfile.getReservedDateBravo(),
                    webInputProfile.getReservedDateCharlie(),
                    webInputProfile.getReservedDateDelta()
            );
        }
    }

    @JSONField(name = "key")
    @Valid
    private WebInputStringIdKey key;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "phone_number")
    private String phoneNumber;

    @JSONField(name = "email_address")
    private String emailAddress;

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

    @JSONField(name = "reserved_string_echo")
    @Length(max = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringEcho;

    @JSONField(name = "reserved_string_foxtrot")
    @Length(max = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringFoxtrot;

    @JSONField(name = "reserved_string_golf")
    @Length(max = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringGolf;

    @JSONField(name = "reserved_string_hotel")
    @Length(max = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringHotel;

    @JSONField(name = "reserved_long_alpha")
    private Long reservedLongAlpha;

    @JSONField(name = "reserved_long_bravo")
    private Long reservedLongBravo;

    @JSONField(name = "reserved_long_charlie")
    private Long reservedLongCharlie;

    @JSONField(name = "reserved_long_delta")
    private Long reservedLongDelta;

    @JSONField(name = "reserved_integer_alpha")
    private Integer reservedIntegerAlpha;

    @JSONField(name = "reserved_integer_bravo")
    private Integer reservedIntegerBravo;

    @JSONField(name = "reserved_integer_charlie")
    private Integer reservedIntegerCharlie;

    @JSONField(name = "reserved_integer_delta")
    private Integer reservedIntegerDelta;

    @JSONField(name = "reserved_boolean_alpha")
    private Boolean reservedBooleanAlpha;

    @JSONField(name = "reserved_boolean_bravo")
    private Boolean reservedBooleanBravo;

    @JSONField(name = "reserved_boolean_charlie")
    private Boolean reservedBooleanCharlie;

    @JSONField(name = "reserved_boolean_delta")
    private Boolean reservedBooleanDelta;

    @JSONField(name = "reserved_date_alpha")
    private Date reservedDateAlpha;

    @JSONField(name = "reserved_date_bravo")
    private Date reservedDateBravo;

    @JSONField(name = "reserved_date_charlie")
    private Date reservedDateCharlie;

    @JSONField(name = "reserved_date_delta")
    private Date reservedDateDelta;

    public WebInputProfile() {
    }

    public WebInputStringIdKey getKey() {
        return key;
    }

    public void setKey(WebInputStringIdKey key) {
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
        return "WebInputProfile{" +
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
