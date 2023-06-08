package com.gamedoora.backend.userservices.dto.reviewDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class StoriesDTO {

    private long id;

    private String name;

    private String description;

    private Date startDate;

    private Date dueDate;

    private long position;

    private String remarks;
}
