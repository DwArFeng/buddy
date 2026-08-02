package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.buddy.stack.handler.ProfileOperateHandler;
import com.dwarfeng.buddy.stack.service.ProfileOperateService;
import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionHelper;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.dwarfeng.subgrade.stack.exception.ServiceExceptionMapper;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import org.springframework.stereotype.Service;

/**
 * 个人简介操作服务实现。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Service
public class ProfileOperateServiceImpl implements ProfileOperateService {

    private final ProfileOperateHandler profileOperateHandler;

    private final ServiceExceptionMapper sem;

    public ProfileOperateServiceImpl(ProfileOperateHandler profileOperateHandler, ServiceExceptionMapper sem) {
        this.profileOperateHandler = profileOperateHandler;
        this.sem = sem;
    }

    @Override
    public void update(ProfileUpdateInfo info) throws ServiceException {
        try {
            profileOperateHandler.update(info);
        } catch (Exception e) {
            throw ServiceExceptionHelper.logParse("更新个人设置时发生异常", LogLevel.WARN, e, sem);
        }
    }
}
