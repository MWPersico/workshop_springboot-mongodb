package com.marcprojects.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.marcprojects.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{'title':{$regex:?0, $options:'i'}}")
	public List<Post> searchByTitle(String query);
	public List<Post> findByTitleContainingIgnoreCase(String query);
}