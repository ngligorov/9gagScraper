package com.example.gag.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

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
	@OneToOne
	private PostSection postSection;
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Tag> tags = null;
	private String descriptionHtml;

	public Post() {

	}

	public Post(String id, String url, String title, String type, Integer nsfw, Integer upVoteCount,
			Integer downVoteCount, Integer creationTs, Integer promoted, Integer isVoteMasked, String imageUrl,
			String sourceDomain, String sourceUrl, Integer commentsCount, PostSection postSection, List<Tag> tags,
			String descriptionHtml) {
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
		this.postSection = postSection;
		this.tags = tags;
		this.descriptionHtml = descriptionHtml;
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

	public PostSection getPostSection() {
		return postSection;
	}

	public void setPostSection(PostSection postSection) {
		this.postSection = postSection;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public String getDescriptionHtml() {
		return descriptionHtml;
	}

	public void setDescriptionHtml(String descriptionHtml) {
		this.descriptionHtml = descriptionHtml;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", url=" + url + ", title=" + title + ", type=" + type + ", nsfw=" + nsfw
				+ ", upVoteCount=" + upVoteCount + ", downVoteCount=" + downVoteCount + ", creationTs=" + creationTs
				+ ", promoted=" + promoted + ", isVoteMasked=" + isVoteMasked + ", imageUrl=" + imageUrl
				+ ", sourceDomain=" + sourceDomain + ", sourceUrl=" + sourceUrl + ", commentsCount=" + commentsCount
				+ ", postSection=" + postSection + ", tags=" + tags + ", descriptionHtml=" + descriptionHtml + "]";
	}

}
