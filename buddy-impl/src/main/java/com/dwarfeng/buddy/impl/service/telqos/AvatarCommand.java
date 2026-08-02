package com.dwarfeng.buddy.impl.service.telqos;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.buddy.sdk.bean.dto.WebInputAvatarRemoveInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFile;
import com.dwarfeng.buddy.stack.bean.dto.AvatarFileDownloadInfo;
import com.dwarfeng.buddy.stack.bean.dto.AvatarUploadInfo;
import com.dwarfeng.buddy.stack.service.AvatarQosService;
import com.dwarfeng.springtelqos.sdk.command.CliCommand;
import com.dwarfeng.springtelqos.sdk.configuration.TelqosCommand;
import com.dwarfeng.springtelqos.sdk.util.CliCommandUtil;
import com.dwarfeng.springtelqos.stack.command.CommandDescriptor;
import com.dwarfeng.springtelqos.stack.command.CommandExecutor;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputStringIdKey;
import com.dwarfeng.subgrade.stack.bean.dto.Dto;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.lang3.tuple.Pair;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 头像指令。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@TelqosCommand
public class AvatarCommand extends CliCommand {

    @SuppressWarnings({"SpellCheckingInspection", "GrazieInspectionRunner", "RedundantSuppression"})
    private static final String IDENTITY = "avatar";

    // region 指令选项

    private static final String COMMAND_OPTION_DOWNLOAD = "download";
    private static final String COMMAND_OPTION_UPLOAD = "upload";
    private static final String COMMAND_OPTION_REMOVE = "remove";

    private static final String[] COMMAND_OPTION_ARRAY = new String[]{
            COMMAND_OPTION_DOWNLOAD,
            COMMAND_OPTION_UPLOAD,
            COMMAND_OPTION_REMOVE
    };

    private static final String COMMAND_SUB_OPTION_JSON = "json";
    private static final String COMMAND_SUB_OPTION_JSON_FILE = "jf";
    private static final String COMMAND_SUB_OPTION_JSON_FILE_LONG_OPT = "json-file";

    // endregion

    private final AvatarQosService avatarQosService;

    public AvatarCommand(AvatarQosService avatarQosService) {
        super(IDENTITY);
        this.avatarQosService = avatarQosService;
    }

    @Override
    protected DescriptionProvider provideDescriptionProvider() {
        return context -> "头像操作服务";
    }

    @Override
    protected CliSyntaxProvider provideCliSyntaxProvider() {
        return this::cliSyntaxProvider;
    }

    private String cliSyntaxProvider(CommandDescriptor.Context context) throws Exception {
        String identity = context.getRuntimeIdentity();
        String[] patterns = new String[]{
                identity + " " + CliCommandUtil.concatOptionPrefix(COMMAND_OPTION_DOWNLOAD) +
                        " [" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON) + " json-string] " +
                        "[" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON_FILE) + " json-file]",
                identity + " " + CliCommandUtil.concatOptionPrefix(COMMAND_OPTION_UPLOAD) +
                        " [" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON) + " json-string] " +
                        "[" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON_FILE) + " json-file]",
                identity + " " + CliCommandUtil.concatOptionPrefix(COMMAND_OPTION_REMOVE) +
                        " [" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON) + " json-string] " +
                        "[" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON_FILE) + " json-file]"
        };
        return CliCommandUtil.cliSyntax(patterns);
    }

    @Override
    protected List<Option> provideOptions() {
        List<Option> list = new ArrayList<>();
        list.add(Option.builder(COMMAND_OPTION_DOWNLOAD).optionalArg(true).hasArg(false).desc("下载头像文件").build());
        list.add(Option.builder(COMMAND_OPTION_UPLOAD).optionalArg(true).hasArg(false).desc("上传头像文件").build());
        list.add(Option.builder(COMMAND_OPTION_REMOVE).optionalArg(true).hasArg(false).desc("移除头像").build());
        list.add(Option.builder(COMMAND_SUB_OPTION_JSON).hasArg(true).type(String.class).desc("JSON 字符串").build());
        list.add(Option.builder(COMMAND_SUB_OPTION_JSON_FILE).longOpt(COMMAND_SUB_OPTION_JSON_FILE_LONG_OPT)
                .hasArg(true).type(File.class).desc("JSON 文件").build());
        return list;
    }

    @Override
    protected void executeWithCmd(CommandExecutor.Context context, CommandLine cmd) throws Exception {
        Pair<String, Integer> pair = CliCommandUtil.analyseCommand(cmd, COMMAND_OPTION_ARRAY);
        if (pair.getRight() != 1) {
            context.sendMessage(CliCommandUtil.optionMismatchMessage(COMMAND_OPTION_ARRAY));
            context.sendMessage(context.getCommandManual(context.getRuntimeIdentity()));
            return;
        }
        switch (pair.getLeft()) {
            case COMMAND_OPTION_DOWNLOAD:
                handleDownload(context, cmd);
                break;
            case COMMAND_OPTION_UPLOAD:
                handleUpload(context, cmd);
                break;
            case COMMAND_OPTION_REMOVE:
                handleRemove(context, cmd);
                break;
            default:
                throw new IllegalStateException("不应该执行到此处, 请联系开发人员");
        }
    }

    private void handleDownload(CommandExecutor.Context context, CommandLine cmd) throws Exception {
        DownloadInfo info;
        if (cmd.hasOption(COMMAND_SUB_OPTION_JSON)) {
            String json = (String) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON);
            info = JSON.parseObject(json, DownloadInfo.class);
        } else if (cmd.hasOption(COMMAND_SUB_OPTION_JSON_FILE)) {
            File jsonFile = (File) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON_FILE);
            try (FileInputStream in = new FileInputStream(jsonFile)) {
                info = JSON.parseObject(in, DownloadInfo.class);
            }
        } else {
            throw new UnsupportedOperationException("not supported yet");
        }

        AvatarFile avatarFile = avatarQosService.downloadFile(
                new AvatarFileDownloadInfo(WebInputStringIdKey.toStackBean(info.getUserKey()))
        );
        if (Objects.isNull(avatarFile)) {
            context.sendMessage("头像不存在");
            return;
        }

        Files.write(
                new File(info.getFilePath()).toPath(),
                avatarFile.getContent(),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
        context.sendMessage("头像下载成功");
        context.sendMessage("  originName: " + avatarFile.getOriginName());
        context.sendMessage("  length: " + avatarFile.getContent().length);
    }

    private void handleUpload(CommandExecutor.Context context, CommandLine cmd) throws Exception {
        UploadInfo info;
        if (cmd.hasOption(COMMAND_SUB_OPTION_JSON)) {
            String json = (String) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON);
            info = JSON.parseObject(json, UploadInfo.class);
        } else if (cmd.hasOption(COMMAND_SUB_OPTION_JSON_FILE)) {
            File jsonFile = (File) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON_FILE);
            try (FileInputStream in = new FileInputStream(jsonFile)) {
                info = JSON.parseObject(in, UploadInfo.class);
            }
        } else {
            throw new UnsupportedOperationException("not supported yet");
        }

        File file = new File(info.getFilePath());
        String originName = file.getName();
        byte[] content = Files.readAllBytes(file.toPath());
        avatarQosService.uploadFile(new AvatarUploadInfo(
                WebInputStringIdKey.toStackBean(info.getUserKey()),
                originName,
                content
        ));
        context.sendMessage("头像上传成功");
    }

    private void handleRemove(CommandExecutor.Context context, CommandLine cmd) throws Exception {
        if (cmd.hasOption(COMMAND_SUB_OPTION_JSON)) {
            String json = (String) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON);
            avatarQosService.remove(WebInputAvatarRemoveInfo.toStackBean(
                    JSON.parseObject(json, WebInputAvatarRemoveInfo.class)
            ));
        } else if (cmd.hasOption(COMMAND_SUB_OPTION_JSON_FILE)) {
            File jsonFile = (File) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON_FILE);
            try (FileInputStream in = new FileInputStream(jsonFile)) {
                avatarQosService.remove(WebInputAvatarRemoveInfo.toStackBean(
                        JSON.parseObject(in, WebInputAvatarRemoveInfo.class)
                ));
            }
        } else {
            throw new UnsupportedOperationException("not supported yet");
        }
        context.sendMessage("头像移除成功");
    }

    public static class DownloadInfo implements Dto {

        private static final long serialVersionUID = -6594274892815132071L;

        @JSONField(name = "user_key")
        @NotNull
        @Valid
        private WebInputStringIdKey userKey;

        @JSONField(name = "file_path")
        @NotNull
        @NotEmpty
        private String filePath;

        public DownloadInfo() {
        }

        public WebInputStringIdKey getUserKey() {
            return userKey;
        }

        public void setUserKey(WebInputStringIdKey userKey) {
            this.userKey = userKey;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public String toString() {
            return "DownloadInfo{" +
                    "userKey=" + userKey +
                    ", filePath='" + filePath + '\'' +
                    '}';
        }
    }

    public static class UploadInfo implements Dto {

        private static final long serialVersionUID = -6971886527945165923L;

        @JSONField(name = "user_key")
        @NotNull
        @Valid
        private WebInputStringIdKey userKey;

        @JSONField(name = "file_path")
        @NotNull
        @NotEmpty
        private String filePath;

        public UploadInfo() {
        }

        public WebInputStringIdKey getUserKey() {
            return userKey;
        }

        public void setUserKey(WebInputStringIdKey userKey) {
            this.userKey = userKey;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public String toString() {
            return "UploadInfo{" +
                    "userKey=" + userKey +
                    ", filePath='" + filePath + '\'' +
                    '}';
        }
    }
}
