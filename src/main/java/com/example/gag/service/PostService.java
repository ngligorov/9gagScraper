package com.example.gag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gag.model.Post;
import com.example.gag.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository repository;
	
	public Post save(Post post) {
		return repository.save(post);
	}
}
