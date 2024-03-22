package com.marcprojects.workshopmongo.dto;

import java.io.Serializable;

import com.marcprojects.workshopmongo.entities.User;

public record UserDTO(String id, String name, String email) implements Serializable{
	private static final long serialVersionUID = 1l;
	
	// Construtor com entity
	public UserDTO(User user) {
		this(user.getId(),user.getName(),user.getEmail());
	}
}
