package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.buddy.stack.service.AvatarInfoMaintainService;
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
public class AvatarInfoMaintainServiceImplTest {

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private AvatarInfoMaintainService avatarInfoMaintainService;

    private User user;
    private AvatarInfo avatarInfo;

    @Before
    public void setUp() {
        StringIdKey userKey = new StringIdKey("test_user");
        user = new User(
                userKey, "remark", "reservedStringAlpha", "reservedStringBravo", "reservedStringCharlie",
                "reservedStringDelta", 12450L, 12450L, 12450, 12450, true, true, new Date(), new Date()
        );
        avatarInfo = new AvatarInfo(userKey, "originName", 12450L, new Date(), "remark");
    }

    @After
    public void tearDown() {
        user = null;
        avatarInfo = null;
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user);
            avatarInfoMaintainService.insertOrUpdate(avatarInfo);

            assertTrue(avatarInfoMaintainService.exists(avatarInfo.getKey()));
            AvatarInfo testAvatarInfo = avatarInfoMaintainService.get(avatarInfo.getKey());
            assertEquals(BeanUtils.describe(avatarInfo), BeanUtils.describe(testAvatarInfo));

            avatarInfoMaintainService.update(avatarInfo);
            testAvatarInfo = avatarInfoMaintainService.get(avatarInfo.getKey());
            assertEquals(BeanUtils.describe(avatarInfo), BeanUtils.describe(testAvatarInfo));

            avatarInfoMaintainService.deleteIfExists(avatarInfo.getKey());
            assertFalse(avatarInfoMaintainService.exists(avatarInfo.getKey()));
        } finally {
            if (Objects.nonNull(avatarInfo.getKey())) {
                avatarInfoMaintainService.deleteIfExists(avatarInfo.getKey());
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
            avatarInfoMaintainService.insertOrUpdate(avatarInfo);

            assertTrue(avatarInfoMaintainService.exists(avatarInfo.getKey()));

            userMaintainService.deleteIfExists(user.getKey());

            assertFalse(avatarInfoMaintainService.exists(avatarInfo.getKey()));
        } finally {
            if (Objects.nonNull(avatarInfo.getKey())) {
                avatarInfoMaintainService.deleteIfExists(avatarInfo.getKey());
            }
            if (Objects.nonNull(user.getKey())) {
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }
}
