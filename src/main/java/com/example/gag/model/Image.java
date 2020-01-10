package com.example.gag.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Integer width;
	private Integer height;
	private String url;
	private String webpUrl;
	@ManyToOne
	private Post post;

	public Image() {
		super();
	}

	public Image(int id, Integer width, Integer height, String url, String webpUrl, Post post) {
		super();
		this.id = id;
		this.width = width;
		this.height = height;
		this.url = url;
		this.webpUrl = webpUrl;
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWebpUrl() {
		return webpUrl;
	}

	public void setWebpUrl(String webpUrl) {
		this.webpUrl = webpUrl;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
