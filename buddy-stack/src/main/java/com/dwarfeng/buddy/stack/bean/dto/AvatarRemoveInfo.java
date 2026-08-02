package com.dwarfeng.buddy.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 头像移除信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class AvatarRemoveInfo implements Dto {

    private static final long serialVersionUID = 8737884773661202L;

    private StringIdKey userKey;

    public AvatarRemoveInfo() {
    }

    public AvatarRemoveInfo(StringIdKey userKey) {
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
        return "AvatarRemoveInfo{" +
                "userKey=" + userKey +
                '}';
    }
}
