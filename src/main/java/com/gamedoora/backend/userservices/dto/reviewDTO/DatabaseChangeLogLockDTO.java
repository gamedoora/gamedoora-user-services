package com.gamedoora.backend.userservices.dto.reviewDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
public class DatabaseChangeLogLockDTO {

    private long id;

    private String lockedBy;

    private Date lockGranted;

    private boolean locked;

}
