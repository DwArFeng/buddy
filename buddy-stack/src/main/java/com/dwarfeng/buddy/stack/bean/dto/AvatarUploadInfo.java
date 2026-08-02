package com.dwarfeng.buddy.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

import java.util.Arrays;

/**
 * 头像上传信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class AvatarUploadInfo implements Dto {

    private static final long serialVersionUID = 71482196912097838L;

    private StringIdKey userKey;
    private String originName;
    private byte[] content;

    public AvatarUploadInfo() {
    }

    public AvatarUploadInfo(StringIdKey userKey, String originName, byte[] content) {
        this.userKey = userKey;
        this.originName = originName;
        this.content = content;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
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
        return "AvatarUploadInfo{" +
                "userKey=" + userKey +
                ", originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
