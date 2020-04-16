package com.example.gag.model;

public class Preferences {

	private float hideProBadge;
	private float hideActiveTs;
	private String accentColor;
	private String backgroundColor;

	public Preferences(float hideProBadge, float hideActiveTs, String accentColor, String backgroundColor) {
		super();
		this.hideProBadge = hideProBadge;
		this.hideActiveTs = hideActiveTs;
		this.accentColor = accentColor;
		this.backgroundColor = backgroundColor;
	}

	public float getHideProBadge() {
		return hideProBadge;
	}

	public void setHideProBadge(float hideProBadge) {
		this.hideProBadge = hideProBadge;
	}

	public float getHideActiveTs() {
		return hideActiveTs;
	}

	public void setHideActiveTs(float hideActiveTs) {
		this.hideActiveTs = hideActiveTs;
	}

	public String getAccentColor() {
		return accentColor;
	}

	public void setAccentColor(String accentColor) {
		this.accentColor = accentColor;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
