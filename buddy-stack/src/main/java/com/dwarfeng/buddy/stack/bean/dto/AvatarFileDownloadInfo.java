package com.dwarfeng.buddy.stack.bean.dto;

import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;

/**
 * 头像文件下载信息。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public class AvatarFileDownloadInfo implements Dto {

    private static final long serialVersionUID = 344176229237002664L;

    private StringIdKey userKey;

    public AvatarFileDownloadInfo() {
    }

    public AvatarFileDownloadInfo(StringIdKey userKey) {
        this.userKey = userKey;
    }

    public StringIdKey getUserKey() {
        return userKey;
    }

    public void setUserKey(StringIdKey userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "AvatarFileDownloadInfo{" +
                "userKey=" + userKey +
                '}';
    }
}
