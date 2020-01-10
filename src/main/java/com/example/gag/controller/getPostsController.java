package com.example.gag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gag.utils.Scraper;

@RestController
@RequestMapping(value = "/api/rest/post")
public class getPostsController {

	@Autowired
	Scraper scraper;
	
	@RequestMapping(value = "/body", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<?> scrapeBody() {
		return ResponseEntity.ok(scraper.getBody());
	}
}
