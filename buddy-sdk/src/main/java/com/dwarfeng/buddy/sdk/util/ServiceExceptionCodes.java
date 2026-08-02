package com.dwarfeng.buddy.sdk.util;

/**
 * 服务异常码。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public final class ServiceExceptionCodes {

    private static int exceptionCodeOffset;

    private ServiceExceptionCodes() {
        throw new AssertionError();
    }

    public static void setExceptionCodeOffset(int exceptionCodeOffset) {
        ServiceExceptionCodes.exceptionCodeOffset = exceptionCodeOffset;
    }

    public static int getExceptionCodeOffset() {
        return exceptionCodeOffset;
    }
}
