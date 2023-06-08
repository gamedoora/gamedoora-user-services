package com.gamedoora.backend.userservices.mapper.reviewMapper;

import com.gamedoora.backend.userservices.dto.reviewDTO.StudioAssetDTO;
import com.gamedoora.backend.userservices.mapper.BaseMapper;
import com.gamedoora.model.db.StudioAsset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public abstract class StudioAssetMapper extends BaseMapper {

    public abstract StudioAssetDTO studioAssetToStudioAssetDto(StudioAsset studioAsset);

    @Mapping(target = "createdBy" , expression = "java(getCreatedBy())")
    @Mapping(target = "createdOn" , expression = "java(getNewDate())")
    @Mapping(target = "updateBy" , expression = "java(getUpdatedBy())")
    @Mapping(target = "updateOn" , expression = "java(getNewDate())")
    public abstract StudioAsset studioAssetDtoToStudioAsset(StudioAssetDTO studioAssetDTO);
}
