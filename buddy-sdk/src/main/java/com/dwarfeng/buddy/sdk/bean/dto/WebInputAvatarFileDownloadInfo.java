package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFileDownloadInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Objects;

/**
 * WebInput 头像文件下载信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputAvatarFileDownloadInfo implements Dto {

    private static final long serialVersionUID = -7385817908373559396L;

    public static AvatarFileDownloadInfo toStackBean(WebInputAvatarFileDownloadInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new AvatarFileDownloadInfo(WebInputStringIdKey.toStackBean(webInput.getUserKey()));
        }
    }

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    public WebInputAvatarFileDownloadInfo() {
    }

    public WebInputAvatarFileDownloadInfo(WebInputStringIdKey userKey) {
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
        return "WebInputAvatarFileDownloadInfo{" +
                "userKey=" + userKey +
                '}';
    }
}
