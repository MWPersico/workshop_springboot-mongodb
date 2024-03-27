package com.marcprojects.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcprojects.workshopmongo.dto.PostDTO;
import com.marcprojects.workshopmongo.repositories.PostRepository;
import com.marcprojects.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
	public List<PostDTO> findAll(){
		List<PostDTO> posts = repository.findAll().stream().map(PostDTO::new).collect(Collectors.toList());
		return posts;
	}
	
	public PostDTO findById(String id) {
		PostDTO post = new PostDTO(repository.findById(id).orElseThrow(()->new ResourceNotFoundException(id)));
		return post;
	}
	
	public List<PostDTO> findByTitleContaining(String query){
		// Aqui qualquer um dos dois métodos do repository funcionam!
		List<PostDTO> posts = repository.searchByTitle(query).stream().map(PostDTO::new).toList();
		return posts;
	}
	
	public List<PostDTO> searchWithTextInRange(String text, Date minDate, Date maxDate){
		// Adicionando um dia
		maxDate = new Date(maxDate.getTime()+1000*60*60*24);
		
		List<PostDTO> posts = repository.searchWithTextInRange(text, minDate, maxDate).stream().map(PostDTO::new).toList();
		return posts;
	}
}
