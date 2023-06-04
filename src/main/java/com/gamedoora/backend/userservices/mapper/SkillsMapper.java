package com.gamedoora.backend.userservices.mapper;

import com.gamedoora.backend.userservices.dto.SkillsDTO;
import com.gamedoora.model.dao.Skills;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class SkillsMapper extends BaseMapper{
    public abstract SkillsDTO skillsToSkillsDTO(Skills skills);

    @Mapping(target = "createdBy" , qualifiedByName = "CreatedBy")
    @Mapping(target = "createdOn" , qualifiedByName = "NewDate")
    @Mapping(target = "updateBy" , qualifiedByName = "UpdatedBy")
    @Mapping(target = "updateOn" , qualifiedByName = "NewDate")
    public abstract Skills skillsDtoToSkills(SkillsDTO skillsDTO);
}
