package com.dwarfeng.buddy.impl.dao.preset;

import com.dwarfeng.buddy.stack.bean.dto.UserCompositeLookupInfo;
import com.dwarfeng.buddy.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.sdk.hibernate.criteria.PresetCriteriaMaker;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Component
public class UserPresetCriteriaMaker implements PresetCriteriaMaker {

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public void makeCriteria(DetachedCriteria criteria, String preset, Object[] objs) {
        switch (preset) {
            case UserMaintainService.COMPOSITE_LOOKUP:
                compositeLookup(criteria, objs);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + preset);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void compositeLookup(DetachedCriteria criteria, Object[] objs) {
        try {
            UserCompositeLookupInfo info = (UserCompositeLookupInfo) objs[0];
            String stringIdPattern = info.getStringIdPattern();
            String remarkPattern = info.getRemarkPattern();
            String reservedStringAlphaPattern = info.getReservedStringAlphaPattern();
            String reservedStringBravoPattern = info.getReservedStringBravoPattern();
            String reservedStringCharliePattern = info.getReservedStringCharliePattern();
            String reservedStringDeltaPattern = info.getReservedStringDeltaPattern();
            Long reservedLongAlphaMin = info.getReservedLongAlphaMin();
            Long reservedLongAlphaMax = info.getReservedLongAlphaMax();
            Long reservedLongBravoMin = info.getReservedLongBravoMin();
            Long reservedLongBravoMax = info.getReservedLongBravoMax();
            Integer reservedIntegerAlphaMin = info.getReservedIntegerAlphaMin();
            Integer reservedIntegerAlphaMax = info.getReservedIntegerAlphaMax();
            Integer reservedIntegerBravoMin = info.getReservedIntegerBravoMin();
            Integer reservedIntegerBravoMax = info.getReservedIntegerBravoMax();
            Boolean reservedBooleanAlpha = info.getReservedBooleanAlpha();
            Boolean reservedBooleanBravo = info.getReservedBooleanBravo();
            Date reservedDateAlphaMin = info.getReservedDateAlphaMin();
            Date reservedDateAlphaMax = info.getReservedDateAlphaMax();
            Date reservedDateBravoMin = info.getReservedDateBravoMin();
            Date reservedDateBravoMax = info.getReservedDateBravoMax();
            if (StringUtils.isNotBlank(stringIdPattern)) {
                criteria.add(Restrictions.like("stringId", stringIdPattern, MatchMode.ANYWHERE));
            }
            if (StringUtils.isNotBlank(remarkPattern)) {
                criteria.add(Restrictions.like("remark", remarkPattern, MatchMode.ANYWHERE));
            }
            if (StringUtils.isNotBlank(reservedStringAlphaPattern)) {
                criteria.add(Restrictions.like(
                        "reservedStringAlpha", reservedStringAlphaPattern, MatchMode.ANYWHERE
                ));
            }
            if (StringUtils.isNotBlank(reservedStringBravoPattern)) {
                criteria.add(Restrictions.like(
                        "reservedStringBravo", reservedStringBravoPattern, MatchMode.ANYWHERE
                ));
            }
            if (StringUtils.isNotBlank(reservedStringCharliePattern)) {
                criteria.add(Restrictions.like(
                        "reservedStringCharlie", reservedStringCharliePattern, MatchMode.ANYWHERE
                ));
            }
            if (StringUtils.isNotBlank(reservedStringDeltaPattern)) {
                criteria.add(Restrictions.like(
                        "reservedStringDelta", reservedStringDeltaPattern, MatchMode.ANYWHERE
                ));
            }
            if (Objects.nonNull(reservedLongAlphaMin)) {
                criteria.add(Restrictions.ge("reservedLongAlpha", reservedLongAlphaMin));
            }
            if (Objects.nonNull(reservedLongAlphaMax)) {
                criteria.add(Restrictions.le("reservedLongAlpha", reservedLongAlphaMax));
            }
            if (Objects.nonNull(reservedLongBravoMin)) {
                criteria.add(Restrictions.ge("reservedLongBravo", reservedLongBravoMin));
            }
            if (Objects.nonNull(reservedLongBravoMax)) {
                criteria.add(Restrictions.le("reservedLongBravo", reservedLongBravoMax));
            }
            if (Objects.nonNull(reservedIntegerAlphaMin)) {
                criteria.add(Restrictions.ge("reservedIntegerAlpha", reservedIntegerAlphaMin));
            }
            if (Objects.nonNull(reservedIntegerAlphaMax)) {
                criteria.add(Restrictions.le("reservedIntegerAlpha", reservedIntegerAlphaMax));
            }
            if (Objects.nonNull(reservedIntegerBravoMin)) {
                criteria.add(Restrictions.ge("reservedIntegerBravo", reservedIntegerBravoMin));
            }
            if (Objects.nonNull(reservedIntegerBravoMax)) {
                criteria.add(Restrictions.le("reservedIntegerBravo", reservedIntegerBravoMax));
            }
            if (Objects.nonNull(reservedBooleanAlpha)) {
                criteria.add(Restrictions.eq("reservedBooleanAlpha", reservedBooleanAlpha));
            }
            if (Objects.nonNull(reservedBooleanBravo)) {
                criteria.add(Restrictions.eq("reservedBooleanBravo", reservedBooleanBravo));
            }
            if (Objects.nonNull(reservedDateAlphaMin)) {
                criteria.add(Restrictions.ge("reservedDateAlpha", reservedDateAlphaMin));
            }
            if (Objects.nonNull(reservedDateAlphaMax)) {
                criteria.add(Restrictions.le("reservedDateAlpha", reservedDateAlphaMax));
            }
            if (Objects.nonNull(reservedDateBravoMin)) {
                criteria.add(Restrictions.ge("reservedDateBravo", reservedDateBravoMin));
            }
            if (Objects.nonNull(reservedDateBravoMax)) {
                criteria.add(Restrictions.le("reservedDateBravo", reservedDateBravoMax));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }
}
