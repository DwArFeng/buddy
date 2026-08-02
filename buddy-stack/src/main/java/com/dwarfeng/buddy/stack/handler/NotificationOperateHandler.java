package com.dwarfeng.buddy.stack.handler;

import com.dwarfeng.buddy.stack.bean.dto.NotificationClearForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadAllForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 通知操作处理器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface NotificationOperateHandler extends Handler {

    /**
     * 创建通知。
     *
     * @param info 通知的创建信息。
     * @return 生成的通知的主键。
     * @throws HandlerException 处理器异常。
     */
    LongIdKey create(NotificationCreateInfo info) throws HandlerException;

    /**
     * 阅读通知。
     *
     * @param info 通知的阅读信息。
     * @throws HandlerException 处理器异常。
     */
    void read(NotificationReadInfo info) throws HandlerException;

    /**
     * 阅读用户的所有通知。
     *
     * @param info 通知的按用户全部阅读信息。
     * @throws HandlerException 处理器异常。
     */
    void readAllForUser(NotificationReadAllForUserInfo info) throws HandlerException;

    /**
     * 清除用户的所有通知。
     *
     * @param info 通知的按用户清除信息。
     * @throws HandlerException 处理器异常。
     */
    void clearForUser(NotificationClearForUserInfo info) throws HandlerException;
}
