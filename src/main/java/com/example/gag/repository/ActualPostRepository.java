package com.example.gag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gag.model.ActualPost;

public interface ActualPostRepository extends  JpaRepository<ActualPost, Integer>{

	List<ActualPost> findAll();
}
