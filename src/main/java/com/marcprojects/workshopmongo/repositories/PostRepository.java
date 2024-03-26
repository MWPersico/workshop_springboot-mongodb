package com.marcprojects.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marcprojects.workshopmongo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{}