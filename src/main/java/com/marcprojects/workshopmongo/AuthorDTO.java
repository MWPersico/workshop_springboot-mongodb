package com.marcprojects.workshopmongo;

import java.io.Serializable;

import com.marcprojects.workshopmongo.entities.User;

public record AuthorDTO(String id, String name) implements Serializable{
	private static final long serialVersionUID = 1l;
	
	public AuthorDTO(User user){
		this(user.getId(),user.getName());
	}
}
