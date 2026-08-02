package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.dto.AvatarFile;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFileDownloadInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarRemoveInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.buddy.stack.handler.AvatarOperateHandler;
import com.dwarfeng.buddy.stack.service.AvatarQosService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

/**
 * 头像 QOS 服务实现。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Service
public class AvatarQosServiceImpl implements AvatarQosService {

    private final AvatarOperateHandler avatarOperateHandler;

    private final ServiceExceptionMapper sem;

    public AvatarQosServiceImpl(AvatarOperateHandler avatarOperateHandler, ServiceExceptionMapper sem) {
        this.avatarOperateHandler = avatarOperateHandler;
        this.sem = sem;
    }

    @Override
    public AvatarFile downloadFile(AvatarFileDownloadInfo info) throws ServiceException {
        try {
            return avatarOperateHandler.downloadFile(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("下载头像文件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void uploadFile(AvatarUploadInfo info) throws ServiceException {
        try {
            avatarOperateHandler.uploadFile(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("上传头像文件时发生异常", LogLevel.WARN, e, sem);
        }
    }

    @Override
    public void remove(AvatarRemoveInfo info) throws ServiceException {
        try {
            avatarOperateHandler.remove(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("移除头像时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
