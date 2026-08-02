package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.stack.bean.dto.ProfileCompositeLookupInfo;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.buddy.stack.service.ProfileMaintainService;
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
public class ProfileCompositeLookupTest {

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private ProfileMaintainService profileMaintainService;

    private List<User> users;
    private List<Profile> profiles;

    @Before
    public void setUp() {
        users = new ArrayList<>();
        profiles = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        for (int i = 0; i < 40; i++) {
            calendar.set(2024, Calendar.JANUARY, 1 + i, 0, 0, 0);
            Date dateAlpha = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 1 + i + 5, 0, 0, 0);
            Date dateBravo = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 1 + i + 10, 0, 0, 0);
            Date dateCharlie = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 1 + i + 15, 0, 0, 0);
            Date dateDelta = calendar.getTime();
            StringIdKey key = new StringIdKey("test_user." + i);
            String name = String.format("profile_name_%03d", i);
            String phoneNumber = String.format("phone_%03d", i);
            String emailAddress = String.format("email_%03d", i);
            String remark = String.format("remark_%03d", i);
            User user = new User(
                    key, remark,
                    String.format("alpha_%03d", i), String.format("bravo_%03d", i),
                    String.format("charlie_%03d", i), String.format("delta_%03d", i),
                    (long) (i * 10), (long) (i * 15), i * 5, i * 8,
                    (i % 2 == 0), (i % 3 == 0), dateAlpha, dateBravo
            );
            users.add(user);
            Profile profile = new Profile(
                    key, name, phoneNumber, emailAddress, remark,
                    String.format("alpha_%03d", i), String.format("bravo_%03d", i),
                    String.format("charlie_%03d", i), String.format("delta_%03d", i),
                    String.format("echo_%03d", i), String.format("foxtrot_%03d", i),
                    String.format("golf_%03d", i), String.format("hotel_%03d", i),
                    (long) (i * 10), (long) (i * 15), (long) (i * 20), (long) (i * 25),
                    i * 5, i * 8, i * 12, i * 16,
                    (i % 2 == 0), (i % 3 == 0), (i % 4 == 0), (i % 5 == 0),
                    dateAlpha, dateBravo, dateCharlie, dateDelta
            );
            profiles.add(profile);
        }
    }

    @After
    public void tearDown() {
        users.clear();
        profiles.clear();
    }

    @Test
    public void testEmptyLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();

            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(40, filteredResults.size());
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testStringIdPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setStringIdPattern("test_user.5");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getKey().getStringId().contains("test_user.5"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testNamePatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setNamePattern("profile_name_002");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getName().contains("profile_name_002"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testPhoneNumberPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setPhoneNumberPattern("phone_003");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getPhoneNumber().contains("phone_003"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testEmailAddressPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setEmailAddressPattern("email_004");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getEmailAddress().contains("email_004"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testRemarkPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setRemarkPattern("remark_005");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getRemark().contains("remark_005"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedStringAlphaPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedStringAlphaPattern("alpha_006");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringAlpha().contains("alpha_006"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedStringBravoPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedStringBravoPattern("bravo_007");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringBravo().contains("bravo_007"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedStringCharliePatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedStringCharliePattern("charlie_008");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringCharlie().contains("charlie_008"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedStringDeltaPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedStringDeltaPattern("delta_009");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringDelta().contains("delta_009"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedStringEchoPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedStringEchoPattern("echo_010");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringEcho().contains("echo_010"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedStringFoxtrotPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedStringFoxtrotPattern("foxtrot_011");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringFoxtrot().contains("foxtrot_011"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedStringGolfPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedStringGolfPattern("golf_012");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringGolf().contains("golf_012"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedStringHotelPatternLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedStringHotelPattern("hotel_013");
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            assertTrue(filteredResults.get(0).getReservedStringHotel().contains("hotel_013"));
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedLongAlphaRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedLongAlphaMin(50L);
            lookupInfo.setReservedLongAlphaMax(150L);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedLongAlpha() >= 50L);
                assertTrue(profile.getReservedLongAlpha() <= 150L);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedLongBravoRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedLongBravoMin(75L);
            lookupInfo.setReservedLongBravoMax(225L);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedLongBravo() >= 75L);
                assertTrue(profile.getReservedLongBravo() <= 225L);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedLongCharlieRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedLongCharlieMin(100L);
            lookupInfo.setReservedLongCharlieMax(300L);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedLongCharlie() >= 100L);
                assertTrue(profile.getReservedLongCharlie() <= 300L);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedLongDeltaRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedLongDeltaMin(125L);
            lookupInfo.setReservedLongDeltaMax(375L);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedLongDelta() >= 125L);
                assertTrue(profile.getReservedLongDelta() <= 375L);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedIntegerAlphaRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedIntegerAlphaMin(25);
            lookupInfo.setReservedIntegerAlphaMax(75);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedIntegerAlpha() >= 25);
                assertTrue(profile.getReservedIntegerAlpha() <= 75);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedIntegerBravoRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedIntegerBravoMin(40);
            lookupInfo.setReservedIntegerBravoMax(120);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedIntegerBravo() >= 40);
                assertTrue(profile.getReservedIntegerBravo() <= 120);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedIntegerCharlieRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedIntegerCharlieMin(60);
            lookupInfo.setReservedIntegerCharlieMax(180);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedIntegerCharlie() >= 60);
                assertTrue(profile.getReservedIntegerCharlie() <= 180);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedIntegerDeltaRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedIntegerDeltaMin(80);
            lookupInfo.setReservedIntegerDeltaMax(240);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedIntegerDelta() >= 80);
                assertTrue(profile.getReservedIntegerDelta() <= 240);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedBooleanAlphaLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedBooleanAlpha(true);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(20, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedBooleanAlpha());
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedBooleanBravoLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedBooleanBravo(true);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(14, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedBooleanBravo());
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedBooleanCharlieLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedBooleanCharlie(true);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(10, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedBooleanCharlie());
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedBooleanDeltaLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedBooleanDelta(true);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(8, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedBooleanDelta());
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedDateAlphaRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.JANUARY, 5, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date minDate = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 15, 0, 0, 0);
            Date maxDate = calendar.getTime();
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedDateAlphaMin(minDate);
            lookupInfo.setReservedDateAlphaMax(maxDate);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedDateAlpha().compareTo(minDate) >= 0);
                assertTrue(profile.getReservedDateAlpha().compareTo(maxDate) <= 0);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedDateBravoRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.JANUARY, 10, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date minDate = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 20, 0, 0, 0);
            Date maxDate = calendar.getTime();
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedDateBravoMin(minDate);
            lookupInfo.setReservedDateBravoMax(maxDate);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedDateBravo().compareTo(minDate) >= 0);
                assertTrue(profile.getReservedDateBravo().compareTo(maxDate) <= 0);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedDateCharlieRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.JANUARY, 15, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date minDate = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 25, 0, 0, 0);
            Date maxDate = calendar.getTime();
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedDateCharlieMin(minDate);
            lookupInfo.setReservedDateCharlieMax(maxDate);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedDateCharlie().compareTo(minDate) >= 0);
                assertTrue(profile.getReservedDateCharlie().compareTo(maxDate) <= 0);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @Test
    public void testReservedDateDeltaRangeLookup() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.JANUARY, 20, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date minDate = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 30, 0, 0, 0);
            Date maxDate = calendar.getTime();
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setReservedDateDeltaMin(minDate);
            lookupInfo.setReservedDateDeltaMax(maxDate);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(11, filteredResults.size());
            for (Profile profile : filteredResults) {
                assertTrue(profile.getReservedDateDelta().compareTo(minDate) >= 0);
                assertTrue(profile.getReservedDateDelta().compareTo(maxDate) <= 0);
            }
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }

    @SuppressWarnings("ExtractMethodRecommender")
    @Test
    public void testCompositeLookupAllFields() throws Exception {
        try {
            Set<StringIdKey> testProfileKeys = new HashSet<>();
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                user.setKey(userMaintainService.insert(user));
                Profile profile = profiles.get(i);
                profile.setKey(profileMaintainService.insert(profile));
                testProfileKeys.add(profile.getKey());
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(2024, Calendar.JANUARY, 5, 0, 0, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date dateMin = calendar.getTime();
            calendar.set(2024, Calendar.JANUARY, 30, 0, 0, 0);
            Date dateMax = calendar.getTime();
            ProfileCompositeLookupInfo lookupInfo = new ProfileCompositeLookupInfo();
            lookupInfo.setStringIdPattern("test_user.10");
            lookupInfo.setNamePattern("profile_name_010");
            lookupInfo.setPhoneNumberPattern("phone_010");
            lookupInfo.setEmailAddressPattern("email_010");
            lookupInfo.setRemarkPattern("remark_010");
            lookupInfo.setReservedStringAlphaPattern("alpha_010");
            lookupInfo.setReservedStringBravoPattern("bravo_010");
            lookupInfo.setReservedStringCharliePattern("charlie_010");
            lookupInfo.setReservedStringDeltaPattern("delta_010");
            lookupInfo.setReservedStringEchoPattern("echo_010");
            lookupInfo.setReservedStringFoxtrotPattern("foxtrot_010");
            lookupInfo.setReservedStringGolfPattern("golf_010");
            lookupInfo.setReservedStringHotelPattern("hotel_010");
            lookupInfo.setReservedBooleanAlpha(true);
            lookupInfo.setReservedBooleanBravo(false);
            lookupInfo.setReservedBooleanCharlie(false);
            lookupInfo.setReservedBooleanDelta(true);
            lookupInfo.setReservedLongAlphaMin(90L);
            lookupInfo.setReservedLongAlphaMax(110L);
            lookupInfo.setReservedLongBravoMin(135L);
            lookupInfo.setReservedLongBravoMax(165L);
            lookupInfo.setReservedLongCharlieMin(180L);
            lookupInfo.setReservedLongCharlieMax(220L);
            lookupInfo.setReservedLongDeltaMin(225L);
            lookupInfo.setReservedLongDeltaMax(275L);
            lookupInfo.setReservedIntegerAlphaMin(45);
            lookupInfo.setReservedIntegerAlphaMax(55);
            lookupInfo.setReservedIntegerBravoMin(72);
            lookupInfo.setReservedIntegerBravoMax(88);
            lookupInfo.setReservedIntegerCharlieMin(108);
            lookupInfo.setReservedIntegerCharlieMax(132);
            lookupInfo.setReservedIntegerDeltaMin(144);
            lookupInfo.setReservedIntegerDeltaMax(176);
            lookupInfo.setReservedDateAlphaMin(dateMin);
            lookupInfo.setReservedDateAlphaMax(dateMax);
            lookupInfo.setReservedDateBravoMin(dateMin);
            lookupInfo.setReservedDateBravoMax(dateMax);
            lookupInfo.setReservedDateCharlieMin(dateMin);
            lookupInfo.setReservedDateCharlieMax(dateMax);
            lookupInfo.setReservedDateDeltaMin(dateMin);
            lookupInfo.setReservedDateDeltaMax(dateMax);
            PagedData<Profile> result = profileMaintainService.lookup(
                    ProfileMaintainService.COMPOSITE_LOOKUP,
                    new Object[]{lookupInfo}
            );
            List<Profile> filteredResults = new ArrayList<>();
            for (Profile item : result.getData()) {
                if (item.getKey() != null && testProfileKeys.contains(item.getKey())) {
                    filteredResults.add(item);
                }
            }
            assertNotNull(result);
            assertEquals(1, filteredResults.size());
            Profile matchedProfile = filteredResults.get(0);
            assertTrue(matchedProfile.getKey().getStringId().contains("test_user.10"));
            assertTrue(matchedProfile.getName().contains("profile_name_010"));
            assertTrue(matchedProfile.getReservedBooleanAlpha());
            assertFalse(matchedProfile.getReservedBooleanBravo());
            assertTrue(matchedProfile.getReservedBooleanDelta());
        } finally {
            for (Profile profile : profiles) {
                if (Objects.nonNull(profile.getKey())) {
                    profileMaintainService.deleteIfExists(profile.getKey());
                }
            }
            for (User user : users) {
                if (Objects.nonNull(user.getKey())) {
                    userMaintainService.deleteIfExists(user.getKey());
                }
            }
        }
    }
}
