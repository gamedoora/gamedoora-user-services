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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamedoora.backend.userservices.assembler.UserServicesAssembler;
import com.gamedoora.backend.userservices.dto.UserDTO;
import com.gamedoora.backend.userservices.exceptions.NotFoundException;
import com.gamedoora.model.dao.Users;

@RestController
@RequestMapping("/api/users")

public class UserServicesController extends BaseController {

	@Autowired
	UserServicesAssembler userServicesAssembler;

	@PostMapping(value = "/")
	public ResponseEntity<UserDTO> createUsers(@RequestBody UserDTO usersDto) {
		return createResponse(userServicesAssembler.createUsers(usersDto), HttpStatus.CREATED);

	}

	@PutMapping("/users/{id}")
	public ResponseEntity<UserDTO> updateUsers(@PathVariable("id") long id, @RequestBody UserDTO usersDto) {
		UserDTO UserDTO = userServicesAssembler.updateUsers(id, usersDto);
		if (null == UserDTO) {
			throw new NotFoundException(MessageFormat.format("User by id {0} not found", id));
		}
		return createResponse(UserDTO, HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") long id) {
		userServicesAssembler.deleteUsers(id);
		return createResponse(null, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/")
	public ResponseEntity<HttpStatus> deleteAllUsers() {
		userServicesAssembler.deleteAllUsers();
		return createResponse(null, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/")
	public ResponseEntity<List<Users>> getAllUsers(@RequestParam(required = false) String name) {
		return createResponse(userServicesAssembler.getAllUsers(name), HttpStatus.OK);
	}
}
