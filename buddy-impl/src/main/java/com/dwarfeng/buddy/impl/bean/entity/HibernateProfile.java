package com.dwarfeng.buddy.impl.bean.entity;

import com.dwarfeng.buddy.sdk.util.Constraints;
import com.dwarfeng.datamark.sdk.jpa.DatamarkEntityListener;
import com.dwarfeng.datamark.sdk.jpa.DatamarkField;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@IdClass(HibernateStringIdKey.class)
@Table(name = "tbl_profile")
@EntityListeners(DatamarkEntityListener.class)
public class HibernateProfile implements Bean {

    private static final long serialVersionUID = 5904010104971669726L;

    // region 主键

    @Id
    @Column(name = "id", nullable = false, unique = true, length = Constraints.LENGTH_ID)
    private String stringId;

    // endregion

    // region 主属性字段

    @Column(name = "name", length = Constraints.LENGTH_NAME)
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "remark", length = Constraints.LENGTH_REMARK)
    private String remark;

    @Column(name = "reserved_string_alpha", length = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringAlpha;

    @Column(name = "reserved_string_bravo", length = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringBravo;

    @Column(name = "reserved_string_charlie", length = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringCharlie;

    @Column(name = "reserved_string_delta", length = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringDelta;

    @Column(name = "reserved_string_echo", length = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringEcho;

    @Column(name = "reserved_string_foxtrot", length = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringFoxtrot;

    @Column(name = "reserved_string_golf", length = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringGolf;

    @Column(name = "reserved_string_hotel", length = Constraints.LENGTH_RESERVED_STRING)
    private String reservedStringHotel;

    @Column(name = "reserved_long_alpha")
    private Long reservedLongAlpha;

    @Column(name = "reserved_long_bravo")
    private Long reservedLongBravo;

    @Column(name = "reserved_long_charlie")
    private Long reservedLongCharlie;

    @Column(name = "reserved_long_delta")
    private Long reservedLongDelta;

    @Column(name = "reserved_integer_alpha")
    private Integer reservedIntegerAlpha;

    @Column(name = "reserved_integer_bravo")
    private Integer reservedIntegerBravo;

    @Column(name = "reserved_integer_charlie")
    private Integer reservedIntegerCharlie;

    @Column(name = "reserved_integer_delta")
    private Integer reservedIntegerDelta;

    @Column(name = "reserved_boolean_alpha")
    private Boolean reservedBooleanAlpha;

    @Column(name = "reserved_boolean_bravo")
    private Boolean reservedBooleanBravo;

    @Column(name = "reserved_boolean_charlie")
    private Boolean reservedBooleanCharlie;

    @Column(name = "reserved_boolean_delta")
    private Boolean reservedBooleanDelta;

    @Column(name = "reserved_date_alpha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservedDateAlpha;

    @Column(name = "reserved_date_bravo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservedDateBravo;

    @Column(name = "reserved_date_charlie")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservedDateCharlie;

    @Column(name = "reserved_date_delta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservedDateDelta;

    // endregion

    // region 一对一

    @OneToOne(targetEntity = HibernateUser.class)
    @JoinColumns({ //
            @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false), //
    })
    private HibernateUser user;

    // endregion

    // region 审计

    @DatamarkField(handlerName = "userDatamarkHandler")
    @Column(
            name = "created_datamark",
            length = com.dwarfeng.datamark.sdk.util.Constraints.LENGTH_DATAMARK_VALUE,
            updatable = false
    )
    private String createdDatamark;

    @DatamarkField(handlerName = "userDatamarkHandler")
    @Column(
            name = "modified_datamark",
            length = com.dwarfeng.datamark.sdk.util.Constraints.LENGTH_DATAMARK_VALUE
    )
    private String modifiedDatamark;

    // endregion

    public HibernateProfile() {
    }

    // region 映射用属性区

    public HibernateStringIdKey getKey() {
        return Optional.ofNullable(stringId).map(HibernateStringIdKey::new).orElse(null);
    }

    public void setKey(HibernateStringIdKey key) {
        this.stringId = Optional.ofNullable(key).map(HibernateStringIdKey::getStringId).orElse(null);
    }

    // endregion

    // region 常规属性区

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
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

    public HibernateUser getUser() {
        return user;
    }

    public void setUser(HibernateUser user) {
        this.user = user;
    }

    public String getCreatedDatamark() {
        return createdDatamark;
    }

    public void setCreatedDatamark(String createdDatamark) {
        this.createdDatamark = createdDatamark;
    }

    public String getModifiedDatamark() {
        return modifiedDatamark;
    }

    public void setModifiedDatamark(String modifiedDatamark) {
        this.modifiedDatamark = modifiedDatamark;
    }

    // endregion

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "stringId = " + stringId + ", " +
                "name = " + name + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "emailAddress = " + emailAddress + ", " +
                "remark = " + remark + ", " +
                "reservedStringAlpha = " + reservedStringAlpha + ", " +
                "reservedStringBravo = " + reservedStringBravo + ", " +
                "reservedStringCharlie = " + reservedStringCharlie + ", " +
                "reservedStringDelta = " + reservedStringDelta + ", " +
                "reservedStringEcho = " + reservedStringEcho + ", " +
                "reservedStringFoxtrot = " + reservedStringFoxtrot + ", " +
                "reservedStringGolf = " + reservedStringGolf + ", " +
                "reservedStringHotel = " + reservedStringHotel + ", " +
                "reservedLongAlpha = " + reservedLongAlpha + ", " +
                "reservedLongBravo = " + reservedLongBravo + ", " +
                "reservedLongCharlie = " + reservedLongCharlie + ", " +
                "reservedLongDelta = " + reservedLongDelta + ", " +
                "reservedIntegerAlpha = " + reservedIntegerAlpha + ", " +
                "reservedIntegerBravo = " + reservedIntegerBravo + ", " +
                "reservedIntegerCharlie = " + reservedIntegerCharlie + ", " +
                "reservedIntegerDelta = " + reservedIntegerDelta + ", " +
                "reservedBooleanAlpha = " + reservedBooleanAlpha + ", " +
                "reservedBooleanBravo = " + reservedBooleanBravo + ", " +
                "reservedBooleanCharlie = " + reservedBooleanCharlie + ", " +
                "reservedBooleanDelta = " + reservedBooleanDelta + ", " +
                "reservedDateAlpha = " + reservedDateAlpha + ", " +
                "reservedDateBravo = " + reservedDateBravo + ", " +
                "reservedDateCharlie = " + reservedDateCharlie + ", " +
                "reservedDateDelta = " + reservedDateDelta + ", " +
                "user = " + user + ", " +
                "createdDatamark = " + createdDatamark + ", " +
                "modifiedDatamark = " + modifiedDatamark + ")";
    }
}
