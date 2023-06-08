package com.gamedoora.backend.userservices.mapper.reviewMapper;

import com.gamedoora.backend.userservices.dto.reviewDTO.TaskDTO;
import com.gamedoora.backend.userservices.mapper.BaseMapper;
import com.gamedoora.model.db.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TaskMapper extends BaseMapper {

    public abstract TaskDTO taskToTaskDto(Task task);

    @Mapping(target = "createdBy" , expression = "java(getCreatedBy())")
    @Mapping(target = "createdOn" , expression = "java(getNewDate())")
    @Mapping(target = "updateBy" , expression = "java(getUpdatedBy())")
    @Mapping(target = "updateOn" , expression = "java(getNewDate())")
    public abstract Task taskDtoToTask(TaskDTO taskDTO);
}
