package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.dto.UserCompositeLookupInfo;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.buddy.stack.service.UserMaintainService;
import com.dwarfeng.subgrade.stack.bean.dto.PagedData;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class UserCompositeLookupTest {

    @Autowired
    private UserMaintainService userMaintainService;

    private List<User> users;

    @Before
    public void setUp() {
        users = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        for (int i = 0; i < 40; i++) {
            calendar.set(2024, Calendar.JANUARY, 1 + i, 0, 0, 0);
            Date date1 = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 1 + i + 10, 0, 0, 0);
            Date date2 = calendar.getTime();
            String remark = String.format("remark_%03d", i);
            String reservedStringAlpha = String.format("alpha_%03d", i);
            String reservedStringBravo = String.format("bravo_%03d", i);
            String reservedStringCharlie = String.format("charlie_%03d", i);
            String reservedStringDelta = String.format("delta_%03d", i);
            Boolean reservedBooleanAlpha = (i % 2 == 0) ? Boolean.TRUE : Boolean.FALSE;
            Boolean reservedBooleanBravo = (i % 3 == 0) ? Boolean.TRUE : Boolean.FALSE;
            User user = new User(
                    new StringIdKey("test_user." + i),
                    remark,
                    reservedStringAlpha, reservedStringBravo, reservedStringCharlie, reservedStringDelta,
                    (long) (i * 10), (long) (i * 15),
                    i * 5, i * 8,
                    reservedBooleanAlpha, reservedBooleanBravo,
                    date1, date2
            );
            users.add(user);
        }
    }

    @After
    public void tearDown() {
        users.clear();
    }

    @Test
    public void testEmptyLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();

            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(40, filteredResults.size());
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testStringIdPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setStringIdPattern("test_user.5");
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getKey().getStringId().contains("test_user.5"));
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testRemarkPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setRemarkPattern("remark_002");
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getRemark().contains("remark_002"));
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedStringAlphaPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedStringAlphaPattern("alpha_003");
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringAlpha().contains("alpha_003"));
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedStringBravoPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedStringBravoPattern("bravo_004");
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringBravo().contains("bravo_004"));
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedStringCharliePatternLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedStringCharliePattern("charlie_005");
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringCharlie().contains("charlie_005"));
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedStringDeltaPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedStringDeltaPattern("delta_006");
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringDelta().contains("delta_006"));
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedLongAlphaRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedLongAlphaMin(50L);
            lookupInfo.setReservedLongAlphaMax(150L);
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (User user : filteredResults) {
                assertTrue(user.getReservedLongAlpha() >= 50L);
                assertTrue(user.getReservedLongAlpha() <= 150L);
            }
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedLongBravoRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedLongBravoMin(75L);
            lookupInfo.setReservedLongBravoMax(225L);
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (User user : filteredResults) {
                assertTrue(user.getReservedLongBravo() >= 75L);
                assertTrue(user.getReservedLongBravo() <= 225L);
            }
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedIntegerAlphaRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedIntegerAlphaMin(25);
            lookupInfo.setReservedIntegerAlphaMax(75);
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (User user : filteredResults) {
                assertTrue(user.getReservedIntegerAlpha() >= 25);
                assertTrue(user.getReservedIntegerAlpha() <= 75);
            }
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedIntegerBravoRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedIntegerBravoMin(40);
            lookupInfo.setReservedIntegerBravoMax(120);
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (User user : filteredResults) {
                assertTrue(user.getReservedIntegerBravo() >= 40);
                assertTrue(user.getReservedIntegerBravo() <= 120);
            }
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedBooleanAlphaLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedBooleanAlpha(true);
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(20, filteredResults.size());
            for (User user : filteredResults) {
                assertTrue(user.getReservedBooleanAlpha());
            }
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedBooleanBravoLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedBooleanBravo(true);
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(14, filteredResults.size());
            for (User user : filteredResults) {
                assertTrue(user.getReservedBooleanBravo());
            }
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedDateAlphaRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.JANUARY, 5, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date minDate = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 15, 0, 0, 0);
            Date maxDate = calendar.getTime();
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedDateAlphaMin(minDate);
            lookupInfo.setReservedDateAlphaMax(maxDate);
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (User user : filteredResults) {
                assertTrue(user.getReservedDateAlpha().compareTo(minDate) >= 0);
                assertTrue(user.getReservedDateAlpha().compareTo(maxDate) <= 0);
            }
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @Test
    public void testReservedDateBravoRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.JANUARY, 10, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date minDate = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 20, 0, 0, 0);
            Date maxDate = calendar.getTime();
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setReservedDateBravoMin(minDate);
            lookupInfo.setReservedDateBravoMax(maxDate);
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(10, filteredResults.size());
            for (User user : filteredResults) {
                assertTrue(user.getReservedDateBravo().compareTo(minDate) >= 0);
                assertTrue(user.getReservedDateBravo().compareTo(maxDate) <= 0);
            }
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }

    @SuppressWarnings("ExtractMethodRecommender")
    @Test
    public void testCompositeLookupAllFields() throws Exception {
        try {
            Set<StringIdKey> testUserKeys = new HashSet<>();
            for (User user : users) {
                user.setKey(userMaintainService.insert(user));
                testUserKeys.add(user.getKey());
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.JANUARY, 5, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date dateMin = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 25, 0, 0, 0);
            Date dateMax = calendar.getTime();
            UserCompositeLookupInfo lookupInfo = new UserCompositeLookupInfo();
            lookupInfo.setStringIdPattern("test_user.10");
            lookupInfo.setRemarkPattern("remark_010");
            lookupInfo.setReservedStringAlphaPattern("alpha_010");
            lookupInfo.setReservedStringBravoPattern("bravo_010");
            lookupInfo.setReservedStringCharliePattern("charlie_010");
            lookupInfo.setReservedStringDeltaPattern("delta_010");
            lookupInfo.setReservedBooleanAlpha(true);
            lookupInfo.setReservedBooleanBravo(false);
            lookupInfo.setReservedLongAlphaMin(90L);
            lookupInfo.setReservedLongAlphaMax(110L);
            lookupInfo.setReservedLongBravoMin(135L);
            lookupInfo.setReservedLongBravoMax(165L);
            lookupInfo.setReservedIntegerAlphaMin(45);
            lookupInfo.setReservedIntegerAlphaMax(55);
            lookupInfo.setReservedIntegerBravoMin(72);
            lookupInfo.setReservedIntegerBravoMax(88);
            lookupInfo.setReservedDateAlphaMin(dateMin);
            lookupInfo.setReservedDateAlphaMax(dateMax);
            lookupInfo.setReservedDateBravoMin(dateMin);
            lookupInfo.setReservedDateBravoMax(dateMax);
            PagedData<User> result = userMaintainService.lookup(
                    UserMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<User> filteredResults = new ArrayList<>();
            for (User item : result.getData()) {
                if (item.getKey() != null && testUserKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            User matchedUser = filteredResults.get(0);
            assertTrue(matchedUser.getKey().getStringId().contains("test_user.10"));
            assertTrue(matchedUser.getRemark().contains("remark_010"));
            assertTrue(matchedUser.getReservedBooleanAlpha());
            assertFalse(matchedUser.getReservedBooleanBravo());
        } finally {
            for (User user : users) {
                if (Objects.isNull(user.getKey())) {
                    continue;
                }
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }
}
