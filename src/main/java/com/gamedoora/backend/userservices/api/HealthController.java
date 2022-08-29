package com.gamedoora.backend.userservices.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController implements BaseController {

	@GetMapping(value = "health")
	public ResponseEntity<String> provideHealthStatus() {
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}