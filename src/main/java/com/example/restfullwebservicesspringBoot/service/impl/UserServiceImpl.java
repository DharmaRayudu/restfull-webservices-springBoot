package com.example.restfullwebservicesspringBoot.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfullwebservicesspringBoot.exception.UserNotFoundException;
import com.example.restfullwebservicesspringBoot.model.Post;
import com.example.restfullwebservicesspringBoot.model.User;
import com.example.restfullwebservicesspringBoot.repository.UserRepository;
import com.example.restfullwebservicesspringBoot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		LOG.info("<< UserServiceImpl getAllUsers");
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer id) {
		
		Optional<User> user =  userRepository.findById(id);
		if(user.isEmpty()) {
			System.out.println("is user null");
			throw new UserNotFoundException("No user exites with  Id:"+ id);
		}
		return user.get();
	}

	@Override
	public User createUser(User user) {
		LOG.info("<< UserServiceImpl createUser");
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public List<Post> getPostsByUser(Integer id) {
		
		Optional<User> user =  userRepository.findById(id);
		if(user.isEmpty()) {
			System.out.println("is user null");
			throw new UserNotFoundException("No user exites with  Id:"+ id);
		}
		return user.get().getPosts();
	}

}
