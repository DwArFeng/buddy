package com.dwarfeng.buddy.impl.handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * FTP 路径解析器。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@Component
public class FtpPathResolver {

    public static final char ROOT_PATH_STRING_SEPARATOR = '/';
    public static final String ROOT_PATH_STRING_SEPARATOR_STRING = String.valueOf(ROOT_PATH_STRING_SEPARATOR);

    /**
     * 头像文件的相对路径。
     */
    public static final String[] RELATIVE_PATH_AVATAR = new String[]{"avatar"};

    private static final Logger LOGGER = LoggerFactory.getLogger(FtpPathResolver.class);

    @Value("${com.dwarfeng.buddy.ftp.root_path}")
    private String rootPathString;

    private final Lock lock = new ReentrantLock();

    private String[] rootPath = null;

    /**
     * 解析路径。
     *
     * <p>
     * 该方法会在传入的相对路径前方拼接根路径，然后返回拼接后的路径。
     *
     * <p>
     * 对于 <code>relativePath</code> 参数，调用人员应确保只使用如下合法值:
     * <ul>
     *     <li>{@link #RELATIVE_PATH_AVATAR}</li>
     * </ul>
     *
     * @param relativePath 相对路径。
     * @return 解析后的路径。
     */
    public String[] resolvePath(@Nonnull String[] relativePath) {
        String[] rootPath = rootPath();
        String[] path = new String[rootPath.length + relativePath.length];
        System.arraycopy(rootPath, 0, path, 0, rootPath.length);
        System.arraycopy(relativePath, 0, path, rootPath.length, relativePath.length);
        return path;
    }

    private String[] rootPath() {
        if (Objects.nonNull(rootPath)) {
            return rootPath;
        }
        lock.lock();
        try {
            if (Objects.nonNull(rootPath)) {
                return rootPath;
            }
            initRootPath();
            return rootPath;
        } finally {
            lock.unlock();
        }
    }

    private void initRootPath() {
        String rootPathStringDejaVu = rootPathString;
        rootPathStringDejaVu = StringUtils.trim(rootPathStringDejaVu);
        if (StringUtils.isEmpty(rootPathStringDejaVu)) {
            rootPath = new String[0];
            return;
        }
        if (Strings.CS.startsWith(rootPathString, ROOT_PATH_STRING_SEPARATOR_STRING)) {
            LOGGER.warn("根路径 {} 非法, 将使用默认的根路径代替", rootPathString);
            rootPath = new String[0];
            return;
        }
        if (Strings.CS.endsWith(rootPathString, ROOT_PATH_STRING_SEPARATOR_STRING)) {
            LOGGER.warn("根路径 {} 非法, 将使用默认的根路径代替", rootPathString);
            rootPath = new String[0];
            return;
        }
        rootPath = StringUtils.split(rootPathStringDejaVu, ROOT_PATH_STRING_SEPARATOR);
    }
}
