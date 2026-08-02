package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFile;
import com.dwarfeng.subgrade.stack.bean.Bean;

import java.util.Arrays;
import java.util.Objects;

/**
 * JSFixed FastJson 头像文件。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class JSFixedFastJsonAvatarFile implements Bean {

    private static final long serialVersionUID = -3628470420831237385L;

    public static JSFixedFastJsonAvatarFile of(AvatarFile avatarFile) {
        if (Objects.isNull(avatarFile)) {
            return null;
        } else {
            return new JSFixedFastJsonAvatarFile(avatarFile.getOriginName(), avatarFile.getContent());
        }
    }

    public static AvatarFile toStackBean(JSFixedFastJsonAvatarFile fastJson) {
        if (Objects.isNull(fastJson)) {
            return null;
        } else {
            return new AvatarFile(fastJson.getOriginName(), fastJson.getContent());
        }
    }

    @JSONField(name = "origin_name", ordinal = 1)
    private String originName;

    @JSONField(name = "content", ordinal = 2)
    private byte[] content;

    public JSFixedFastJsonAvatarFile() {
    }

    public JSFixedFastJsonAvatarFile(String originName, byte[] content) {
        this.originName = originName;
        this.content = content;
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
        return "JSFixedFastJsonAvatarFile{" +
                "originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
