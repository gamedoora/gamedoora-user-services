package com.gamedoora.backend.userservices.mapper.reviewMapper;

import com.gamedoora.backend.userservices.dto.reviewDTO.StoriesDTO;
import com.gamedoora.backend.userservices.mapper.BaseMapper;
import com.gamedoora.model.db.Stories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class StoriesMapper extends BaseMapper {

    public abstract StoriesDTO storiesToStoriesDto(Stories stories);

    @Mapping(target = "createdBy" , expression = "java(getCreatedBy())")
    @Mapping(target = "createdOn" , expression = "java(getNewDate())")
    @Mapping(target = "updateBy" , expression = "java(getUpdatedBy())")
    @Mapping(target = "updateOn" , expression = "java(getNewDate())")
    public abstract Stories storiesDtoToStories(StoriesDTO storiesDTO);
}
