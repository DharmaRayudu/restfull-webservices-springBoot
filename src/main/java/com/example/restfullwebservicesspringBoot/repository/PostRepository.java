package com.example.restfullwebservicesspringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restfullwebservicesspringBoot.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
