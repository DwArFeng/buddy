package com.dwarfeng.buddy.stack.dao;

import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 头像信息数据访问层。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface AvatarInfoDao extends BatchBaseDao<StringIdKey, AvatarInfo>, EntireLookupDao<AvatarInfo>,
        PresetLookupDao<AvatarInfo> {

}
