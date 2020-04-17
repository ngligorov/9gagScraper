package com.example.gag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gag.model.Comment;
import com.example.gag.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository repository;

	public Comment save(Comment comment) {
		return repository.save(comment);
	}

	public List<Comment> findAll() {
		return repository.findAll();
	}
}
