package com.dwarfeng.buddy.stack.service;

import com.dwarfeng.buddy.stack.bean.dto.AvatarFile;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFileDownloadInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarRemoveInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 头像 QOS 服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface AvatarQosService extends Service {

    /**
     * 下载头像文件。
     *
     * @param info 头像文件下载信息。
     * @return 头像文件。
     * @throws ServiceException 服务异常。
     */
    AvatarFile downloadFile(AvatarFileDownloadInfo info) throws ServiceException;

    /**
     * 上传头像文件。
     *
     * @param info 头像上传信息。
     * @throws ServiceException 服务异常。
     */
    void uploadFile(AvatarUploadInfo info) throws ServiceException;

    /**
     * 移除头像。
     *
     * @param info 头像移除信息。
     * @throws ServiceException 服务异常。
     */
    void remove(AvatarRemoveInfo info) throws ServiceException;
}
