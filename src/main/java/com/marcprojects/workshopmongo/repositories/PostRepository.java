package com.marcprojects.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marcprojects.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	public List<Post> findByTitleContainingIgnoreCase(String query);
}