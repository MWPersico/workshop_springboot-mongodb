package com.marcprojects.workshopmongo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcprojects.workshopmongo.entities.User;
import com.marcprojects.workshopmongo.repositories.UserRepository;

@Configuration
public class DBSeeding implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		List<User> users = new ArrayList<>();
		users.add(new User(null, "Alex", "alex@email.com"));
		users.add(new User(null, "Bob", "bob@outlook.com"));
		users.add(new User(null, "Mary", "maryrose@gmail.com"));
		
		userRepository.saveAll(users);
	}
}
