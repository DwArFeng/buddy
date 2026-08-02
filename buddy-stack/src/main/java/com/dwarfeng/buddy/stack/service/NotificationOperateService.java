package com.dwarfeng.buddy.stack.service;

import com.dwarfeng.buddy.stack.bean.dto.NotificationClearForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadAllForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadInfo;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 通知操作服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface NotificationOperateService extends Service {

    /**
     * 创建通知。
     *
     * @param info 通知的创建信息。
     * @return 生成的通知的主键。
     * @throws ServiceException 服务异常。
     */
    LongIdKey create(NotificationCreateInfo info) throws ServiceException;

    /**
     * 阅读通知。
     *
     * @param info 通知的阅读信息。
     * @throws ServiceException 服务异常。
     */
    void read(NotificationReadInfo info) throws ServiceException;

    /**
     * 阅读用户的所有通知。
     *
     * @param info 通知的按用户全部阅读信息。
     * @throws ServiceException 服务异常。
     */
    void readAllForUser(NotificationReadAllForUserInfo info) throws ServiceException;

    /**
     * 清除用户的所有通知。
     *
     * @param info 通知的按用户清除信息。
     * @throws ServiceException 服务异常。
     */
    void clearForUser(NotificationClearForUserInfo info) throws ServiceException;
}
