package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Objects;

/**
 * WebInput 头像上传信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputAvatarUploadInfo implements Dto {

    private static final long serialVersionUID = 1857111900766710965L;

    public static AvatarUploadInfo toStackBean(WebInputAvatarUploadInfo webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new AvatarUploadInfo(
                    WebInputStringIdKey.toStackBean(webInput.getUserKey()),
                    webInput.getOriginName(),
                    webInput.getContent()
            );
        }
    }

    @JSONField(name = "user_key")
    @Valid
    private WebInputStringIdKey userKey;

    @JSONField(name = "origin_name")
    private String originName;

    @JSONField(name = "content")
    private byte[] content;

    public WebInputAvatarUploadInfo() {
    }

    public WebInputAvatarUploadInfo(WebInputStringIdKey userKey, String originName, byte[] content) {
        this.userKey = userKey;
        this.originName = originName;
        this.content = content;
    }

    public WebInputStringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(WebInputStringIdKey userKey) {
        this.userKey = userKey;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WebInputAvatarUploadInfo{" +
                "userKey=" + userKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
