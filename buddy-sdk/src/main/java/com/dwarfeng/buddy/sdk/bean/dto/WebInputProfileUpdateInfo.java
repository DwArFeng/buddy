package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 个人简介更新信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputProfileUpdateInfo implements Dto {

    private static final long serialVersionUID = -2257829305342394353L;

    public static ProfileUpdateInfo toStackBean(WebInputProfileUpdateInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new ProfileUpdateInfo(
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.getName(),
                    webInput.getPhoneNumber(),
                    webInput.getEmailAddress(),
                    webInput.getRemark()
            );
        }
    }

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    // -----------------------------------------------------------基本信息-----------------------------------------------------------
    @JSONField(name = "name")
    private String name;

    // -----------------------------------------------------------联系方式-----------------------------------------------------------

    @JSONField(name = "phone_number")
    private String phoneNumber;

    @JSONField(name = "email_address")
    private String emailAddress;

    // -----------------------------------------------------------杂项-----------------------------------------------------------
    @JSONField(name = "remark")
    private String remark;

    public WebInputProfileUpdateInfo() {
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
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
        return "WebInputProfileUpdateInfo{" +
                "userKey=" + userKey +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
