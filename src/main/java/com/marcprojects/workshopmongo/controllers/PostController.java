package com.marcprojects.workshopmongo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcprojects.workshopmongo.dto.PostDTO;
import com.marcprojects.workshopmongo.services.PostService;
import com.marcprojects.workshopmongo.util.URLHandler;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
	@Autowired
	PostService service;
	
	@GetMapping(value = {"/", ""})
	public ResponseEntity<List<PostDTO>> findAll(@RequestParam(value="title", required=false) String titleSearch){
		List<PostDTO> posts;
		if(titleSearch!=null) {
			posts = service.findByTitleContaining(URLHandler.decodeURLParameter(titleSearch));
		}else {
			posts = service.findAll();
		}
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id){
		return ResponseEntity.ok().body(service.findById(id));
	}
}
