package com.dwarfeng.buddy.impl.handler;

import com.dwarfeng.buddy.stack.bean.dto.NotificationClearForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadAllForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadInfo;
import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.buddy.stack.handler.NotificationOperateHandler;
import com.dwarfeng.buddy.stack.service.NotificationMaintainService;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通知操作处理器实现。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Component
public class NotificationOperateHandlerImpl implements NotificationOperateHandler {

    private final NotificationMaintainService notificationMaintainService;

    private final HandlerValidator HandlerValidator;

    public NotificationOperateHandlerImpl(
            NotificationMaintainService notificationMaintainService,
            HandlerValidator HandlerValidator
    ) {
        this.notificationMaintainService = notificationMaintainService;
        this.HandlerValidator = HandlerValidator;
    }

    @Override
    public LongIdKey create(NotificationCreateInfo info) throws HandlerException {
        try {
            StringIdKey userKey = info.getUserKey();

            HandlerValidator.makeSureUserExists(userKey);

            Date currentDate = new Date();
            Notification notification = new Notification(
                    null, userKey, info.getRemark(), currentDate, null, false,
                    info.getSubject(), info.getBody()
            );

            return notificationMaintainService.insert(notification);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void read(NotificationReadInfo info) throws HandlerException {
        try {
            LongIdKey notificationKey = info.getNotificationKey();
            HandlerValidator.makeSureNotificationExists(notificationKey);

            Date currentDate = new Date();
            Notification notification = notificationMaintainService.get(notificationKey);
            notification.setReadDate(currentDate);
            notification.setReadFlag(true);

            notificationMaintainService.update(notification);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void readAllForUser(NotificationReadAllForUserInfo info) throws HandlerException {
        try {
            StringIdKey userKey = info.getUserKey();
            HandlerValidator.makeSureUserExists(userKey);

            List<Notification> notifications = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER_UNREAD, new Object[]{userKey}
            ).getData();

            Date currentDate = new Date();
            for (Notification notification : notifications) {
                notification.setReadDate(currentDate);
                notification.setReadFlag(true);
            }

            notificationMaintainService.batchUpdate(notifications);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void clearForUser(NotificationClearForUserInfo info) throws HandlerException {
        try {
            StringIdKey userKey = info.getUserKey();
            HandlerValidator.makeSureUserExists(userKey);

            List<LongIdKey> notificationKeys = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER, new Object[]{userKey}
            ).getData().stream().map(Notification::getKey).collect(Collectors.toList());

            notificationMaintainService.batchDelete(notificationKeys);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }
}
