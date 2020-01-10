package com.example.gag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gag.model.PostSection;
import com.example.gag.repository.PostSectionRepository;

@Service
public class PostSectionService {

	@Autowired
	PostSectionRepository repository;

	public PostSection save(PostSection postSection) {
		return repository.save(postSection);
	}
}
