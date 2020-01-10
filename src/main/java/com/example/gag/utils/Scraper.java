package com.example.gag.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.gag.model.Post;
import com.google.gson.Gson;

@Component
public class Scraper {

	public List<Post> getBody() {
		String uri = "https://9gag.com/v1/group-posts/group/default/type/hot?fbclid=IwAR0p_XoSZOgwm51s7I1d72KX4_x8CQ3b8UGTL1XreKzpU5-rbTQNfgLOBRw";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>("body");
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		String post = result.getBody();
		post = post.split("data")[1];
		post = post.substring(11, post.length() - 1);
		post = post.split("featuredAds")[0];
		post = post.substring(0, post.length() - 2);

//		post = post.split("\"id\"")[2];
//		post = "{\"id\"" + post.substring(0, post.length() - 2);
//		Gson gson = new Gson();
//		Post object = gson.fromJson(post, Post.class);
//		
//		String imgUrl = post.split("\"url\"")[2];
//		imgUrl = imgUrl.split("\"")[1];
//
//		object.setImageUrl(imgUrl);
//		System.out.println(object.toString());

		List<Post> actualPosts = new ArrayList<>();
		String[] posts = post.split("\"id\"");

		for (int i = 1; i < posts.length - 1; i++) {
			System.out.println("AAAAAAA");
			posts[i] = "{\"id\"" + posts[i].substring(0, posts[i].length() - 2);

			Gson gson = new Gson();
			Post object = gson.fromJson(posts[i], Post.class);
			
			String imgUrl = posts[i].split("\"url\"")[2];
			imgUrl = imgUrl.split("\"")[1];

			object.setImageUrl(imgUrl);
			
			actualPosts.add(object);
			System.out.println(object.toString());
		}

		return actualPosts;
	}
}
