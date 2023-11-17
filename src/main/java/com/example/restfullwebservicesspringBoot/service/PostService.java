package com.example.restfullwebservicesspringBoot.service;

import com.example.restfullwebservicesspringBoot.model.Post;
import com.example.restfullwebservicesspringBoot.model.User;

public interface PostService {

	User createPost(Integer userId, Post post);
}
