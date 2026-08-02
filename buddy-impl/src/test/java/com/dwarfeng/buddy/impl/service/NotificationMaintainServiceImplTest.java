package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.buddy.stack.service.NotificationMaintainService;
import com.dwarfeng.buddy.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class NotificationMaintainServiceImplTest {

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private NotificationMaintainService notificationMaintainService;

    private User user;
    private List<Notification> notifications;

    @Before
    public void setUp() {
        user = new User(
                new StringIdKey("test_user"), "remark",
                "reservedStringAlpha", "reservedStringBravo", "reservedStringCharlie", "reservedStringDelta",
                12450L, 12450L, 12450, 12450, true, true, new Date(), new Date()
        );
        notifications = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Notification notification = new Notification(
                    new LongIdKey(12450L + i), user.getKey(), "remark", new Date(), new Date(), true, "subject", "body"
            );
            notifications.add(notification);
        }
    }

    @After
    public void tearDown() {
        user = null;
        notifications.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user);
            for (Notification notification : notifications) {
                notificationMaintainService.insertOrUpdate(notification);

                Notification testNotification = notificationMaintainService.get(notification.getKey());
                assertEquals(BeanUtils.describe(notification), BeanUtils.describe(testNotification));
                notificationMaintainService.update(notification);
                testNotification = notificationMaintainService.get(notification.getKey());
                assertEquals(BeanUtils.describe(notification), BeanUtils.describe(testNotification));
            }
        } finally {
            for (Notification notification : notifications) {
                if (Objects.isNull(notification.getKey())) {
                    continue;
                }
                notificationMaintainService.deleteIfExists(notification.getKey());
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
            for (Notification notification : notifications) {
                notificationMaintainService.insertOrUpdate(notification);
            }

            List<Notification> testNotifications = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER, new Object[]{user.getKey()}
            ).getData();
            assertEquals(notifications.size(), testNotifications.size());
            userMaintainService.deleteIfExists(user.getKey());
            testNotifications = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER, new Object[]{user.getKey()}
            ).getData();
            assertTrue(testNotifications.isEmpty());
        } finally {
            for (Notification notification : notifications) {
                if (Objects.isNull(notification.getKey())) {
                    continue;
                }
                notificationMaintainService.deleteIfExists(notification.getKey());
            }
            if (Objects.nonNull(user.getKey())) {
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }
}
