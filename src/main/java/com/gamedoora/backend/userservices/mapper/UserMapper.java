package com.gamedoora.backend.userservices.mapper;

import com.gamedoora.backend.userservices.dto.UserDTO;
import com.gamedoora.model.dao.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userstoUserDTO(Users users);

    Users userDtoToUsers(UserDTO userDTO);
}
