package com.dwarfeng.buddy.sdk.util;

/**
 * 约束类。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public final class Constraints {

    /**
     * 名称的长度约束。
     */
    public static final int LENGTH_NAME = 20;

    /**
     * 备注的长度约束。
     */
    public static final int LENGTH_REMARK = 100;

    /**
     * 主键的长度约束。
     */
    public static final int LENGTH_ID = 50;

    /**
     * 用户主键的长度约束。
     */
    public static final int LENGTH_USER = 50;

    /**
     * 主题的长度约束。
     */
    public static final int LENGTH_SUBJECT = 100;

    /**
     * 原始名称的长度约束。
     */
    public static final int LENGTH_ORIGIN_NAME = 250;

    /**
     * 预留字符串的长度约束。
     */
    public static final int LENGTH_RESERVED_STRING = 500;

    private Constraints() {
        throw new IllegalStateException("禁止实例化");
    }
}
