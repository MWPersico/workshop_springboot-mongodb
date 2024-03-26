package com.marcprojects.workshopmongo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User implements Serializable{
	private static final long serialVersionUID = 1l;
	
	@Id
	String id;
	String name;
	String email;
	
	@DBRef(lazy = true) // cria associações por referência (lazy = true, posts só serão carregados caso sejam acessados)
	List<Post> posts = new ArrayList<>();
	
	public User() {}

	public User(String id, String nome, String email) {
		super();
		this.id = id;
		this.name = nome;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Post> getPosts(){
		return posts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", posts=" + posts + "]";
	}
	
	
}
