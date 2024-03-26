package com.marcprojects.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marcprojects.workshopmongo.entities.User;

public interface UserRepository extends MongoRepository<User, String>{}