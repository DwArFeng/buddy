package com.dwarfeng.buddy.stack.service;

import com.dwarfeng.buddy.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.service.Service;

/**
 * 个人简介操作服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface ProfileOperateService extends Service {

    /**
     * 更新个人设置。
     *
     * @param info 个人简介的更新信息。
     * @throws ServiceException 服务异常。
     */
    void update(ProfileUpdateInfo info) throws ServiceException;
}
