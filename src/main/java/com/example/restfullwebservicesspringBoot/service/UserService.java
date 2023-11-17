package com.example.restfullwebservicesspringBoot.service;

import java.util.List;

import com.example.restfullwebservicesspringBoot.model.Post;
import com.example.restfullwebservicesspringBoot.model.User;

public interface UserService {
	
    List<User> 	getAllUsers();
    
    User findById(Integer id);
    
    User createUser(User user);
    
    void deleteUserById(Integer id);
    
    List<Post> getPostsByUser(Integer id);
    
}
