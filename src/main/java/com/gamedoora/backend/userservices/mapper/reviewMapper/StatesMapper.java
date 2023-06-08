package com.gamedoora.backend.userservices.mapper.reviewMapper;

import com.gamedoora.backend.userservices.dto.reviewDTO.StatesDTO;
import com.gamedoora.backend.userservices.mapper.BaseMapper;
import com.gamedoora.model.db.States;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class StatesMapper extends BaseMapper {

    public abstract StatesDTO statesToStatesDto(States states);

    @Mapping(target = "createdBy" , expression = "java(getCreatedBy())")
    @Mapping(target = "createdOn" , expression = "java(getNewDate())")
    @Mapping(target = "updateBy" , expression = "java(getUpdatedBy())")
    @Mapping(target = "updateOn" , expression = "java(getNewDate())")
    public abstract States statesDtoToStates(StatesDTO statesDTO);
}
