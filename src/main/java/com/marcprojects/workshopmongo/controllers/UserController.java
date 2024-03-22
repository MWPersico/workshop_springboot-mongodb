package com.marcprojects.workshopmongo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcprojects.workshopmongo.dto.UserDTO;
import com.marcprojects.workshopmongo.entities.User;
import com.marcprojects.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> users = service.findAll().stream().map(UserDTO::new).toList();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		UserDTO user = new UserDTO(service.findById(id));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping(value = {"", "/"})
	public ResponseEntity<UserDTO> insert(@RequestBody User obj) {
		UserDTO user = new UserDTO(service.insert(obj));
		URI path = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.id()).toUri();
		return ResponseEntity.created(path).body(user);
	}
}
