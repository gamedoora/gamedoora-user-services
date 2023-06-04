package com.gamedoora.backend.userservices.mapper;


import com.gamedoora.backend.userservices.dto.SourceDTO;
import com.gamedoora.model.dao.Sources;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class SourceMapper extends BaseMapper{
    public abstract SourceDTO sourceToSourceDTO(Sources sources);

    @Mapping(target = "createdBy" , qualifiedByName = "CreatedBy")
    @Mapping(target = "createdOn" , qualifiedByName = "NewDate")
    @Mapping(target = "updateBy" , qualifiedByName = "UpdatedBy")
    @Mapping(target = "updateOn" , qualifiedByName = "NewDate")
    public abstract Sources sourceDtoToSources(SourceDTO sourceDTO);
}
