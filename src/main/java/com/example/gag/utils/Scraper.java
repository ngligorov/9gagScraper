package com.example.gag.utils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.example.gag.model.ActualPost;
import com.example.gag.model.Comment;
import com.example.gag.model.Post;
import com.example.gag.service.ActualPostService;
import com.example.gag.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.MalformedJsonException;

@Component
public class Scraper {

	@Autowired
	ActualPostService service;

	@Autowired
	CommentService commentService;

	public List<Post> getPosts(String startUrl) throws IOException {
		String firstPartUrl = "https://9gag.com/v1/group-posts/group/default/type/hot?";
		List<Post> actualPosts = new ArrayList<>();
		String secondPartUrl = "";

		for (int j = 0; j <= 2000; j++) {
			try {
				Document document = Jsoup.connect(firstPartUrl + secondPartUrl).ignoreContentType(true)
						.userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
						.ignoreHttpErrors(true).referrer("www.google.com").get();
				String post = document.body().wholeText();
				post = post.split("data")[1];
				post = post.substring(11, post.length() - 1);
				post = post.split("featuredAds")[0];
				post = post.substring(0, post.length() - 2);

				String[] posts = post.split("\"id\"");

				for (int i = 1; i <= posts.length - 2; i++) {
					posts[i] = "{\"id\"" + posts[i].substring(0, posts[i].length() - 2);

					Gson gson = new Gson();
					Post object = gson.fromJson(posts[i], Post.class);

					String imgUrl = posts[i].split("\"url\"")[2];
					imgUrl = imgUrl.split("\"")[1];

					object.setImageUrl(imgUrl);

					service.save(new ActualPost(object));
					actualPosts.add(object);
				}

				String nextCursor = document.body().wholeText().split("\"nextCursor\"")[1];
				secondPartUrl = nextCursor.split("\"")[1];
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return actualPosts;
	}

	public int getComments(String postId) throws IOException {
		String firstPartUrl = "https://comment-cdn.9gag.com/v1/cacheable/comment-list.json?appId=a_dd8f2b7d304a10edaf6f29517ea0ca4100a43d1b&url=http:%2F%2F9gag.com%2Fgag%2F";
		String secondPartUrl = postId;
		String fourthPartUrl = "";
		String thirdPartUrl = "&count=10000000000&order=score&" + fourthPartUrl + "origin=https:%2F%2F9gag.com";;
		Gson gson = new Gson();
		String comment = "";
		boolean hasNext = true;

		try {
			Document document = Jsoup.connect(firstPartUrl + secondPartUrl + thirdPartUrl).ignoreContentType(true)
					.userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
					.ignoreHttpErrors(true).referrer("www.google.com").get();

			comment = document.body().wholeText();
			String hasNextString = comment.split("\"hasNext\":")[1];
			if(hasNextString.equals("true")) {
				hasNext = true;
			} else {
				hasNext = false;
			}
			comment = comment.split("\"comments\":")[1];
			comment = comment.substring(0, comment.length() - 2);

			List<Object> comments = new ArrayList<>();

			comments = gson.fromJson(comment, comments.getClass());

			for (int i = 0; i < comments.size(); i++) {
				Comment com = gson.fromJson(gson.toJson(comments.get(i)), Comment.class);
				commentService.save(com);
				if(i == comments.size()-1) {
					fourthPartUrl = "ref=" + com.getOrderKey() + "&";
				}
			}

			if(!hasNext) {
				fourthPartUrl = "";
			}

			return comments.size();

		} catch (Exception e) {
			comment = fixBrokenJson(comment);

			List<Object> comments = new ArrayList<>();

			comments = gson.fromJson(comment, comments.getClass());

			for (int i = 0; i < comments.size(); i++) {
				Comment com = gson.fromJson(gson.toJson(comments.get(i)), Comment.class);
				commentService.save(com);
			}
		}

		return 55555;
	}

	public String fixBrokenJson(String brokenJson) {

		for (String thingie : brokenJson.split(":")) {
			if (StringUtils.countOccurrencesOf(thingie, String.valueOf('"')) > 4) {
				String oldThingie;

				thingie = thingie.split(",\"")[0];
				oldThingie = new String(thingie);
				thingie = thingie.substring(1, thingie.length() - 1);
				thingie = thingie.replace("\"", "\\\"");
				thingie = '"' + thingie + '"';

				brokenJson = brokenJson.replace(oldThingie, thingie);
			}
		}
		
		List<Object> comments = new ArrayList<>();
		Gson gson = new Gson();
		
		comments = gson.fromJson(brokenJson, comments.getClass());
		System.out.println(comments.toString());

		return brokenJson;
	}
}
