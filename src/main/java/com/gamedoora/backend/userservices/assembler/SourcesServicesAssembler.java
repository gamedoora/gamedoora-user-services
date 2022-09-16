package com.gamedoora.backend.userservices.assembler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.gamedoora.backend.userservices.dto.SourceDTO;
import com.gamedoora.backend.userservices.repository.SourcesRepository;
import com.gamedoora.model.dao.Sources;

@Component
public class SourcesServicesAssembler {

	@Autowired
	private SourcesRepository sourcesRepository;

	public SourceDTO createSources(SourceDTO sourcesDto) {

		Sources Sources = new Sources();
		Sources.setName(sourcesDto.getName());
		Sources.setCreatedBy("GameDoora");
		Sources.setUpdateBy("GameDoora");
		Sources.setCreatedOn(new Date());
		Sources.setUpdateOn(new Date());

		sourcesRepository.save(Sources);
		return sourcesDto;

	}

	public SourceDTO updateSources(long id, SourceDTO sourcesDto) {

		Optional<Sources> sourcesRes = sourcesRepository.findById(id);
		if (sourcesRes.isPresent()) {
			return null;
		}
		Sources sources = sourcesRes.get();
		sources.setName(sourcesDto.getName());

		sourcesRepository.save(sources);
		return sourcesDto;

	}

	public void deleteSources(long id) {

		sourcesRepository.deleteById(id);

	}

	public ResponseEntity<HttpStatus> deleteAllSources() {
		try {
			sourcesRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public List<Sources> getAllSources(String name) {

		List<Sources> sources = new ArrayList<Sources>();
		if (name == null)
			sourcesRepository.findAll().forEach(sources::add);
		else
			sourcesRepository.findByNameContaining(name).forEach(sources::add);
		if (sources.isEmpty()) {
			return null;
		}
		return sources;
	}

}
