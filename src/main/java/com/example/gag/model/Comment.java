package com.example.gag.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@Column(name = "id")
	private String commentId;
	private float status;
	private String parent;
	private String userId;
	@Column(length = Integer.MAX_VALUE)
	private String text;
	private float timestamp;
	@Transient
	MentionMapping MentionMappingObject;
	@Transient
	EmbedMediaMeta EmbedMediaMetaObject;
	private String type;
	private String threadId;
	@Transient
	ArrayList<Object> media = new ArrayList<Object>();
	private String permalink;
	private float level;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "comment_children")
	List<Comment> children = new ArrayList<Comment>();
	private String orderKey;
	private float isVoteMasked;
	@Column(length = Integer.MAX_VALUE)
	private String mediaText;
	@Column(length = Integer.MAX_VALUE)
	private String richtext;
	@Transient
	User UserObject;
	private float likeCount;
	private float dislikeCount;
	private float coinCount;
	@Transient
	IsLike IsLikeObject;
	private String section;
	private float isCollapsed;
	private float isPinned;
	private float childrenTotal;
	private boolean hasNext;
	private float isAnonymous;
	private float isUrl;
	@Transient
	SuppData SuppDataObject;

	public Comment() {

	}

	public Comment(String commentId, float status, String parent, String userId, String text, float timestamp,
			MentionMapping mentionMappingObject, EmbedMediaMeta embedMediaMetaObject, String type, String threadId,
			ArrayList<Object> media, String permalink, float level, List<Comment> children, String orderKey,
			float isVoteMasked, String mediaText, String richtext, User userObject, float likeCount, float dislikeCount,
			float coinCount, IsLike isLikeObject, String section, float isCollapsed, float isPinned,
			float childrenTotal, boolean hasNext, float isAnonymous, float isUrl, SuppData suppDataObject) {
		super();
		this.commentId = commentId;
		this.status = status;
		this.parent = parent;
		this.userId = userId;
		this.text = text;
		this.timestamp = timestamp;
		MentionMappingObject = mentionMappingObject;
		EmbedMediaMetaObject = embedMediaMetaObject;
		this.type = type;
		this.threadId = threadId;
		this.media = media;
		this.permalink = permalink;
		this.level = level;
		this.children = children;
		this.orderKey = orderKey;
		this.isVoteMasked = isVoteMasked;
		this.mediaText = mediaText;
		this.richtext = richtext;
		UserObject = userObject;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.coinCount = coinCount;
		IsLikeObject = isLikeObject;
		this.section = section;
		this.isCollapsed = isCollapsed;
		this.isPinned = isPinned;
		this.childrenTotal = childrenTotal;
		this.hasNext = hasNext;
		this.isAnonymous = isAnonymous;
		this.isUrl = isUrl;
		SuppDataObject = suppDataObject;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public float getStatus() {
		return status;
	}

	public void setStatus(float status) {
		this.status = status;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public float getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(float timestamp) {
		this.timestamp = timestamp;
	}

	public MentionMapping getMentionMappingObject() {
		return MentionMappingObject;
	}

	public void setMentionMappingObject(MentionMapping mentionMappingObject) {
		MentionMappingObject = mentionMappingObject;
	}

	public EmbedMediaMeta getEmbedMediaMetaObject() {
		return EmbedMediaMetaObject;
	}

	public void setEmbedMediaMetaObject(EmbedMediaMeta embedMediaMetaObject) {
		EmbedMediaMetaObject = embedMediaMetaObject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public ArrayList<Object> getMedia() {
		return media;
	}

	public void setMedia(ArrayList<Object> media) {
		this.media = media;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public float getLevel() {
		return level;
	}

	public void setLevel(float level) {
		this.level = level;
	}

	public List<Comment> getChildren() {
		return children;
	}

	public void setChildren(List<Comment> children) {
		this.children = children;
	}

	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public float getIsVoteMasked() {
		return isVoteMasked;
	}

	public void setIsVoteMasked(float isVoteMasked) {
		this.isVoteMasked = isVoteMasked;
	}

	public String getMediaText() {
		return mediaText;
	}

	public void setMediaText(String mediaText) {
		this.mediaText = mediaText;
	}

	public String getRichtext() {
		return richtext;
	}

	public void setRichtext(String richtext) {
		this.richtext = richtext;
	}

	public User getUserObject() {
		return UserObject;
	}

	public void setUserObject(User userObject) {
		UserObject = userObject;
	}

	public float getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(float likeCount) {
		this.likeCount = likeCount;
	}

	public float getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(float dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public float getCoinCount() {
		return coinCount;
	}

	public void setCoinCount(float coinCount) {
		this.coinCount = coinCount;
	}

	public IsLike getIsLikeObject() {
		return IsLikeObject;
	}

	public void setIsLikeObject(IsLike isLikeObject) {
		IsLikeObject = isLikeObject;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public float getIsCollapsed() {
		return isCollapsed;
	}

	public void setIsCollapsed(float isCollapsed) {
		this.isCollapsed = isCollapsed;
	}

	public float getIsPinned() {
		return isPinned;
	}

	public void setIsPinned(float isPinned) {
		this.isPinned = isPinned;
	}

	public float getChildrenTotal() {
		return childrenTotal;
	}

	public void setChildrenTotal(float childrenTotal) {
		this.childrenTotal = childrenTotal;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public float getIsAnonymous() {
		return isAnonymous;
	}

	public void setIsAnonymous(float isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public float getIsUrl() {
		return isUrl;
	}

	public void setIsUrl(float isUrl) {
		this.isUrl = isUrl;
	}

	public SuppData getSuppDataObject() {
		return SuppDataObject;
	}

	public void setSuppDataObject(SuppData suppDataObject) {
		SuppDataObject = suppDataObject;
	}

}
