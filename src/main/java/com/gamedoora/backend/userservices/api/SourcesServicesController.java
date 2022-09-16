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

import com.gamedoora.backend.userservices.assembler.SourcesServicesAssembler;
import com.gamedoora.backend.userservices.dto.SourceDTO;
import com.gamedoora.backend.userservices.exceptions.NotFoundException;
import com.gamedoora.model.dao.Sources;

@RestController

public class SourcesServicesController extends BaseController {

	@Autowired
	SourcesServicesAssembler sourcesServicesAssembler;

	@PostMapping(value = "/")
	public ResponseEntity<SourceDTO> createSources(@RequestBody SourceDTO sourceDto) {
		return createResponse(sourcesServicesAssembler.createSources(sourceDto), HttpStatus.CREATED);

	}

	@PutMapping("/Sources/{id}")
	public ResponseEntity<SourceDTO> updateSources(@PathVariable("id") long id, @RequestBody SourceDTO sourceDto) {
		SourceDTO sourceDTO = sourcesServicesAssembler.updateSources(id, sourceDto);
		if (null == sourceDTO) {
			throw new NotFoundException(MessageFormat.format("Source by id {0} not found", id));
		}
		return createResponse(sourceDTO, HttpStatus.OK);
	}

	@DeleteMapping("/Sources/{id}")
	public ResponseEntity<HttpStatus> deleteSources(@PathVariable("id") long id) {
		sourcesServicesAssembler.deleteSources(id);
		return createResponse(null, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/")
	public ResponseEntity<HttpStatus> deleteAllSources() {
		sourcesServicesAssembler.deleteAllSources();
		return createResponse(null, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/")
	public ResponseEntity<List<Sources>> getAllSources(@RequestParam(required = false) String name) {
		return createResponse(sourcesServicesAssembler.getAllSources(name), HttpStatus.OK);
	}
}
