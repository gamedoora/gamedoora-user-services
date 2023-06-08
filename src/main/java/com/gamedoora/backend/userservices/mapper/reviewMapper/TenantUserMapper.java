package com.gamedoora.backend.userservices.mapper.reviewMapper;

import com.gamedoora.backend.userservices.dto.reviewDTO.TenantUserDTO;
import com.gamedoora.backend.userservices.mapper.BaseMapper;
import com.gamedoora.model.db.TenantUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class TenantUserMapper extends BaseMapper {

    public abstract TenantUserDTO tenantUserToTenantUserDto(TenantUser tenantUser);

    @Mapping(target = "createdBy" , expression = "java(getCreatedBy())")
    @Mapping(target = "createdOn" , expression = "java(getNewDate())")
    @Mapping(target = "updateBy" , expression = "java(getUpdatedBy())")
    @Mapping(target = "updateOn" , expression = "java(getNewDate())")
    public abstract TenantUser tenantUserDtoToTenantUser(TenantUserDTO tenantUserDTO);
}
