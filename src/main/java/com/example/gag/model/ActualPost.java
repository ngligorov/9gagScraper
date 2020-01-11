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

	public ActualPost() {

	}

	public ActualPost(String id, String url, String title, String type, Integer nsfw, Integer upVoteCount,
			Integer downVoteCount, Integer creationTs, Integer promoted, Integer isVoteMasked, String imageUrl,
			String sourceDomain, String sourceUrl, Integer commentsCount) {
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
	}

	public ActualPost(Post post) {
		this(post.getId(), post.getUrl(), post.getTitle(), post.getType(), post.getNsfw(), post.getUpVoteCount(),
				post.getDownVoteCount(), post.getCreationTs(), post.getPromoted(), post.getIsVoteMasked(),
				post.getImageUrl(), post.getSourceDomain(), post.getSourceUrl(), post.getCommentsCount());
	}
}
