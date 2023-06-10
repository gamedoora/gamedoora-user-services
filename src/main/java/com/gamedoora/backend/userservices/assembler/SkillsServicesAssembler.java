package com.gamedoora.backend.userservices.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mapper.SkillsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.SkillsDTO;
import com.gamedoora.backend.userservices.repository.SkillsRepository;
import com.gamedoora.model.dao.Skills;

@Component
public class SkillsServicesAssembler {

  @Autowired
  private SkillsRepository skillsRepository;

  @Autowired
  private SkillsMapper skillsMapper;

  public SkillsDTO createSkills(SkillsDTO skillsDto) {

    Skills skills = skillsMapper.skillsDtoToSkills(skillsDto);
    skillsRepository.save(skills);
    return skillsDto;
  }

  public SkillsDTO updateSkills(long id, SkillsDTO skillsDto) {

    Optional<Skills> skillsRes = skillsRepository.findById(id);
    if (!skillsRes.isPresent()) {
      return null;
    }
    Skills skills = skillsRes.get();
    skills.setName(skillsDto.getName());
    skills.setDescription(skillsDto.getDescription());
    skillsRepository.save(skills);
    return skillsDto;
  }

  public void deleteSkills(long id) {
    skillsRepository.deleteById(id);
  }

  public void deleteAllSkills() {
    skillsRepository.deleteAll();
  }

  public List<SkillsDTO> getAllSkills(String name) {
    List<SkillsDTO> skillsDTOList = new ArrayList<>();
    if (name == null) {
      skillsRepository.findAll().forEach(skills -> skillsDTOList.add(skillsMapper.skillsToSkillsDTO(skills)));
      return skillsDTOList;
    }
    skillsRepository.findByNameContaining(name).forEach(skills -> skillsDTOList.add(skillsMapper.skillsToSkillsDTO(skills)));
    return skillsDTOList;
  }
}