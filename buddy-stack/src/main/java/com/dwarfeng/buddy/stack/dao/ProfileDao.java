package com.dwarfeng.buddy.stack.dao;

import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.dwarfeng.subgrade.stack.dao.PresetLookupDao;

/**
 * 个人简介数据访问层。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface ProfileDao extends BatchBaseDao<StringIdKey, Profile>, EntireLookupDao<Profile>,
        PresetLookupDao<Profile> {

}
