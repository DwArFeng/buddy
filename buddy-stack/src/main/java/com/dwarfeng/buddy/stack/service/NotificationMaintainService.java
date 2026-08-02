package com.dwarfeng.buddy.stack.service;

import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 通知维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface NotificationMaintainService extends BatchCrudService<LongIdKey, Notification>,
        EntireLookupService<Notification>, PresetLookupService<Notification> {

    // region 预设查询 - 级联

    String CHILD_FOR_USER = "child_for_user";

    // endregion

    // region 预设查询 - 业务逻辑

    String CHILD_FOR_USER_UNREAD = "child_for_user_unread";
    String CHILD_FOR_USER_NOTIFIED_DATE_DESC = "child_for_user_notified_date_desc";
    String CHILD_FOR_USER_UNREAD_NOTIFIED_DATE_DESC = "child_for_user_unread_notified_date_desc";

    // endregion
}
