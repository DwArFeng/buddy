package com.dwarfeng.buddy.impl.handler;

import com.dwarfeng.buddy.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.buddy.stack.handler.ProfileOperateHandler;
import com.dwarfeng.buddy.stack.service.ProfileMaintainService;
import com.dwarfeng.subgrade.sdk.exception.HandlerExceptionHelper;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;
import org.springframework.stereotype.Component;

/**
 * 个人简介操作处理器实现。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Component
public class ProfileOperateHandlerImpl implements ProfileOperateHandler {

    private final ProfileMaintainService profileMaintainService;

    private final HandlerValidator HandlerValidator;

    public ProfileOperateHandlerImpl(
            ProfileMaintainService profileMaintainService,
            HandlerValidator HandlerValidator
    ) {
        this.profileMaintainService = profileMaintainService;
        this.HandlerValidator = HandlerValidator;
    }

    @Override
    public void update(ProfileUpdateInfo info) throws HandlerException {
        try {
            StringIdKey userKey = info.getUserKey();
            HandlerValidator.makeSureUserExists(userKey);

            Profile profile;
            if (profileMaintainService.exists(userKey)) {
                profile = profileMaintainService.get(userKey);
            } else {
                profile = new Profile();
                profile.setKey(userKey);
            }

            profile.setName(info.getName());
            profile.setPhoneNumber(info.getPhoneNumber());
            profile.setEmailAddress(info.getEmailAddress());
            profile.setRemark(info.getRemark());

            profileMaintainService.insertOrUpdate(profile);
        } catch (Exception e) {
            throw HandlerExceptionHelper.parse(e);
        }
    }
}
