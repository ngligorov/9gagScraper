package com.example.gag.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.gag.model.ActualPost;
import com.example.gag.model.Post;
import com.example.gag.model.TagsInfo;
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

	@RequestMapping(value = "/tags", method = RequestMethod.GET, produces = "application/json")
	private ResponseEntity<?> tagsCount() throws IOException {

		TagsInfo tagsInfo = new TagsInfo();

		List<ActualPost> posts = service.findAll();

		// kljuc je broj tagova, vrednost je broj postova koji imaju toliko tagova
		Map<Integer, Integer> tagsPostRatio = new HashMap<>();

		for (ActualPost post : posts) {
			int tagNo = post.getTags().size();

			if (tagsPostRatio.containsKey(tagNo))
				tagsPostRatio.put(tagNo, tagsPostRatio.get(tagNo) + 1);
			else
				tagsPostRatio.put(tagNo, 1);
		}

		tagsInfo.setTagsPostRatio(tagsPostRatio);

		// <tagNo, <srednja vrednost upvote, srednja vrednost downvote>>
		Map<Integer, Map<Float, Float>> tagUpvoteDownvoteRatio = new HashMap<>();
		// <tagNo, srednja vrednost broja komentara>
		Map<Integer, Float> tagCommentRatio = new HashMap<>();

		for (int i = 0; i <= 8; i++) {
			int upvoteCount = 0;
			int downvoteCount = 0;
			int commentCount = 0;
			int postsCount = 0;

			for (ActualPost post : posts)
				if (post.getTags().size() == i) {
					upvoteCount += post.getUpVoteCount();
					downvoteCount += post.getDownVoteCount();
					commentCount += post.getCommentsCount();
					postsCount++;
				}

			Map<Float, Float> upwoteDownwote = new HashMap<>();
			upwoteDownwote.put((float) upvoteCount / postsCount, (float) downvoteCount / postsCount);

			tagUpvoteDownvoteRatio.put(i, upwoteDownwote);
			tagCommentRatio.put(i, (float) commentCount / postsCount);
		}

		tagsInfo.setTagUpwoteDownoteRatio(tagUpvoteDownvoteRatio);
		tagsInfo.setTagCommentRatio(tagCommentRatio);

		// <ima/nema, <srednja vrednost upvote, srednja vrednost downvote>>
		Map<String, Map<Float, Float>> noTagHasTagUpvoteRatio = new HashMap<>();
		// <ima/nema, srednja vrednost broja komentara>
		Map<String, Float> noTagHasTagCommentRatio = new HashMap<>();

		int noTagPostCount = 0;
		int noTagUpvoteCount = 0;
		int noTagDownvoteCount = 0;
		int noTagCommentCount = 0;
		int hasTagPostCount = 0;
		int hasTagsUpvoteCount = 0;
		int hasTagsDownVoteCount = 0;
		int hasTagsCommentCount = 0;

		for (ActualPost post : posts)
			if (post.getTags().size() == 0) {
				noTagUpvoteCount += post.getUpVoteCount();
				noTagDownvoteCount += post.getDownVoteCount();
				noTagCommentCount += post.getCommentsCount();

				noTagPostCount++;
			} else {
				hasTagsUpvoteCount += post.getUpVoteCount();
				hasTagsDownVoteCount += post.getDownVoteCount();
				hasTagsCommentCount += post.getCommentsCount();

				hasTagPostCount++;
			}

		Map<Float, Float> upvoteDownvoteRatioNoTags = new HashMap<>();
		upvoteDownvoteRatioNoTags.put((float) noTagUpvoteCount / noTagPostCount,
				(float) noTagDownvoteCount / noTagPostCount);

		Map<Float, Float> upvoteDownvoteRatioHasTags = new HashMap<>();
		upvoteDownvoteRatioHasTags.put((float) hasTagsUpvoteCount / hasTagPostCount,
				(float) hasTagsDownVoteCount / hasTagPostCount);

		noTagHasTagUpvoteRatio.put("no tags", upvoteDownvoteRatioNoTags);
		noTagHasTagUpvoteRatio.put("has tags", upvoteDownvoteRatioHasTags);
		noTagHasTagCommentRatio.put("no tags", (float) noTagCommentCount / noTagPostCount);
		noTagHasTagCommentRatio.put("has tags", (float) hasTagsCommentCount / hasTagPostCount);
		
		tagsInfo.setNoTagHasTagUpvoteRatio(noTagHasTagUpvoteRatio);
		tagsInfo.setNoTagHasTagCommentRatio(noTagHasTagCommentRatio);

		return ResponseEntity.ok(tagsInfo);
	}
}
