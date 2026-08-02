package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.NotificationClearForUserInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 通知按用户清除信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputNotificationClearForUserInfo implements Dto {

    private static final long serialVersionUID = 7439416246829354786L;

    public static NotificationClearForUserInfo toStackBean(WebInputNotificationClearForUserInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new NotificationClearForUserInfo(WebInputStringIdKey.toStackBean(webInput.getUserKey()));
        }
    }

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    public WebInputNotificationClearForUserInfo() {
    }

    public WebInputNotificationClearForUserInfo(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "WebInputNotificationClearForUserInfo{" +
                "userKey=" + userKey +
                '}';
    }
}
