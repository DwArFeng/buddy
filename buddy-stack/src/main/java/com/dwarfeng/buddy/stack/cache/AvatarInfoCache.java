package com.dwarfeng.buddy.stack.cache;

import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 头像信息缓存。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface AvatarInfoCache extends BatchBaseCache<StringIdKey, AvatarInfo> {

}
