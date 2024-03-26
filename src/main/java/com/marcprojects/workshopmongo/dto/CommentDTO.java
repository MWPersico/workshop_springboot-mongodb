package com.marcprojects.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public record CommentDTO(String message, Date date, AuthorDTO author) implements Serializable{
	private static final long serialVersionUID = 1l;
}
