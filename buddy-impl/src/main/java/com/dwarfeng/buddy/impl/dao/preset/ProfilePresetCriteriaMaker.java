package com.dwarfeng.buddy.impl.dao.preset;

import com.dwarfeng.buddy.stack.bean.dto.ProfileCompositeLookupInfo;
import com.dwarfeng.buddy.stack.service.ProfileMaintainService;
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
public class ProfilePresetCriteriaMaker implements PresetCriteriaMaker {

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public void makeCriteria(DetachedCriteria criteria, String preset, Object[] objs) {
        switch (preset) {
            case ProfileMaintainService.COMPOSITE_LOOKUP:
                compositeLookup(criteria, objs);
                break;
            default:
                throw new IllegalArgumentException("无法识别的预设: " + preset);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private void compositeLookup(DetachedCriteria criteria, Object[] objs) {
        try {
            ProfileCompositeLookupInfo info = (ProfileCompositeLookupInfo) objs[0];
            String stringIdPattern = info.getStringIdPattern();
            String namePattern = info.getNamePattern();
            String phoneNumberPattern = info.getPhoneNumberPattern();
            String emailAddressPattern = info.getEmailAddressPattern();
            String remarkPattern = info.getRemarkPattern();
            String reservedStringAlphaPattern = info.getReservedStringAlphaPattern();
            String reservedStringBravoPattern = info.getReservedStringBravoPattern();
            String reservedStringCharliePattern = info.getReservedStringCharliePattern();
            String reservedStringDeltaPattern = info.getReservedStringDeltaPattern();
            String reservedStringEchoPattern = info.getReservedStringEchoPattern();
            String reservedStringFoxtrotPattern = info.getReservedStringFoxtrotPattern();
            String reservedStringGolfPattern = info.getReservedStringGolfPattern();
            String reservedStringHotelPattern = info.getReservedStringHotelPattern();
            Long reservedLongAlphaMin = info.getReservedLongAlphaMin();
            Long reservedLongAlphaMax = info.getReservedLongAlphaMax();
            Long reservedLongBravoMin = info.getReservedLongBravoMin();
            Long reservedLongBravoMax = info.getReservedLongBravoMax();
            Long reservedLongCharlieMin = info.getReservedLongCharlieMin();
            Long reservedLongCharlieMax = info.getReservedLongCharlieMax();
            Long reservedLongDeltaMin = info.getReservedLongDeltaMin();
            Long reservedLongDeltaMax = info.getReservedLongDeltaMax();
            Integer reservedIntegerAlphaMin = info.getReservedIntegerAlphaMin();
            Integer reservedIntegerAlphaMax = info.getReservedIntegerAlphaMax();
            Integer reservedIntegerBravoMin = info.getReservedIntegerBravoMin();
            Integer reservedIntegerBravoMax = info.getReservedIntegerBravoMax();
            Integer reservedIntegerCharlieMin = info.getReservedIntegerCharlieMin();
            Integer reservedIntegerCharlieMax = info.getReservedIntegerCharlieMax();
            Integer reservedIntegerDeltaMin = info.getReservedIntegerDeltaMin();
            Integer reservedIntegerDeltaMax = info.getReservedIntegerDeltaMax();
            Boolean reservedBooleanAlpha = info.getReservedBooleanAlpha();
            Boolean reservedBooleanBravo = info.getReservedBooleanBravo();
            Boolean reservedBooleanCharlie = info.getReservedBooleanCharlie();
            Boolean reservedBooleanDelta = info.getReservedBooleanDelta();
            Date reservedDateAlphaMin = info.getReservedDateAlphaMin();
            Date reservedDateAlphaMax = info.getReservedDateAlphaMax();
            Date reservedDateBravoMin = info.getReservedDateBravoMin();
            Date reservedDateBravoMax = info.getReservedDateBravoMax();
            Date reservedDateCharlieMin = info.getReservedDateCharlieMin();
            Date reservedDateCharlieMax = info.getReservedDateCharlieMax();
            Date reservedDateDeltaMin = info.getReservedDateDeltaMin();
            Date reservedDateDeltaMax = info.getReservedDateDeltaMax();
            if (StringUtils.isNotBlank(stringIdPattern)) {
                criteria.add(Restrictions.like("stringId", stringIdPattern, MatchMode.ANYWHERE));
            }
            if (StringUtils.isNotBlank(namePattern)) {
                criteria.add(Restrictions.like("name", namePattern, MatchMode.ANYWHERE));
            }
            if (StringUtils.isNotBlank(phoneNumberPattern)) {
                criteria.add(Restrictions.like("phoneNumber", phoneNumberPattern, MatchMode.ANYWHERE));
            }
            if (StringUtils.isNotBlank(emailAddressPattern)) {
                criteria.add(Restrictions.like("emailAddress", emailAddressPattern, MatchMode.ANYWHERE));
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
            if (StringUtils.isNotBlank(reservedStringEchoPattern)) {
                criteria.add(Restrictions.like(
                        "reservedStringEcho", reservedStringEchoPattern, MatchMode.ANYWHERE
                ));
            }
            if (StringUtils.isNotBlank(reservedStringFoxtrotPattern)) {
                criteria.add(Restrictions.like(
                        "reservedStringFoxtrot", reservedStringFoxtrotPattern, MatchMode.ANYWHERE
                ));
            }
            if (StringUtils.isNotBlank(reservedStringGolfPattern)) {
                criteria.add(Restrictions.like(
                        "reservedStringGolf", reservedStringGolfPattern, MatchMode.ANYWHERE
                ));
            }
            if (StringUtils.isNotBlank(reservedStringHotelPattern)) {
                criteria.add(Restrictions.like(
                        "reservedStringHotel", reservedStringHotelPattern, MatchMode.ANYWHERE
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
            if (Objects.nonNull(reservedLongCharlieMin)) {
                criteria.add(Restrictions.ge("reservedLongCharlie", reservedLongCharlieMin));
            }
            if (Objects.nonNull(reservedLongCharlieMax)) {
                criteria.add(Restrictions.le("reservedLongCharlie", reservedLongCharlieMax));
            }
            if (Objects.nonNull(reservedLongDeltaMin)) {
                criteria.add(Restrictions.ge("reservedLongDelta", reservedLongDeltaMin));
            }
            if (Objects.nonNull(reservedLongDeltaMax)) {
                criteria.add(Restrictions.le("reservedLongDelta", reservedLongDeltaMax));
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
            if (Objects.nonNull(reservedIntegerCharlieMin)) {
                criteria.add(Restrictions.ge("reservedIntegerCharlie", reservedIntegerCharlieMin));
            }
            if (Objects.nonNull(reservedIntegerCharlieMax)) {
                criteria.add(Restrictions.le("reservedIntegerCharlie", reservedIntegerCharlieMax));
            }
            if (Objects.nonNull(reservedIntegerDeltaMin)) {
                criteria.add(Restrictions.ge("reservedIntegerDelta", reservedIntegerDeltaMin));
            }
            if (Objects.nonNull(reservedIntegerDeltaMax)) {
                criteria.add(Restrictions.le("reservedIntegerDelta", reservedIntegerDeltaMax));
            }
            if (Objects.nonNull(reservedBooleanAlpha)) {
                criteria.add(Restrictions.eq("reservedBooleanAlpha", reservedBooleanAlpha));
            }
            if (Objects.nonNull(reservedBooleanBravo)) {
                criteria.add(Restrictions.eq("reservedBooleanBravo", reservedBooleanBravo));
            }
            if (Objects.nonNull(reservedBooleanCharlie)) {
                criteria.add(Restrictions.eq("reservedBooleanCharlie", reservedBooleanCharlie));
            }
            if (Objects.nonNull(reservedBooleanDelta)) {
                criteria.add(Restrictions.eq("reservedBooleanDelta", reservedBooleanDelta));
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
            if (Objects.nonNull(reservedDateCharlieMin)) {
                criteria.add(Restrictions.ge("reservedDateCharlie", reservedDateCharlieMin));
            }
            if (Objects.nonNull(reservedDateCharlieMax)) {
                criteria.add(Restrictions.le("reservedDateCharlie", reservedDateCharlieMax));
            }
            if (Objects.nonNull(reservedDateDeltaMin)) {
                criteria.add(Restrictions.ge("reservedDateDelta", reservedDateDeltaMin));
            }
            if (Objects.nonNull(reservedDateDeltaMax)) {
                criteria.add(Restrictions.le("reservedDateDelta", reservedDateDeltaMax));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("非法的参数:" + Arrays.toString(objs));
        }
    }
}
