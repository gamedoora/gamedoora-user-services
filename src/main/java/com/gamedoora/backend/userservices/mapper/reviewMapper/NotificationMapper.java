package com.gamedoora.backend.userservices.mapper.reviewMapper;

import com.gamedoora.backend.userservices.dto.reviewDTO.NotificationsDTO;
import com.gamedoora.backend.userservices.mapper.BaseMapper;
import com.gamedoora.model.db.Notifications;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class NotificationMapper extends BaseMapper {

    public abstract NotificationsDTO notificationToNotificationDTO(Notifications notifications);

    @Mapping(target = "createdBy" , expression = "java(getCreatedBy())")
    @Mapping(target = "createdOn" , expression = "java(getNewDate())")
    @Mapping(target = "updateBy" , expression = "java(getUpdatedBy())")
    @Mapping(target = "updateOn" , expression = "java(getNewDate())")
    public abstract Notifications notificationsDtoToNotifications(NotificationsDTO notificationsDTO);
}
