package com.example.gag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gag.model.ActualPost;
import com.example.gag.repository.ActualPostRepository;

@Service
public class ActualPostService {

	@Autowired
	ActualPostRepository repository;

	public ActualPost save(ActualPost post) {
		return repository.save(post);
	}

	public List<ActualPost> findAll(){
		return repository.findAll();
	}
}
