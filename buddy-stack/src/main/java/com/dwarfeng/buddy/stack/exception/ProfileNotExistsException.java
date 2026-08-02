package com.dwarfeng.buddy.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * 个人简介不存在异常。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class ProfileNotExistsException extends HandlerException {

    private static final long serialVersionUID = -2921147414234606497L;

    private final StringIdKey profileKey;

    public ProfileNotExistsException(StringIdKey profileKey) {
        this.profileKey = profileKey;
    }

    public ProfileNotExistsException(Throwable cause, StringIdKey profileKey) {
        super(cause);
        this.profileKey = profileKey;
    }

    @Override
    public String getMessage() {
        return "个人简介 " + profileKey + " 不存在";
    }
}
