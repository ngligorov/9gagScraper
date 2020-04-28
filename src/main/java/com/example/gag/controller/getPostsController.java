package com.example.gag.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gag.model.ActualPost;
import com.example.gag.model.Post;
import com.example.gag.service.ActualPostService;
import com.example.gag.utils.Scraper;

@RestController
@RequestMapping(value = "/api/rest/post")
public class getPostsController {

	@Autowired
	ActualPostService service;
	
	@Autowired
	Scraper scraper;

	@RequestMapping(value = "/body", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<?> scrapeBody() throws IOException {

		List<Post> posts = scraper.getPosts("fbclid=IwAR2OQoU7pP-icBn1DF3VQy39i5OugFq2sYyGgxWYhVU3SQ8aUTHT6YASg-0");

		System.out.println(posts.size());

//		for (Post post : posts)
//			service.save(new ActualPost(post));

		return ResponseEntity.ok(posts);
	}
}
