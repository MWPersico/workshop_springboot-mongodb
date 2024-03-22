package com.marcprojects.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcprojects.workshopmongo.dto.UserDTO;
import com.marcprojects.workshopmongo.entities.User;
import com.marcprojects.workshopmongo.repositories.UserRepository;
import com.marcprojects.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<UserDTO> findAll(){
		List<User> users = repository.findAll();
		return users.stream().map(UserDTO::new).toList();
	}
	
	public UserDTO findById(String id) {
		User user = repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id)); 
		return new UserDTO(user);
	}
}
