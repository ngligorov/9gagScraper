package com.example.gag.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class PostSection {

	private int id;
	private String name;
	private String url;
	private String imageUrl;
	private String webpUrl;

	public PostSection() {
		super();
	}

	public PostSection(int id, String name, String url, String imageUrl, String webpUrl) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.imageUrl = imageUrl;
		this.webpUrl = webpUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getWebpUrl() {
		return webpUrl;
	}

	public void setWebpUrl(String webpUrl) {
		this.webpUrl = webpUrl;
	}

}
