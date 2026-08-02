package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.buddy.stack.service.ProfileMaintainService;
import com.dwarfeng.buddy.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class ProfileMaintainServiceImplTest {

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private ProfileMaintainService profileMaintainService;

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
    public void testForCrud() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user);
            profileMaintainService.insertOrUpdate(profile);

            assertTrue(profileMaintainService.exists(profile.getKey()));
            Profile testProfile = profileMaintainService.get(profile.getKey());
            assertEquals(BeanUtils.describe(profile), BeanUtils.describe(testProfile));

            profileMaintainService.update(profile);
            testProfile = profileMaintainService.get(profile.getKey());
            assertEquals(BeanUtils.describe(profile), BeanUtils.describe(testProfile));

            profileMaintainService.deleteIfExists(profile.getKey());
            assertFalse(profileMaintainService.exists(profile.getKey()));
        } finally {
            if (Objects.nonNull(profile.getKey())) {
                profileMaintainService.deleteIfExists(profile.getKey());
            }
            if (Objects.nonNull(user.getKey())) {
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testForUserCascade() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user);
            profileMaintainService.insertOrUpdate(profile);

            assertTrue(profileMaintainService.exists(profile.getKey()));

            userMaintainService.deleteIfExists(user.getKey());

            assertFalse(profileMaintainService.exists(profile.getKey()));
        } finally {
            if (Objects.nonNull(profile.getKey())) {
                profileMaintainService.deleteIfExists(profile.getKey());
            }
            if (Objects.nonNull(user.getKey())) {
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }
}
