package com.example.gag.model;

import java.util.HashMap;
import java.util.Map;

public class TagsInfo {

	private Map<Integer, Integer> tagsPostRatio = new HashMap<>();
	private Map<Integer, Map<Float, Float>> tagUpwoteDownoteRatio = new HashMap<>();
	private Map<Integer, Float> tagCommentRatio = new HashMap<>();
	private Map<String, Map<Float, Float>> noTagHasTagUpvoteRatio = new HashMap<>();
	private Map<String, Float> noTagHasTagCommentRatio = new HashMap<>();

	public TagsInfo() {
		super();
	}

	public Map<Integer, Integer> getTagsPostRatio() {
		return tagsPostRatio;
	}

	public void setTagsPostRatio(Map<Integer, Integer> tagsPostRatio) {
		this.tagsPostRatio = tagsPostRatio;
	}

	public Map<Integer, Map<Float, Float>> getTagUpwoteDownoteRatio() {
		return tagUpwoteDownoteRatio;
	}

	public void setTagUpwoteDownoteRatio(Map<Integer, Map<Float, Float>> tagUpwoteDownoteRatio) {
		this.tagUpwoteDownoteRatio = tagUpwoteDownoteRatio;
	}

	public Map<Integer, Float> getTagCommentRatio() {
		return tagCommentRatio;
	}

	public void setTagCommentRatio(Map<Integer, Float> tagCommentRatio) {
		this.tagCommentRatio = tagCommentRatio;
	}

	public Map<String, Map<Float, Float>> getNoTagHasTagUpvoteRatio() {
		return noTagHasTagUpvoteRatio;
	}

	public void setNoTagHasTagUpvoteRatio(Map<String, Map<Float, Float>> noTagHasTagUpvoteRatio) {
		this.noTagHasTagUpvoteRatio = noTagHasTagUpvoteRatio;
	}

	public Map<String, Float> getNoTagHasTagCommentRatio() {
		return noTagHasTagCommentRatio;
	}

	public void setNoTagHasTagCommentRatio(Map<String, Float> noTagHasTagCommentRatio) {
		this.noTagHasTagCommentRatio = noTagHasTagCommentRatio;
	}

}
