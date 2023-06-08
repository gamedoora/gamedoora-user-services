package com.gamedoora.backend.userservices.dto.reviewDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NotificationUserDTO {

    private long id;

    private boolean isSeen;

    private boolean isClicked;
}
