package com.example.gag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gag.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, String>{

}
