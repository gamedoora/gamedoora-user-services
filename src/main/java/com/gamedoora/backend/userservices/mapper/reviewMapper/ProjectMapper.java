package com.gamedoora.backend.userservices.mapper.reviewMapper;

import com.gamedoora.backend.userservices.dto.reviewDTO.ProjectDTO;
import com.gamedoora.backend.userservices.mapper.BaseMapper;
import com.gamedoora.model.db.Projects;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class ProjectMapper extends BaseMapper {

    public abstract ProjectDTO projectToProjectDto(Projects projects);

    @Mapping(target = "createdBy" , expression = "java(getCreatedBy())")
    @Mapping(target = "createdOn" , expression = "java(getNewDate())")
    @Mapping(target = "updateBy" , expression = "java(getUpdatedBy())")
    @Mapping(target = "updateOn" , expression = "java(getNewDate())")
    public abstract Projects projectDtoToProject(ProjectDTO projectDTO);
}
