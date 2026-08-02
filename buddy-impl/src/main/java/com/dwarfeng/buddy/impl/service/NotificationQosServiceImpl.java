package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.dto.NotificationClearForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadAllForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadInfo;
import com.dwarfeng.buddy.stack.handler.NotificationOperateHandler;
import com.dwarfeng.buddy.stack.service.NotificationQosService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

/**
 * 通知 QOS 服务实现。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Service
public class NotificationQosServiceImpl implements NotificationQosService {

    private final NotificationOperateHandler notificationOperateHandler;

    private final ServiceExceptionMapper sem;

    public NotificationQosServiceImpl(
            NotificationOperateHandler notificationOperateHandler, ServiceExceptionMapper sem
    ) {
        this.notificationOperateHandler = notificationOperateHandler;
        this.sem = sem;
    }

    @Override
    public LongIdKey create(NotificationCreateInfo info) throws ServiceException {
        try {
            return notificationOperateHandler.create(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("创建通知时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void read(NotificationReadInfo info) throws ServiceException {
        try {
            notificationOperateHandler.read(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("阅读通知时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void readAllForUser(NotificationReadAllForUserInfo info) throws ServiceException {
        try {
            notificationOperateHandler.readAllForUser(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("阅读用户的所有通知时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void clearForUser(NotificationClearForUserInfo info) throws ServiceException {
        try {
            notificationOperateHandler.clearForUser(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("清除用户的所有通知时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
