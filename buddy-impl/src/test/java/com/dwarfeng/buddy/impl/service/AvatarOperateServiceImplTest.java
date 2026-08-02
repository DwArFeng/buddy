package com.dwarfeng.buddy.impl.service;

import com.dwarfeng.buddy.impl.handler.FtpPathResolver;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFile;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFileDownloadInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarRemoveInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.buddy.stack.service.AvatarInfoMaintainService;
import com.dwarfeng.buddy.stack.service.AvatarOperateService;
import com.dwarfeng.buddy.stack.service.UserMaintainService;
import com.dwarfeng.dutil.basic.io.IOUtil;
import com.dwarfeng.ftp.stack.handler.FtpHandler;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Objects;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class AvatarOperateServiceImplTest {

    private static final StringIdKey USER_KEY = new StringIdKey("test_user");

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private UserMaintainService userMaintainService;
    @Autowired
    private AvatarInfoMaintainService avatarInfoMaintainService;

    @Autowired
    private AvatarOperateService avatarOperateService;

    @Autowired
    private FtpHandler ftpHandler;

    @Autowired
    private FtpPathResolver ftpPathResolver;

    private User user;

    @Before
    public void setUp() {
        user = new User(
                USER_KEY, "remark",
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

            byte[] content;
            try (
                    InputStream in = ctx.getResource("classpath:ftp/test-avatar.png").getInputStream();
                    ByteArrayOutputStream out = new ByteArrayOutputStream()
            ) {
                IOUtil.trans(in, out, 4096);
                out.flush();
                content = out.toByteArray();
            }
            AvatarUploadInfo avatarUploadInfo = new AvatarUploadInfo(USER_KEY, "test-avatar.png", content);

            avatarOperateService.uploadFile(avatarUploadInfo);
            AvatarFile avatarFile = avatarOperateService.downloadFile(new AvatarFileDownloadInfo(USER_KEY));
            assertArrayEquals(content, avatarFile.getContent());

            avatarOperateService.uploadFile(avatarUploadInfo);
            avatarFile = avatarOperateService.downloadFile(new AvatarFileDownloadInfo(USER_KEY));
            assertArrayEquals(content, avatarFile.getContent());

            avatarOperateService.remove(new AvatarRemoveInfo(USER_KEY));
            assertFalse(ftpHandler.existsFile(
                    ftpPathResolver.resolvePath(FtpPathResolver.RELATIVE_PATH_AVATAR), USER_KEY.getStringId()
            ));
            assertFalse(avatarInfoMaintainService.exists(USER_KEY));
        } finally {
            if (Objects.nonNull(user.getKey())) {
                userMaintainService.deleteIfExists(user.getKey());
            }
        }
    }
}
