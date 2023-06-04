package com.gamedoora.backend.userservices.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gamedoora.backend.userservices.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gamedoora.backend.userservices.dto.RoleDTO;
import com.gamedoora.backend.userservices.repository.RolesRepository;
import com.gamedoora.model.dao.Roles;

@Component
public class RolesServicesAssembler {

  @Autowired private RolesRepository rolesRepository;

  @Autowired private RolesMapper rolesMapper;

  public RoleDTO createRoles(RoleDTO rolesDto) {

    Roles roles = rolesMapper.roleDtoToRoles(rolesDto);
    rolesRepository.save(roles);
    return rolesDto;
  }

  public RoleDTO updateRoles(long id, RoleDTO rolesDto) {

    Optional<Roles> rolesRes = rolesRepository.findById(id);
    if (!rolesRes.isPresent()) {
      return null;
    }
    Roles roles = rolesRes.get();
    roles.setName(rolesDto.getName());
    roles.setDescription(rolesDto.getDescription());
    rolesRepository.save(roles);
    return rolesDto;
  }

  public void deleteRoles(long id) {
    rolesRepository.deleteById(id);
  }

  public void deleteAllRoles() {
    rolesRepository.deleteAll();
  }

  public List<RoleDTO> getAllRoles(String name) {
    List<RoleDTO> roleDTOList = new ArrayList<>();
    if (name == null) rolesRepository.findAll().forEach(roles -> roleDTOList.add(rolesMapper.roleToRoleDTO(roles)));
    else rolesRepository.findByNameContaining(name).forEach(roles -> roleDTOList.add(rolesMapper.roleToRoleDTO(roles)));

    return roleDTOList;
  }
}
