package com.dwarfeng.buddy.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 个人简介更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class ProfileUpdateInfo implements Dto {

    private static final long serialVersionUID = -232344502420679377L;

    // -----------------------------------------------------------基本信息-----------------------------------------------------------
    private StringIdKey userKey;
    private String name;

    // -----------------------------------------------------------联系方式-----------------------------------------------------------
    private String phoneNumber;
    private String emailAddress;

    // -----------------------------------------------------------杂项-----------------------------------------------------------
    private String remark;

    public ProfileUpdateInfo() {
    }

    public ProfileUpdateInfo(StringIdKey userKey, String name, String phoneNumber, String emailAddress, String remark) {
        this.userKey = userKey;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.remark = remark;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
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

    @Override
    public String toString() {
        return "ProfileUpdateInfo{" +
                "userKey=" + userKey +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
