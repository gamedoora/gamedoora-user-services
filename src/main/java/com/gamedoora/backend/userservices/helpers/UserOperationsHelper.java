package com.gamedoora.backend.userservices.helpers;

import com.gamedoora.backend.userservices.dto.UserDTO;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

@Component
public class UserOperationsHelper {
    private UsersResource keyclockUsersResource;

    public void addUser(UserDTO userDto){
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName(userDto.getFirstName());
    }
}
