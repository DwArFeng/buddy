package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadAllForUserInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 通知按用户全部阅读信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputNotificationReadAllForUserInfo implements Dto {

    private static final long serialVersionUID = 8331586057373539849L;

    public static NotificationReadAllForUserInfo toStackBean(WebInputNotificationReadAllForUserInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new NotificationReadAllForUserInfo(WebInputStringIdKey.toStackBean(webInput.getUserKey()));
        }
    }

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    public WebInputNotificationReadAllForUserInfo() {
    }

    public WebInputNotificationReadAllForUserInfo(WebInputStringIdKey userKey) {
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
        return "WebInputNotificationReadAllForUserInfo{" +
                "userKey=" + userKey +
                '}';
    }
}
