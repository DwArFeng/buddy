package com.dwarfeng.buddy.impl.handler;

import com.dwarfeng.buddy.stack.bean.dto.AvatarFile;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFileDownloadInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarRemoveInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.buddy.stack.exception.AvatarNotExistsException;
import com.dwarfeng.buddy.stack.exception.UserNotExistsException;
import com.dwarfeng.buddy.stack.handler.AvatarOperateHandler;
import com.dwarfeng.buddy.stack.service.AvatarInfoMaintainService;
import com.dwarfeng.buddy.stack.service.UserMaintainService;
import com.dwarfeng.ftp.stack.handler.FtpHandler;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 头像操作处理器实现。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Component
public class AvatarOperateHandlerImpl implements AvatarOperateHandler {

    private final UserMaintainService userMaintainService;
    private final AvatarInfoMaintainService avatarInfoMaintainService;

    private final FtpHandler ftpHandler;

    private final FtpPathResolver ftpPathResolver;

    public AvatarOperateHandlerImpl(
            UserMaintainService userMaintainService,
            AvatarInfoMaintainService avatarInfoMaintainService,
            FtpHandler ftpHandler,
            FtpPathResolver ftpPathResolver
    ) {
        this.userMaintainService = userMaintainService;
        this.avatarInfoMaintainService = avatarInfoMaintainService;
        this.ftpHandler = ftpHandler;
        this.ftpPathResolver = ftpPathResolver;
    }

    @Override
    public AvatarFile downloadFile(AvatarFileDownloadInfo info) throws HandlerException {
        try {
            StringIdKey userKey = info.getUserKey();
            makeSureUserExists(userKey);
            makeSureAvatarExists(userKey);

            AvatarInfo avatarInfo = avatarInfoMaintainService.get(userKey);

            byte[] content = ftpHandler.retrieveFile(
                    ftpPathResolver.resolvePath(FtpPathResolver.RELATIVE_PATH_AVATAR), userKey.getStringId()
            );

            return new AvatarFile(avatarInfo.getOriginName(), content);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void uploadFile(AvatarUploadInfo info) throws HandlerException {
        try {
            StringIdKey userKey = info.getUserKey();
            makeSureUserExists(userKey);

            byte[] content = info.getContent();
            ftpHandler.storeFile(
                    ftpPathResolver.resolvePath(FtpPathResolver.RELATIVE_PATH_AVATAR), userKey.getStringId(), content
            );

            AvatarInfo avatarInfo = new AvatarInfo(
                    userKey, info.getOriginName(), content.length, new Date(),
                    "由 buddy 微服务进行上传"
            );
            avatarInfoMaintainService.insertOrUpdate(avatarInfo);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    @Override
    public void remove(AvatarRemoveInfo info) throws HandlerException {
        try {
            StringIdKey userKey = info.getUserKey();
            makeSureUserExists(userKey);

            if (ftpHandler.existsFile(
                    ftpPathResolver.resolvePath(FtpPathResolver.RELATIVE_PATH_AVATAR), userKey.getStringId()
            )) {
                ftpHandler.deleteFile(
                        ftpPathResolver.resolvePath(FtpPathResolver.RELATIVE_PATH_AVATAR), userKey.getStringId()
                );
            }

            avatarInfoMaintainService.deleteIfExists(userKey);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }

    private void makeSureUserExists(StringIdKey userKey) throws HandlerException {
        try {
            if (!userMaintainService.exists(userKey)) {
                throw new UserNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }

    private void makeSureAvatarExists(StringIdKey userKey) throws HandlerException {
        try {
            if (!avatarInfoMaintainService.exists(userKey)) {
                throw new AvatarNotExistsException(userKey);
            }
        } catch (ServiceException e) {
            throw new HandlerException(e);
        }
    }
}
