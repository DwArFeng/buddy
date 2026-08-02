package com.dwarfeng.buddy.impl.handler;

import com.dwarfeng.buddy.stack.exception.AvatarNotExistsException;
import com.dwarfeng.buddy.stack.exception.NotificationNotExistsException;
import com.dwarfeng.buddy.stack.exception.UserNotExistsException;
import com.dwarfeng.buddy.stack.service.AvatarInfoMaintainService;
import com.dwarfeng.buddy.stack.service.NotificationMaintainService;
import com.dwarfeng.buddy.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 操作处理器验证器。
 *
 * <p>
 * 为操作处理器提供公共的验证方法。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Component
public class HandlerValidator {

    private final UserMaintainService userMaintainService;
    private final AvatarInfoMaintainService avatarInfoMaintainService;
    private final NotificationMaintainService notificationMaintainService;

    public HandlerValidator(
            UserMaintainService userMaintainService,
            AvatarInfoMaintainService avatarInfoMaintainService,
            NotificationMaintainService notificationMaintainService
    ) {
        this.userMaintainService = userMaintainService;
        this.avatarInfoMaintainService = avatarInfoMaintainService;
        this.notificationMaintainService = notificationMaintainService;
    }

    public void makeSureUserExists(StringIdKey userKey) throws HandlerException {
        try {
            if (!userMaintainService.exists(userKey)) {
                throw new UserNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureAvatarExists(StringIdKey userKey) throws HandlerException {
        try {
            if (!avatarInfoMaintainService.exists(userKey)) {
                throw new AvatarNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    public void makeSureNotificationExists(LongIdKey notificationKey) throws HandlerException {
        try {
            if (Objects.isNull(notificationKey) || !notificationMaintainService.exists(notificationKey)) {
                throw new NotificationNotExistsException(notificationKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }
}
