package com.dwarfeng.buddy.stack.handler;

import com.dwarfeng.buddy.stack.bean.dto.AvatarFile;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFileDownloadInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarRemoveInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 头像操作处理器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface AvatarOperateHandler extends Handler {

    /**
     * 下载头像文件。
     *
     * @param info 头像文件下载信息。
     * @return 头像文件。
     * @throws HandlerException 处理器异常。
     */
    AvatarFile downloadFile(AvatarFileDownloadInfo info) throws HandlerException;

    /**
     * 上传头像文件。
     *
     * @param info 头像上传信息。
     * @throws HandlerException 处理器异常。
     */
    void uploadFile(AvatarUploadInfo info) throws HandlerException;

    /**
     * 移除头像。
     *
     * @param info 头像移除信息。
     * @throws HandlerException 处理器异常。
     */
    void remove(AvatarRemoveInfo info) throws HandlerException;
}
