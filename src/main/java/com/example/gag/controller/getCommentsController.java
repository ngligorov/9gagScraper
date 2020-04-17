package com.example.gag.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		for (ActualPost post : postService.findAll())
			scraper.getComments(post.getId());

		return ResponseEntity.ok("profi");
	}

	@RequestMapping(value = "/continue", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<?> scrapeBodyContinue() throws IOException {

		List<String> uncommentedPostIDs = new ArrayList<>();

		for (Comment comment : service.findAll()) {
			String postId = comment.getPermalink().split("/")[comment.getPermalink().split("/").length - 1];
			postId = postId.split("#")[0];

			uncommentedPostIDs.add(postId);
		}

		for (ActualPost post : postService.findAll())
			if (!uncommentedPostIDs.contains(post.getId()))
				scraper.getComments(post.getId());

		return ResponseEntity.ok("profi");
	}

	@RequestMapping(value = "/govno", method = RequestMethod.POST, produces = "application/json")
	private ResponseEntity<?> fixDamnComment(@RequestBody String brokenJson) throws IOException {

		return ResponseEntity.ok(scraper.fixBrokenJson(brokenJson));
	}
}
