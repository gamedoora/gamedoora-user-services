package com.gamedoora.backend.userservices.mapper.reviewMapper;

import com.gamedoora.backend.userservices.dto.reviewDTO.CommentsDTO;
import com.gamedoora.backend.userservices.mapper.BaseMapper;
import com.gamedoora.model.db.Comments;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class CommentsMapper extends BaseMapper {

    public abstract CommentsDTO commentsToCommentsDto(Comments comments);

    @Mapping(target = "createdBy" , expression = "java(getCreatedBy())")
    @Mapping(target = "createdOn" , expression = "java(getNewDate())")
    @Mapping(target = "updateBy" , expression = "java(getUpdatedBy())")
    @Mapping(target = "updateOn" , expression = "java(getNewDate())")
    public abstract Comments commentsDtoToComments(CommentsDTO commentsDTO);
}
