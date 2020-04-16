package com.example.gag.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gag.model.ActualPost;
import com.example.gag.model.Comment;
import com.example.gag.service.ActualPostService;
import com.example.gag.service.CommentService;
import com.example.gag.service.PostService;
import com.example.gag.utils.Scraper;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/api/rest/comment")
public class getCommentsController {

	@Autowired
	CommentService service;
	
	@Autowired
	ActualPostService postService;

	@Autowired
	Scraper scraper;

	@RequestMapping(value = "/body", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<?> scrapeBody() throws IOException {

		for(ActualPost post : postService.findAll())
			scraper.getComments(post.getId());
		
		return ResponseEntity.ok("profi");
	}
}
