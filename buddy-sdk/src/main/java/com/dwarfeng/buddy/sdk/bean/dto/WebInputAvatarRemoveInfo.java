package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.AvatarRemoveInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 头像移除信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputAvatarRemoveInfo implements Dto {

    private static final long serialVersionUID = -319316427428124253L;

    public static AvatarRemoveInfo toStackBean(WebInputAvatarRemoveInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new AvatarRemoveInfo(WebInputStringIdKey.toStackBean(webInput.getUserKey()));
        }
    }

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    public WebInputAvatarRemoveInfo() {
    }

    public WebInputAvatarRemoveInfo(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "WebInputAvatarRemoveInfo{" +
                "userKey=" + userKey +
                '}';
    }
}
