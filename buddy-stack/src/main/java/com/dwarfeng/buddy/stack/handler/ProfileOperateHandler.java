package com.dwarfeng.buddy.stack.handler;

import com.dwarfeng.buddy.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import com.dwarfeng.subgrade.stack.handler.Handler;

/**
 * 个人简介操作处理器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface ProfileOperateHandler extends Handler {

    /**
     * 更新个人设置。
     *
     * @param info 个人简介的更新信息。
     * @throws HandlerException 处理器异常。
     */
    void update(ProfileUpdateInfo info) throws HandlerException;
}
