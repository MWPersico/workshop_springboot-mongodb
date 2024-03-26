package com.marcprojects.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcprojects.workshopmongo.dto.PostDTO;
import com.marcprojects.workshopmongo.entities.User;
import com.marcprojects.workshopmongo.repositories.UserRepository;
import com.marcprojects.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		List<User> users = repository.findAll();
		return users;
	}
	
	public User findById(String id) {
		User user = repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id)); 
		return user;
	}
	
	public List<PostDTO> findPostsById(String id){
		User user = findById(id);
		List<PostDTO> posts = user.getPosts().stream().map(PostDTO::new).toList();
		return posts;
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void deleteById(String id) {
		if(!repository.existsById(id))throw new ResourceNotFoundException(id);
		repository.deleteById(id);
	}
	
	public User update(String id, User obj) {
		User user = repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id));
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		return repository.save(user);
	}
}
