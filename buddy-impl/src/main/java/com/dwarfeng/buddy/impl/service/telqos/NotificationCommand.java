package com.dwarfeng.buddy.impl.service.telqos;

import com.alibaba.fastjson.JSON;
import com.dwarfeng.buddy.sdk.bean.dto.WebInputNotificationClearForUserInfo;
import com.dwarfeng.buddy.sdk.bean.dto.WebInputNotificationCreateInfo;
import com.dwarfeng.buddy.sdk.bean.dto.WebInputNotificationReadAllForUserInfo;
import com.dwarfeng.buddy.sdk.bean.dto.WebInputNotificationReadInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationClearForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationCreateInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadAllForUserInfo;
import com.dwarfeng.buddy.stack.bean.dto.NotificationReadInfo;
import com.dwarfeng.buddy.stack.service.NotificationQosService;
import com.dwarfeng.springtelqos.sdk.command.CliCommand;
import com.dwarfeng.springtelqos.sdk.configuration.TelqosCommand;
import com.dwarfeng.springtelqos.sdk.util.CliCommandUtil;
import com.dwarfeng.springtelqos.stack.command.CommandDescriptor;
import com.dwarfeng.springtelqos.stack.command.CommandExecutor;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 通知指令。
 *
 * @author DwArFeng
 * @since 1.0.0
 */
@TelqosCommand
public class NotificationCommand extends CliCommand {

    @SuppressWarnings({"SpellCheckingInspection", "GrazieInspectionRunner", "RedundantSuppression"})
    private static final String IDENTITY = "notification";

    // region 指令选项

    private static final String COMMAND_OPTION_CREATE = "create";
    private static final String COMMAND_OPTION_READ = "read";
    @SuppressWarnings({"SpellCheckingInspection", "GrazieInspectionRunner", "RedundantSuppression"})
    private static final String COMMAND_OPTION_READ_ALL_FOR_USER = "rafu";
    private static final String COMMAND_OPTION_READ_ALL_FOR_USER_LONG_OPT = "read-all-for-user";
    @SuppressWarnings({"SpellCheckingInspection", "GrazieInspectionRunner", "RedundantSuppression"})
    private static final String COMMAND_OPTION_CLEAR_FOR_USER = "cfu";
    private static final String COMMAND_OPTION_CLEAR_FOR_USER_LONG_OPT = "clear-for-user";

    private static final String[] COMMAND_OPTION_ARRAY = new String[]{
            COMMAND_OPTION_CREATE,
            COMMAND_OPTION_READ,
            COMMAND_OPTION_READ_ALL_FOR_USER,
            COMMAND_OPTION_CLEAR_FOR_USER
    };

    private static final String COMMAND_SUB_OPTION_JSON = "json";
    private static final String COMMAND_SUB_OPTION_JSON_FILE = "jf";
    private static final String COMMAND_SUB_OPTION_JSON_FILE_LONG_OPT = "json-file";

    // endregion

    private final NotificationQosService notificationQosService;

    public NotificationCommand(NotificationQosService notificationQosService) {
        super(IDENTITY);
        this.notificationQosService = notificationQosService;
    }

    @Override
    protected DescriptionProvider provideDescriptionProvider() {
        return context -> "通知操作服务";
    }

    @Override
    protected CliSyntaxProvider provideCliSyntaxProvider() {
        return this::cliSyntaxProvider;
    }

    private String cliSyntaxProvider(CommandDescriptor.Context context) throws Exception {
        String identity = context.getRuntimeIdentity();
        String[] patterns = new String[]{
                identity + " " + CliCommandUtil.concatOptionPrefix(COMMAND_OPTION_CREATE) +
                        " [" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON) + " json-string] " +
                        "[" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON_FILE) + " json-file]",
                identity + " " + CliCommandUtil.concatOptionPrefix(COMMAND_OPTION_READ) +
                        " [" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON) + " json-string] " +
                        "[" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON_FILE) + " json-file]",
                identity + " " + CliCommandUtil.concatOptionPrefix(COMMAND_OPTION_READ_ALL_FOR_USER) +
                        " [" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON) + " json-string] " +
                        "[" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON_FILE) + " json-file]",
                identity + " " + CliCommandUtil.concatOptionPrefix(COMMAND_OPTION_CLEAR_FOR_USER) +
                        " [" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON) + " json-string] " +
                        "[" + CliCommandUtil.concatOptionPrefix(COMMAND_SUB_OPTION_JSON_FILE) + " json-file]"
        };
        return CliCommandUtil.cliSyntax(patterns);
    }

    @Override
    protected List<Option> provideOptions() {
        List<Option> list = new ArrayList<>();
        list.add(Option.builder(COMMAND_OPTION_CREATE).optionalArg(true).hasArg(false).desc("创建通知").build());
        list.add(Option.builder(COMMAND_OPTION_READ).optionalArg(true).hasArg(false).desc("阅读通知").build());
        list.add(
                Option.builder(COMMAND_OPTION_READ_ALL_FOR_USER).longOpt(COMMAND_OPTION_READ_ALL_FOR_USER_LONG_OPT)
                        .optionalArg(true).hasArg(false).desc("阅读用户的所有通知").build()
        );
        list.add(
                Option.builder(COMMAND_OPTION_CLEAR_FOR_USER).longOpt(COMMAND_OPTION_CLEAR_FOR_USER_LONG_OPT)
                        .optionalArg(true).hasArg(false).desc("清除用户的所有通知").build()
        );
        list.add(Option.builder(COMMAND_SUB_OPTION_JSON).hasArg(true).type(String.class).desc("JSON 字符串").build());
        list.add(
                Option.builder(COMMAND_SUB_OPTION_JSON_FILE).longOpt(COMMAND_SUB_OPTION_JSON_FILE_LONG_OPT)
                        .hasArg(true).type(File.class).desc("JSON 文件").build()
        );
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
            case COMMAND_OPTION_CREATE:
                handleCreate(context, cmd);
                break;
            case COMMAND_OPTION_READ:
                handleRead(context, cmd);
                break;
            case COMMAND_OPTION_READ_ALL_FOR_USER:
                handleReadAllForUser(context, cmd);
                break;
            case COMMAND_OPTION_CLEAR_FOR_USER:
                handleClearForUser(context, cmd);
                break;
            default:
                throw new IllegalStateException("不应该执行到此处, 请联系开发人员");
        }
    }

    private void handleCreate(CommandExecutor.Context context, CommandLine cmd) throws Exception {
        NotificationCreateInfo info;
        if (cmd.hasOption(COMMAND_SUB_OPTION_JSON)) {
            String json = (String) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON);
            info = WebInputNotificationCreateInfo.toStackBean(
                    JSON.parseObject(json, WebInputNotificationCreateInfo.class)
            );
        } else if (cmd.hasOption(COMMAND_SUB_OPTION_JSON_FILE)) {
            File jsonFile = (File) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON_FILE);
            try (FileInputStream in = new FileInputStream(jsonFile)) {
                info = WebInputNotificationCreateInfo.toStackBean(
                        JSON.parseObject(in, WebInputNotificationCreateInfo.class)
                );
            }
        } else {
            throw new UnsupportedOperationException("not supported yet");
        }

        LongIdKey notificationKey = notificationQosService.create(info);
        if (Objects.isNull(notificationKey)) {
            context.sendMessage("创建成功，通知主键: null");
            return;
        }
        context.sendMessage("创建成功，通知主键: " + notificationKey.getLongId());
    }

    private void handleRead(CommandExecutor.Context context, CommandLine cmd) throws Exception {
        NotificationReadInfo info;
        if (cmd.hasOption(COMMAND_SUB_OPTION_JSON)) {
            String json = (String) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON);
            info = WebInputNotificationReadInfo.toStackBean(
                    JSON.parseObject(json, WebInputNotificationReadInfo.class)
            );
        } else if (cmd.hasOption(COMMAND_SUB_OPTION_JSON_FILE)) {
            File jsonFile = (File) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON_FILE);
            try (FileInputStream in = new FileInputStream(jsonFile)) {
                info = WebInputNotificationReadInfo.toStackBean(
                        JSON.parseObject(in, WebInputNotificationReadInfo.class)
                );
            }
        } else {
            throw new UnsupportedOperationException("not supported yet");
        }

        notificationQosService.read(info);
        context.sendMessage("阅读成功");
    }

    private void handleReadAllForUser(CommandExecutor.Context context, CommandLine cmd) throws Exception {
        NotificationReadAllForUserInfo info;
        if (cmd.hasOption(COMMAND_SUB_OPTION_JSON)) {
            String json = (String) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON);
            info = WebInputNotificationReadAllForUserInfo.toStackBean(
                    JSON.parseObject(json, WebInputNotificationReadAllForUserInfo.class)
            );
        } else if (cmd.hasOption(COMMAND_SUB_OPTION_JSON_FILE)) {
            File jsonFile = (File) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON_FILE);
            try (FileInputStream in = new FileInputStream(jsonFile)) {
                info = WebInputNotificationReadAllForUserInfo.toStackBean(
                        JSON.parseObject(in, WebInputNotificationReadAllForUserInfo.class)
                );
            }
        } else {
            throw new UnsupportedOperationException("not supported yet");
        }

        notificationQosService.readAllForUser(info);
        context.sendMessage("全部阅读成功");
    }

    private void handleClearForUser(CommandExecutor.Context context, CommandLine cmd) throws Exception {
        NotificationClearForUserInfo info;
        if (cmd.hasOption(COMMAND_SUB_OPTION_JSON)) {
            String json = (String) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON);
            info = WebInputNotificationClearForUserInfo.toStackBean(
                    JSON.parseObject(json, WebInputNotificationClearForUserInfo.class)
            );
        } else if (cmd.hasOption(COMMAND_SUB_OPTION_JSON_FILE)) {
            File jsonFile = (File) cmd.getParsedOptionValue(COMMAND_SUB_OPTION_JSON_FILE);
            try (FileInputStream in = new FileInputStream(jsonFile)) {
                info = WebInputNotificationClearForUserInfo.toStackBean(
                        JSON.parseObject(in, WebInputNotificationClearForUserInfo.class)
                );
            }
        } else {
            throw new UnsupportedOperationException("not supported yet");
        }

        notificationQosService.clearForUser(info);
        context.sendMessage("清除成功");
    }
}
