package com.marcprojects.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

import com.marcprojects.workshopmongo.entities.Post;

public record PostDTO(String id, Date date, String title, String body, AuthorDTO author) implements Serializable{
	private static final long serialVersionUID = 1l;
	
	public PostDTO(Post post) {
		this(post.getId(), post.getDate(), post.getTitle(), post.getBody(), post.getAuthor());
	}
}
