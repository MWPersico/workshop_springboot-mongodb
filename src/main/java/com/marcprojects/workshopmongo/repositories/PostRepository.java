package com.marcprojects.workshopmongo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.marcprojects.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{'title':{$regex:?0, $options:'i'}}")
	public List<Post> searchByTitle(String query);
	public List<Post> findByTitleContainingIgnoreCase(String query);
	
	// Query nativa, operador and compara de o parametro ?0 coincide com title OU body OU comments.text E a data está entre o parâmetro ?1 e ?2
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.message': { $regex: ?0, $options: 'i' } } ] } ] }")
	public List<Post> searchWithTextInRange(String text, Date minDate, Date maxDate);
}