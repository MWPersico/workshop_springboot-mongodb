package com.marcprojects.workshopmongo.controllers;

import java.util.Date;
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
	public ResponseEntity<List<PostDTO>> findAll(){
		List<PostDTO> posts = service.findAll();
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(params = "title")
	public ResponseEntity<List<PostDTO>> find(@RequestParam("title") String titleSearch){
		List<PostDTO> posts = service.findByTitleContaining(URLHandler.decodeURLParameter(titleSearch));
		return ResponseEntity.ok().body(posts);
	}
	
	// Busca com multiplos parâmetros 'posts?text&minDate&maxDate'
	@GetMapping(params = {"text", "minDate", "maxDate"})
	public ResponseEntity<List<PostDTO>> findByTextInInterval(
			@RequestParam(value="text",defaultValue="", required=false) String text, 
			@RequestParam(value="minDate",defaultValue="", required=false) String minDate, 
			@RequestParam(value="maxDate",defaultValue="", required=false) String maxDate
	){
		List<PostDTO> posts = service.searchWithTextInRange(
			URLHandler.decodeURLParameter(text),
			URLHandler.decodeDate(minDate, new Date(0L)),
			URLHandler.decodeDate(maxDate, new Date())
		);
		return ResponseEntity.ok().body(posts);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id){
		return ResponseEntity.ok().body(service.findById(id));
	}
}
