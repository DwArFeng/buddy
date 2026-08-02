package com.dwarfeng.buddy.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 通知按用户全部阅读信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class NotificationReadAllForUserInfo implements Dto {

    private static final long serialVersionUID = 701612780187000785L;

    private StringIdKey userKey;

    public NotificationReadAllForUserInfo() {
    }

    public NotificationReadAllForUserInfo(StringIdKey userKey) {
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
        return "NotificationReadAllForUserInfo{" +
                "userKey=" + userKey +
                '}';
    }
}
