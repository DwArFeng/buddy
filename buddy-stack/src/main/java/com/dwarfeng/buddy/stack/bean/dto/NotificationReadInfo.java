package com.dwarfeng.buddy.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * 通知阅读信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class NotificationReadInfo implements Dto {

    private static final long serialVersionUID = -6475472836436518916L;

    private LongIdKey notificationKey;

    public NotificationReadInfo() {
    }

    public NotificationReadInfo(LongIdKey notificationKey) {
        this.notificationKey = notificationKey;
    }

    public LongIdKey getNotificationKey() {
        return notificationKey;
    }

    public void setNotificationKey(LongIdKey notificationKey) {
        this.notificationKey = notificationKey;
    }

    @Override
    public String toString() {
        return "NotificationReadInfo{" +
                "notificationKey=" + notificationKey +
                '}';
    }
}
