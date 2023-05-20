package com.gamedoora.backend.userservices.mapper;

import com.gamedoora.backend.userservices.dto.RoleDTO;
import com.gamedoora.model.dao.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class RolesMapper extends BaseMapper{
    public abstract RoleDTO roleToRoleDTO(Roles roles);

    @Mapping(target = "createdBy" , expression = "java(getCreatedBy())")
    @Mapping(target = "createdOn" , expression = "java(getNewDate())")
    @Mapping(target = "updateBy" , expression = "java(getUpdatedBy())")
    @Mapping(target = "updateOn" , expression = "java(getNewDate())")
    public abstract Roles roleDtoToRoles(RoleDTO roleDTO);
}
