package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.dto.ProfileUpdateInfo;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.buddy.stack.service.ProfileMaintainService;
import com.dwarfeng.buddy.stack.service.ProfileOperateService;
import com.dwarfeng.buddy.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class ProfileOperateServiceImplTest {

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private ProfileMaintainService profileMaintainService;
    @Autowired
    private ProfileOperateService profileOperateService;

    private User user;
    private Profile profile;

    @Before
    public void setUp() {
        StringIdKey userKey = new StringIdKey("test_user");
        user = new User(
                userKey, "remark", "reservedStringAlpha", "reservedStringBravo", "reservedStringCharlie",
                "reservedStringDelta", 12450L, 12450L, 12450, 12450, true, true, new Date(), new Date()
        );
        profile = new Profile(
                userKey, "name", "phoneNumber", "emailAddress", "remark", "reservedStringAlpha",
                "reservedStringBravo", "reservedStringCharlie", "reservedStringDelta", "reservedStringEcho",
                "reservedStringFoxtrot", "reservedStringGolf", "reservedStringHotel", 12450L, 12450L, 12450L,
                12450L, 12450, 12450, 12450, 12450, true, true, true, true, new Date(), new Date(), new Date(),
                new Date()
        );
    }

    @After
    public void tearDown() {
        user = null;
        profile = null;
    }

    @Test
    public void testUpdateProfilePreservesReservedFields() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user);
            profileMaintainService.insertOrUpdate(profile);

            ProfileUpdateInfo updateInfo = new ProfileUpdateInfo(
                    user.getKey(), "updated-name", "updated-phone", "updated-email", "updated-remark"
            );
            profileOperateService.update(updateInfo);

            Profile updated = profileMaintainService.get(user.getKey());
            assertEquals("updated-name", updated.getName());
            assertEquals("updated-phone", updated.getPhoneNumber());
            assertEquals("updated-email", updated.getEmailAddress());
            assertEquals("updated-remark", updated.getRemark());

            assertEquals("reservedStringAlpha", updated.getReservedStringAlpha());
            assertEquals("reservedStringBravo", updated.getReservedStringBravo());
            assertEquals("reservedStringCharlie", updated.getReservedStringCharlie());
            assertEquals("reservedStringDelta", updated.getReservedStringDelta());
            assertEquals("reservedStringEcho", updated.getReservedStringEcho());
            assertEquals("reservedStringFoxtrot", updated.getReservedStringFoxtrot());
            assertEquals("reservedStringGolf", updated.getReservedStringGolf());
            assertEquals("reservedStringHotel", updated.getReservedStringHotel());
            assertEquals(Long.valueOf(12450L), updated.getReservedLongAlpha());
            assertEquals(Long.valueOf(12450L), updated.getReservedLongBravo());
            assertEquals(Long.valueOf(12450L), updated.getReservedLongCharlie());
            assertEquals(Long.valueOf(12450L), updated.getReservedLongDelta());
            assertEquals(Integer.valueOf(12450), updated.getReservedIntegerAlpha());
            assertEquals(Integer.valueOf(12450), updated.getReservedIntegerBravo());
            assertEquals(Integer.valueOf(12450), updated.getReservedIntegerCharlie());
            assertEquals(Integer.valueOf(12450), updated.getReservedIntegerDelta());
            assertEquals(Boolean.TRUE, updated.getReservedBooleanAlpha());
            assertEquals(Boolean.TRUE, updated.getReservedBooleanBravo());
            assertEquals(Boolean.TRUE, updated.getReservedBooleanCharlie());
            assertEquals(Boolean.TRUE, updated.getReservedBooleanDelta());
            assertNotNull(updated.getReservedDateAlpha());
            assertNotNull(updated.getReservedDateBravo());
            assertNotNull(updated.getReservedDateCharlie());
            assertNotNull(updated.getReservedDateDelta());
        } finally {
            if (Objects.nonNull(user.getKey())) {
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testUpdateProfileForNewUser() throws Exception {
        StringIdKey newUserKey = new StringIdKey("tpos.new." + UUID.randomUUID());
        User newUser = new User(
                newUserKey, "remark",
                null, null, null, null, null, null, null, null, null, null, null, null
        );
        try {
            userMaintainService.insertOrUpdate(newUser);

            ProfileUpdateInfo updateInfo = new ProfileUpdateInfo(
                    newUserKey, "new-name", "new-phone", "new-email", "new-remark"
            );
            profileOperateService.update(updateInfo);

            Profile created = profileMaintainService.get(newUserKey);
            assertEquals("new-name", created.getName());
            assertEquals("new-phone", created.getPhoneNumber());
            assertEquals("new-email", created.getEmailAddress());
            assertEquals("new-remark", created.getRemark());
            assertNull(created.getReservedStringAlpha());
            assertNull(created.getReservedLongAlpha());
        } finally {
            userMaintainService.deleteIfExists(newUserKey);
        }
    }
}
