package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 通知阅读信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputNotificationReadInfo implements Dto {

    private static final long serialVersionUID = 6637553656917266114L;

    public static NotificationReadInfo toStackBean(WebInputNotificationReadInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new NotificationReadInfo(WebInputLongIdKey.toStackBean(webInput.getNotificationKey()));
        }
    }

    @JSONField(name = "notification_key")
    @Valid
    private WebInputLongIdKey notificationKey;

    public WebInputNotificationReadInfo() {
    }

    public WebInputNotificationReadInfo(WebInputLongIdKey notificationKey) {
        this.notificationKey = notificationKey;
    }

    public WebInputLongIdKey getNotificationKey() {
        return notificationKey;
    }

    public void setNotificationKey(WebInputLongIdKey notificationKey) {
        this.notificationKey = notificationKey;
    }

    @Override
    public String toString() {
        return "WebInputNotificationReadInfo{" +
                "notificationKey=" + notificationKey +
                '}';
    }
}
