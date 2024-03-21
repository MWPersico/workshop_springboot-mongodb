package com.marcprojects.workshopmongo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcprojects.workshopmongo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<User>> findAll(){
		List<User> users = new ArrayList<>();
		users.add(new User("1", "Marcos", "marcos@gmail.com"));
		users.add(new User("2", "Geysa", "geysa@gmail.com"));
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable String id){
		List<User> users = new ArrayList<>();
		users.add(new User("1", "Marcos", "marcos@gmail.com"));
		users.add(new User("2", "Geysa", "geysa@gmail.com"));
		
		User target = users.stream().filter(user->user.getId().equals(id)).findAny().orElse(null);
		
		return ResponseEntity.ok(target);
	}
}
