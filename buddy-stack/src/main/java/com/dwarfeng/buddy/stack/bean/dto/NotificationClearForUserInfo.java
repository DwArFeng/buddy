package com.dwarfeng.buddy.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 通知按用户清除信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class NotificationClearForUserInfo implements Dto {

    private static final long serialVersionUID = -4079214332957937879L;

    private StringIdKey userKey;

    public NotificationClearForUserInfo() {
    }

    public NotificationClearForUserInfo(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "NotificationClearForUserInfo{" +
                "userKey=" + userKey +
                '}';
    }
}
