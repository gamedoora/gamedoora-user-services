package com.gamedoora.backend.userservices.mapper;

import com.gamedoora.backend.userservices.dto.RoleDTO;
import com.gamedoora.model.dao.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class RolesMapper extends BaseMapper{
    public abstract RoleDTO roleToRoleDTO(Roles roles);

    @Mapping(target = "createdBy" , qualifiedByName = "CreatedBy")
    @Mapping(target = "createdOn" , qualifiedByName = "NewDate")
    @Mapping(target = "updateBy" , qualifiedByName = "UpdatedBy")
    @Mapping(target = "updateOn" , qualifiedByName = "NewDate")
    public abstract Roles roleDtoToRoles(RoleDTO roleDTO);
}
