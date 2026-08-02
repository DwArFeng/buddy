package com.dwarfeng.buddy.stack.service;

import com.dwarfeng.buddy.stack.bean.dto.ProfileCompositeLookupInfo;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 个人简介维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface ProfileMaintainService extends BatchCrudService<StringIdKey, Profile>, EntireLookupService<Profile>,
        PresetLookupService<Profile> {

    // region 预设查询 - 业务逻辑

    /**
     * 组合查询预设。
     *
     * <p>
     * 该预设所需参数见下表：
     * <table>
     *     <tr>
     *         <th>参数索引</th>
     *         <th>参数类型</th>
     *         <th>参数说明</th>
     *     </tr>
     *     <tr>
     *         <td>0</td>
     *         <td>{@link ProfileCompositeLookupInfo}</td>
     *         <td>组合查询信息对象</td>
     *     </tr>
     * </table>
     */
    String COMPOSITE_LOOKUP = "composite_lookup";

    // endregion
}
