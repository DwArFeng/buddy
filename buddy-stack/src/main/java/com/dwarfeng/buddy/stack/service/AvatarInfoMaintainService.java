package com.dwarfeng.buddy.stack.service;

import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 头像信息维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface AvatarInfoMaintainService extends BatchCrudService<StringIdKey, AvatarInfo>,
        EntireLookupService<AvatarInfo>, PresetLookupService<AvatarInfo> {

}
