package com.dwarfeng.buddy.node.all.he.configuration;

import com.dwarfeng.buddy.impl.bean.BeanMapper;
import com.dwarfeng.buddy.impl.bean.entity.HibernateAvatarInfo;
import com.dwarfeng.buddy.impl.bean.entity.HibernateNotification;
import com.dwarfeng.buddy.impl.bean.entity.HibernateProfile;
import com.dwarfeng.buddy.impl.bean.entity.HibernateUser;
import com.dwarfeng.buddy.impl.dao.preset.AvatarInfoPresetCriteriaMaker;
import com.dwarfeng.buddy.impl.dao.preset.NotificationPresetCriteriaMaker;
import com.dwarfeng.buddy.impl.dao.preset.ProfilePresetCriteriaMaker;
import com.dwarfeng.buddy.impl.dao.preset.UserPresetCriteriaMaker;
import com.dwarfeng.buddy.stack.bean.entity.AvatarInfo;
import com.dwarfeng.buddy.stack.bean.entity.Notification;
import com.dwarfeng.buddy.stack.bean.entity.Profile;
import com.dwarfeng.buddy.stack.bean.entity.User;
import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.dao.HibernateBatchBaseDao;
import com.dwarfeng.subgrade.impl.dao.HibernateEntireLookupDao;
import com.dwarfeng.subgrade.impl.dao.HibernatePresetLookupDao;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.sdk.hibernate.modification.DefaultDeletionMod;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

@Configuration
public class DaoConfiguration {

    private final HibernateTemplate template;

    private final AvatarInfoPresetCriteriaMaker avatarInfoPresetCriteriaMaker;
    private final NotificationPresetCriteriaMaker notificationPresetCriteriaMaker;
    private final ProfilePresetCriteriaMaker profilePresetCriteriaMaker;
    private final UserPresetCriteriaMaker userPresetCriteriaMaker;

    @Value("${com.dwarfeng.buddy.hibernate.jdbc.batch_size}")
    private int batchSize;

    public DaoConfiguration(
            HibernateTemplate template,
            AvatarInfoPresetCriteriaMaker avatarInfoPresetCriteriaMaker,
            NotificationPresetCriteriaMaker notificationPresetCriteriaMaker,
            ProfilePresetCriteriaMaker profilePresetCriteriaMaker,
            UserPresetCriteriaMaker userPresetCriteriaMaker
    ) {
        this.template = template;
        this.avatarInfoPresetCriteriaMaker = avatarInfoPresetCriteriaMaker;
        this.notificationPresetCriteriaMaker = notificationPresetCriteriaMaker;
        this.profilePresetCriteriaMaker = profilePresetCriteriaMaker;
        this.userPresetCriteriaMaker = userPresetCriteriaMaker;
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, AvatarInfo, HibernateAvatarInfo>
    avatarInfoHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(AvatarInfo.class, HibernateAvatarInfo.class, BeanMapper.class),
                HibernateAvatarInfo.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<AvatarInfo, HibernateAvatarInfo> avatarInfoHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(AvatarInfo.class, HibernateAvatarInfo.class, BeanMapper.class),
                HibernateAvatarInfo.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<AvatarInfo, HibernateAvatarInfo> avatarInfoHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(AvatarInfo.class, HibernateAvatarInfo.class, BeanMapper.class),
                HibernateAvatarInfo.class,
                avatarInfoPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<LongIdKey, HibernateLongIdKey, Notification, HibernateNotification>
    notificationHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(LongIdKey.class, HibernateLongIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Notification.class, HibernateNotification.class, BeanMapper.class),
                HibernateNotification.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Notification, HibernateNotification> notificationHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Notification.class, HibernateNotification.class, BeanMapper.class),
                HibernateNotification.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Notification, HibernateNotification> notificationHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Notification.class, HibernateNotification.class, BeanMapper.class),
                HibernateNotification.class,
                notificationPresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, Profile, HibernateProfile>
    profileHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(Profile.class, HibernateProfile.class, BeanMapper.class),
                HibernateProfile.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<Profile, HibernateProfile> profileHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Profile.class, HibernateProfile.class, BeanMapper.class),
                HibernateProfile.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<Profile, HibernateProfile> profileHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(Profile.class, HibernateProfile.class, BeanMapper.class),
                HibernateProfile.class,
                profilePresetCriteriaMaker
        );
    }

    @Bean
    public HibernateBatchBaseDao<StringIdKey, HibernateStringIdKey, User, HibernateUser> userHibernateBatchBaseDao() {
        return new HibernateBatchBaseDao<>(
                template,
                new MapStructBeanTransformer<>(StringIdKey.class, HibernateStringIdKey.class, BeanMapper.class),
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, BeanMapper.class),
                HibernateUser.class,
                new DefaultDeletionMod<>(),
                batchSize
        );
    }

    @Bean
    public HibernateEntireLookupDao<User, HibernateUser> userHibernateEntireLookupDao() {
        return new HibernateEntireLookupDao<>(
                template,
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, BeanMapper.class),
                HibernateUser.class
        );
    }

    @Bean
    public HibernatePresetLookupDao<User, HibernateUser> userHibernatePresetLookupDao() {
        return new HibernatePresetLookupDao<>(
                template,
                new MapStructBeanTransformer<>(User.class, HibernateUser.class, BeanMapper.class),
                HibernateUser.class,
                userPresetCriteriaMaker
        );
    }
}
