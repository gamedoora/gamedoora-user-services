package com.gamedoora.backend.userservices.api;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamedoora.backend.userservices.assembler.SkillsServicesAssembler;
import com.gamedoora.backend.userservices.dto.SkillsDTO;
import com.gamedoora.backend.userservices.exceptions.NotFoundException;
import com.gamedoora.model.dao.Skills;

@RestController

public class SkillsServicesController extends BaseController {

	@Autowired
	SkillsServicesAssembler skillsServicesAssembler;

	@PostMapping(value = "/")
	public ResponseEntity<SkillsDTO> createSkills(@RequestBody SkillsDTO skillsDto) {
		return createResponse(skillsServicesAssembler.createSkills(skillsDto), HttpStatus.CREATED);

	}

	@PutMapping("/skills/{id}")
	public ResponseEntity<SkillsDTO> updateSkills(@PathVariable("id") long id, @RequestBody SkillsDTO skillsDto) {
		SkillsDTO SkillsDTO = skillsServicesAssembler.updateSkills(id, skillsDto);
		if (null == SkillsDTO) {
			throw new NotFoundException(MessageFormat.format("Role by id {0} not found", id));
		}
		return createResponse(SkillsDTO, HttpStatus.OK);
	}

	@DeleteMapping("/skills/{id}")
	public ResponseEntity<HttpStatus> deleteSkills(@PathVariable("id") long id) {
		skillsServicesAssembler.deleteSkills(id);
		return createResponse(null, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/")
	public ResponseEntity<HttpStatus> deleteAllSkills() {
		skillsServicesAssembler.deleteAllSkills();
		return createResponse(null, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/")
	public ResponseEntity<List<Skills>> getAllSkills(@RequestParam(required = false) String name) {
		return createResponse(skillsServicesAssembler.getAllSkills(name), HttpStatus.OK);
	}
}
