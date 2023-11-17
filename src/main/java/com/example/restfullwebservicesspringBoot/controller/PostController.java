package com.example.restfullwebservicesspringBoot.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restfullwebservicesspringBoot.model.Post;
import com.example.restfullwebservicesspringBoot.model.User;
import com.example.restfullwebservicesspringBoot.service.PostService;

import jakarta.validation.Valid;

@RestController
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}



	@PostMapping(path = "jpa/users/{id}/posts")
	public ResponseEntity<User> createUser(@PathVariable Integer id,  @Valid @RequestBody Post post) {
		
		User userData =  postService.createPost(id, post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userData.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	

}
