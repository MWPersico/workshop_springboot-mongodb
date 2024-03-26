package com.marcprojects.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.marcprojects.workshopmongo.dto.AuthorDTO;
import com.marcprojects.workshopmongo.entities.Post;
import com.marcprojects.workshopmongo.entities.User;
import com.marcprojects.workshopmongo.repositories.PostRepository;
import com.marcprojects.workshopmongo.repositories.UserRepository;

@Configuration
public class DBSeeding implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		List<User> users = new ArrayList<>();
		users.add(new User(null, "Alex", "alex@email.com"));
		users.add(new User(null, "Bob", "bob@outlook.com"));
		users.add(new User(null, "Mary", "maryrose@gmail.com"));
		userRepository.saveAll(users);
		
		List<Post> posts = new ArrayList<>();
		posts.add(new Post(null, sdf.parse("21/03/2018"), "Aprendendo Java", "Aprenda Java rapidamente", new AuthorDTO(users.get(2))));
		posts.add(new Post(null, new Date(), "Aprendendo PHP", "Aprenda PHP rapidamente", new AuthorDTO(users.get(2))));
		
		postRepository.saveAll(posts);
		
		users.get(2).getPosts().addAll(posts);
		userRepository.save(users.get(2));
	}
}
