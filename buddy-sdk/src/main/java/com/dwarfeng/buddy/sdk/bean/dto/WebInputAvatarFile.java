package com.dwarfeng.buddy.sdk.bean.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFile;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;

import java.util.Arrays;
import java.util.Objects;

/**
 * WebInput 头像文件。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class WebInputAvatarFile implements Dto {

    private static final long serialVersionUID = -1950542117000667440L;

    public static AvatarFile toStackBean(WebInputAvatarFile webInput) {
        if (Objects.isNull(webInput)) {
            return null;
        } else {
            return new AvatarFile(webInput.getOriginName(), webInput.getContent());
        }
    }

    @JSONField(name = "origin_name")
    private String originName;

    @JSONField(name = "content")
    private byte[] content;

    public WebInputAvatarFile() {
    }

    public WebInputAvatarFile(String originName, byte[] content) {
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
        return "WebInputAvatarFile{" +
                "originName='" + originName + '\'' +
                ", content=" + Arrays.toString(content) +
                '}';
    }
}
