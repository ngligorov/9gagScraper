package com.example.gag.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actual_post")
public class ActualPost {

	@Id
	private String id;
	private String url;
	private String title;
	private String type;
	private Integer nsfw;
	private Integer upVoteCount;
	private Integer downVoteCount;
	private Integer creationTs;
	private Integer promoted;
	private Integer isVoteMasked;
	private String imageUrl;
	private String sourceDomain;
	private String sourceUrl;
	private Integer commentsCount;
	private String section;

	public ActualPost() {

	}

	public ActualPost(Post post) {
		this(post.getId(), post.getUrl(), post.getTitle(), post.getType(), post.getNsfw(), post.getUpVoteCount(),
				post.getDownVoteCount(), post.getCreationTs(), post.getPromoted(), post.getIsVoteMasked(),
				post.getImageUrl(), post.getSourceDomain(), post.getSourceUrl(), post.getCommentsCount(),
				post.getSection());
	}

	public ActualPost(String id, String url, String title, String type, Integer nsfw, Integer upVoteCount,
			Integer downVoteCount, Integer creationTs, Integer promoted, Integer isVoteMasked, String imageUrl,
			String sourceDomain, String sourceUrl, Integer commentsCount, String section) {
		super();
		this.id = id;
		this.url = url;
		this.title = title;
		this.type = type;
		this.nsfw = nsfw;
		this.upVoteCount = upVoteCount;
		this.downVoteCount = downVoteCount;
		this.creationTs = creationTs;
		this.promoted = promoted;
		this.isVoteMasked = isVoteMasked;
		this.imageUrl = imageUrl;
		this.sourceDomain = sourceDomain;
		this.sourceUrl = sourceUrl;
		this.commentsCount = commentsCount;
		this.section = section;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNsfw() {
		return nsfw;
	}

	public void setNsfw(Integer nsfw) {
		this.nsfw = nsfw;
	}

	public Integer getUpVoteCount() {
		return upVoteCount;
	}

	public void setUpVoteCount(Integer upVoteCount) {
		this.upVoteCount = upVoteCount;
	}

	public Integer getDownVoteCount() {
		return downVoteCount;
	}

	public void setDownVoteCount(Integer downVoteCount) {
		this.downVoteCount = downVoteCount;
	}

	public Integer getCreationTs() {
		return creationTs;
	}

	public void setCreationTs(Integer creationTs) {
		this.creationTs = creationTs;
	}

	public Integer getPromoted() {
		return promoted;
	}

	public void setPromoted(Integer promoted) {
		this.promoted = promoted;
	}

	public Integer getIsVoteMasked() {
		return isVoteMasked;
	}

	public void setIsVoteMasked(Integer isVoteMasked) {
		this.isVoteMasked = isVoteMasked;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSourceDomain() {
		return sourceDomain;
	}

	public void setSourceDomain(String sourceDomain) {
		this.sourceDomain = sourceDomain;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Integer getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
