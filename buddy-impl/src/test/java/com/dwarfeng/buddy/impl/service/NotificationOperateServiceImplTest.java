package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.dto.NotificationClearForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadAllForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadInfo;
import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.buddy.stack.service.NotificationMaintainService;
import com.dwarfeng.buddy.stack.service.NotificationOperateService;
import com.dwarfeng.buddy.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class NotificationOperateServiceImplTest {

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private NotificationMaintainService notificationMaintainService;
    @Autowired
    private NotificationOperateService notificationOperateService;

    private User user;

    @Before
    public void setUp() {
        user = new User(
                new StringIdKey("test_user"), "remark",
                null, null, null, null, null, null, null, null, null, null, null, null
        );
    }

    @After
    public void tearDown() {
        user = null;
    }

    @Test
    public void test() throws Exception {
        try {
            userMaintainService.insertOrUpdate(user);

            NotificationCreateInfo createInfo = new NotificationCreateInfo(
                    user.getKey(), "subject-1", "body-1", "remark-1"
            );
            LongIdKey notificationKey = notificationOperateService.create(createInfo);
            assertNotNull(notificationKey);

            Notification notification = notificationMaintainService.get(notificationKey);
            assertEquals("subject-1", notification.getSubject());
            assertEquals("body-1", notification.getBody());
            assertFalse(notification.isReadFlag());

            notificationOperateService.read(new NotificationReadInfo(notificationKey));
            notification = notificationMaintainService.get(notificationKey);
            assertTrue(notification.isReadFlag());
            assertNotNull(notification.getReadDate());

            notificationOperateService.create(
                    new NotificationCreateInfo(user.getKey(), "subject-2", "body-2", "remark-2")
            );
            notificationOperateService.create(
                    new NotificationCreateInfo(user.getKey(), "subject-3", "body-3", "remark-3")
            );

            notificationOperateService.readAllForUser(new NotificationReadAllForUserInfo(user.getKey()));
            List<Notification> unreadNotifications = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER_UNREAD, new Object[]{user.getKey()}
            ).getData();
            assertTrue(unreadNotifications.isEmpty());

            notificationOperateService.clearForUser(new NotificationClearForUserInfo(user.getKey()));
            List<Notification> notifications = notificationMaintainService.lookup(
                    NotificationMaintainService.CHILD_FOR_USER, new Object[]{user.getKey()}
            ).getData();
            assertTrue(notifications.isEmpty());
        } finally {
            if (Objects.nonNull(user.getKey())) {
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }
}
