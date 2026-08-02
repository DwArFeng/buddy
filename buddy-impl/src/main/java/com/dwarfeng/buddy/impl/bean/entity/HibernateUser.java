package com.dwarfeng.buddy.impl.bean.entity;

import com.dwarfeng.buddy.sdk.util.Constraints;
import com.dwarfeng.datamark.sdk.jpa.DatamarkEntityListener;
import com.dwarfeng.datamark.sdk.jpa.DatamarkField;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@IdClass(HibernateStringIdKey.class)
@Table(name = "tbl_user")
@EntityListeners(DatamarkEntityListener.class)
public class HibernateUser implements Bean {

    private static final long serialVersionUID = 8033738246857415735L;

    // region 主键

    @Id
    @Column(name = "id", nullable = false, unique = true, length = Constraints.LENGTH_USER)
    private String stringId;

    // endregion

    // region 主属性字段

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

    @Column(name = "reserved_long_alpha")
    private Long reservedLongAlpha;

    @Column(name = "reserved_long_bravo")
    private Long reservedLongBravo;

    @Column(name = "reserved_integer_alpha")
    private Integer reservedIntegerAlpha;

    @Column(name = "reserved_integer_bravo")
    private Integer reservedIntegerBravo;

    @Column(name = "reserved_boolean_alpha")
    private Boolean reservedBooleanAlpha;

    @Column(name = "reserved_boolean_bravo")
    private Boolean reservedBooleanBravo;

    @Column(name = "reserved_date_alpha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservedDateAlpha;

    @Column(name = "reserved_date_bravo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservedDateBravo;

    // endregion

    // region 一对一

    @OneToOne(cascade = CascadeType.MERGE, targetEntity = HibernateAvatarInfo.class, mappedBy = "user")
    private HibernateAvatarInfo avatarInfo;

    @OneToOne(cascade = CascadeType.MERGE, targetEntity = HibernateProfile.class, mappedBy = "user")
    private HibernateProfile profile;

    // endregion

    // region 一对多

    @OneToMany(cascade = CascadeType.MERGE, targetEntity = HibernateNotification.class, mappedBy = "user")
    private Set<HibernateNotification> notificationSet = new HashSet<>();

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

    public HibernateUser() {
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

    public HibernateAvatarInfo getAvatarInfo() {
        return avatarInfo;
    }

    public void setAvatarInfo(HibernateAvatarInfo avatarInfo) {
        this.avatarInfo = avatarInfo;
    }

    public HibernateProfile getProfile() {
        return profile;
    }

    public void setProfile(HibernateProfile profile) {
        this.profile = profile;
    }

    public Set<HibernateNotification> getNotificationSet() {
        return notificationSet;
    }

    public void setNotificationSet(Set<HibernateNotification> notificationSet) {
        this.notificationSet = notificationSet;
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
                "remark = " + remark + ", " +
                "reservedStringAlpha = " + reservedStringAlpha + ", " +
                "reservedStringBravo = " + reservedStringBravo + ", " +
                "reservedStringCharlie = " + reservedStringCharlie + ", " +
                "reservedStringDelta = " + reservedStringDelta + ", " +
                "reservedLongAlpha = " + reservedLongAlpha + ", " +
                "reservedLongBravo = " + reservedLongBravo + ", " +
                "reservedIntegerAlpha = " + reservedIntegerAlpha + ", " +
                "reservedIntegerBravo = " + reservedIntegerBravo + ", " +
                "reservedBooleanAlpha = " + reservedBooleanAlpha + ", " +
                "reservedBooleanBravo = " + reservedBooleanBravo + ", " +
                "reservedDateAlpha = " + reservedDateAlpha + ", " +
                "reservedDateBravo = " + reservedDateBravo + ", " +
                "avatarInfo = " + avatarInfo + ", " +
                "profile = " + profile + ", " +
                "createdDatamark = " + createdDatamark + ", " +
                "modifiedDatamark = " + modifiedDatamark + ")";
    }
}
