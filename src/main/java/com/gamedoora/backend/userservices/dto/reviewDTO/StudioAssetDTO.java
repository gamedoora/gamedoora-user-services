package com.gamedoora.backend.userservices.dto.reviewDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class StudioAssetDTO {

    private long id;

    private String uid;

    private String name;

    private String context;

    private int version;

    private int parentId;

    private String bucketName;

    private boolean isPublished;

    private boolean isUploaded;

    private boolean isUploading;

    private boolean isDeleted;

    private int assetFileSize;

    private String assetFileContentType;

    private String assetFileName;

    private String assetFileUrl;

    private Date assetFileUpdatedAt;

    private int scriptLockedBy;

    private Date scriptLockedAt;

    private String assetType;
}
