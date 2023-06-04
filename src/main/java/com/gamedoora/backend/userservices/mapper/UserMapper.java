package com.gamedoora.backend.userservices.mapper;


import com.gamedoora.backend.userservices.dto.UserDTO;
import com.gamedoora.model.dao.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = BaseMapper.class)
public abstract class UserMapper extends BaseMapper{

    public abstract UserDTO usersToUserDTO(Users users);

    @Mapping(target = "createdBy" , qualifiedByName = "CreatedBy")
    @Mapping(target = "createdOn" , qualifiedByName = "NewDate")
    @Mapping(target = "updateBy" , qualifiedByName = "UpdatedBy")
    @Mapping(target = "updateOn" , qualifiedByName = "NewDate")
    public abstract Users userDtoToUsers(UserDTO userDTO);

}
