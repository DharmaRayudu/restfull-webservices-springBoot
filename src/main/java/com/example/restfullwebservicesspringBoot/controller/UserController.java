package com.example.restfullwebservicesspringBoot.controller;


import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.hibernate.sql.results.jdbc.internal.JdbcValuesResultSetImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restfullwebservicesspringBoot.model.Post;
import com.example.restfullwebservicesspringBoot.model.User;
import com.example.restfullwebservicesspringBoot.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@GetMapping(path = "/users")
//	public ResponseEntity<List<User>> getAllUsers(){
//		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK) ;
//	}
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers() ;
	}
	//, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
	
	//EntityModel
	//WebMVCLinkBuilder
	
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> getUserById(@PathVariable Integer id) {
		
		User user =  userService.findById(id);
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		 return entityModel;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User userData =  userService.createUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(userData.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteByUserId(@PathVariable Integer id) {
		userService.deleteUserById(id);
		
	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> getPostsByUser(@PathVariable Integer id) {
		return userService.getPostsByUser(id);
	}
}
