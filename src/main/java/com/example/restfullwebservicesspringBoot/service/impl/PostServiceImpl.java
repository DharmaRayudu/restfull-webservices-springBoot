package com.example.restfullwebservicesspringBoot.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.restfullwebservicesspringBoot.exception.UserNotFoundException;
import com.example.restfullwebservicesspringBoot.model.Post;
import com.example.restfullwebservicesspringBoot.model.User;
import com.example.restfullwebservicesspringBoot.repository.PostRepository;
import com.example.restfullwebservicesspringBoot.repository.UserRepository;
import com.example.restfullwebservicesspringBoot.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	private PostRepository postRepository;
	
	private UserRepository userRepository;

	public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
		super();
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}



	@Override
	public User createPost(Integer userId, Post post) {
		
		 Optional<User> user =  userRepository.findById(userId);
		 
		 if(user.isEmpty()) {
				System.out.println("is user null");
				throw new UserNotFoundException("No user exites with  Id:"+ userId);
			}
			User userData =  user.get();
		 post.setUser(userData);
		 
		postRepository.save(post);
		
		return user.get();
		
	}

}
