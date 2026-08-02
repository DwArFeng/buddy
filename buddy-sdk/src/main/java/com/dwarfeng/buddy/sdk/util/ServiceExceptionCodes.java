package com.dwarfeng.buddy.sdk.util;

import com.dwarfeng.subgrade.stack.exception.ServiceException;

/**
 * 服务异常码。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public final class ServiceExceptionCodes {

    private static int exceptionCodeOffset = 10000;

    public static final ServiceException.Code PROFILE_NOT_EXISTS =
            new ServiceException.Code(offset(0), "profile not exists");
    public static final ServiceException.Code NOTIFICATION_NOT_EXISTS =
            new ServiceException.Code(offset(10), "notification not exists");
    public static final ServiceException.Code USER_NOT_EXISTS =
            new ServiceException.Code(offset(20), "user not exists");
    public static final ServiceException.Code AVATAR_NOT_EXISTS =
            new ServiceException.Code(offset(30), "avatar not exists");

    private static int offset(int i) {
        return exceptionCodeOffset + i;
    }

    public static int getExceptionCodeOffset() {
        return exceptionCodeOffset;
    }

    public static void setExceptionCodeOffset(int exceptionCodeOffset) {
        ServiceExceptionCodes.exceptionCodeOffset = exceptionCodeOffset;

        PROFILE_NOT_EXISTS.setCode(offset(0));
        NOTIFICATION_NOT_EXISTS.setCode(offset(10));
        USER_NOT_EXISTS.setCode(offset(20));
        AVATAR_NOT_EXISTS.setCode(offset(30));
    }

    private ServiceExceptionCodes() {
        throw new AssertionError();
    }
}
