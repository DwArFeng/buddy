package com.dwarfeng.buddy.sdk.bean;

import com.dwarfeng.buddy.sdk.bean.dto.WebInputProfileCompositeLookupInfo;
import com.dwarfeng.buddy.sdk.bean.dto.WebInputUserCompositeLookupInfo;
import com.dwarfeng.buddy.sdk.bean.entity.*;
import com.dwarfeng.buddy.stack.bean.dto.ProfileCompositeLookupInfo;
import com.dwarfeng.buddy.stack.bean.dto.UserCompositeLookupInfo;
import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * Bean 映射器。
 *
 * <p>
 * 该映射器中包含了 <code>sdk</code> 模块中所有实体与 <code>stack</code> 模块中对应实体的映射方法。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Mapper
public interface BeanMapper {

    // region Subgrade Key

    FastJsonStringIdKey stringIdKeyToFastJson(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromFastJson(FastJsonStringIdKey fastJsonStringIdKey);

    FastJsonLongIdKey longIdKeyToFastJson(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromFastJson(FastJsonLongIdKey fastJsonLongIdKey);

    // endregion

    // region Buddy Entity

    FastJsonAvatarInfo avatarInfoToFastJson(AvatarInfo avatarInfo);

    @InheritInverseConfiguration
    AvatarInfo avatarInfoFromFastJson(FastJsonAvatarInfo fastJsonAvatarInfo);

    JSFixedFastJsonAvatarInfo avatarInfoToJSFixedFastJson(AvatarInfo avatarInfo);

    @InheritInverseConfiguration
    AvatarInfo avatarInfoFromJSFixedFastJson(JSFixedFastJsonAvatarInfo jSFixedFastJsonAvatarInfo);

    FastJsonNotification notificationToFastJson(Notification notification);

    @InheritInverseConfiguration
    Notification notificationFromFastJson(FastJsonNotification fastJsonNotification);

    JSFixedFastJsonNotification notificationToJSFixedFastJson(Notification notification);

    @InheritInverseConfiguration
    Notification notificationFromJSFixedFastJson(JSFixedFastJsonNotification jSFixedFastJsonNotification);

    WebInputNotification notificationToWebInput(Notification notification);

    @InheritInverseConfiguration
    Notification notificationFromWebInput(WebInputNotification webInputNotification);

    FastJsonProfile profileToFastJson(Profile profile);

    @InheritInverseConfiguration
    Profile profileFromFastJson(FastJsonProfile fastJsonProfile);

    JSFixedFastJsonProfile profileToJSFixedFastJson(Profile profile);

    @InheritInverseConfiguration
    Profile profileFromJSFixedFastJson(JSFixedFastJsonProfile jSFixedFastJsonProfile);

    WebInputProfile profileToWebInput(Profile profile);

    @InheritInverseConfiguration
    Profile profileFromWebInput(WebInputProfile webInputProfile);

    FastJsonUser userToFastJson(User user);

    @InheritInverseConfiguration
    User userFromFastJson(FastJsonUser fastJsonUser);

    JSFixedFastJsonUser userToJSFixedFastJson(User user);

    @InheritInverseConfiguration
    User userFromJSFixedFastJson(JSFixedFastJsonUser jSFixedFastJsonUser);

    WebInputUser userToWebInput(User user);

    @InheritInverseConfiguration
    User userFromWebInput(WebInputUser webInputUser);

    // endregion

    // region Buddy DTO

    WebInputProfileCompositeLookupInfo profileCompositeLookupInfoToWebInput(
            ProfileCompositeLookupInfo profileCompositeLookupInfo
    );

    @InheritInverseConfiguration
    ProfileCompositeLookupInfo profileCompositeLookupInfoFromWebInput(
            WebInputProfileCompositeLookupInfo webInputProfileCompositeLookupInfo
    );

    WebInputUserCompositeLookupInfo userCompositeLookupInfoToWebInput(UserCompositeLookupInfo userCompositeLookupInfo);

    @InheritInverseConfiguration
    UserCompositeLookupInfo userCompositeLookupInfoFromWebInput(
            WebInputUserCompositeLookupInfo webInputUserCompositeLookupInfo
    );

    // endregion
}
