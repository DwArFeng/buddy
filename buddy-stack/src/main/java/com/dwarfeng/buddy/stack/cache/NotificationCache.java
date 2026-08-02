package com.dwarfeng.buddy.stack.cache;

import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;

/**
 * 通知缓存。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface NotificationCache extends BatchBaseCache<LongIdKey, Notification> {

}
