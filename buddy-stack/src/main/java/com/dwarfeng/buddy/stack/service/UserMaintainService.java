package com.dwarfeng.buddy.stack.service;

import com.dwarfeng.buddy.stack.bean.dto.UserCompositeLookupInfo;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.dwarfeng.subgrade.stack.service.PresetLookupService;

/**
 * 用户维护服务。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
public interface UserMaintainService extends BatchCrudService<StringIdKey, User>, EntireLookupService<User>,
        PresetLookupService<User> {

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
     *         <td>{@link UserCompositeLookupInfo}</td>
     *         <td>组合查询信息对象</td>
     *     </tr>
     * </table>
     */
    String COMPOSITE_LOOKUP = "composite_lookup";

    // endregion
}
