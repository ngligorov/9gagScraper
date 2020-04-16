package com.example.gag.model;

public class User {

	private String userId;
	private String avatarUrl;
	private String displayName;
	private String emojiStatus;
	private String country;
	private String profileUrl;
	ProfileUrls ProfileUrlsObject;
	private String timestamp;
	Permissions PermissionsObject;
	private boolean isActivePro;
	private boolean isActiveProPlus;
	private boolean isVerifiedAccount;
	private String accountId;
	private String hashedAccountId;
	private float activeTs;
	Preferences PreferencesObject;

	public User(String userId, String avatarUrl, String displayName, String emojiStatus, String country,
			String profileUrl, ProfileUrls profileUrlsObject, String timestamp, Permissions permissionsObject,
			boolean isActivePro, boolean isActiveProPlus, boolean isVerifiedAccount, String accountId,
			String hashedAccountId, float activeTs, Preferences preferencesObject) {
		super();
		this.userId = userId;
		this.avatarUrl = avatarUrl;
		this.displayName = displayName;
		this.emojiStatus = emojiStatus;
		this.country = country;
		this.profileUrl = profileUrl;
		ProfileUrlsObject = profileUrlsObject;
		this.timestamp = timestamp;
		PermissionsObject = permissionsObject;
		this.isActivePro = isActivePro;
		this.isActiveProPlus = isActiveProPlus;
		this.isVerifiedAccount = isVerifiedAccount;
		this.accountId = accountId;
		this.hashedAccountId = hashedAccountId;
		this.activeTs = activeTs;
		PreferencesObject = preferencesObject;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmojiStatus() {
		return emojiStatus;
	}

	public void setEmojiStatus(String emojiStatus) {
		this.emojiStatus = emojiStatus;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public ProfileUrls getProfileUrlsObject() {
		return ProfileUrlsObject;
	}

	public void setProfileUrlsObject(ProfileUrls profileUrlsObject) {
		ProfileUrlsObject = profileUrlsObject;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Permissions getPermissionsObject() {
		return PermissionsObject;
	}

	public void setPermissionsObject(Permissions permissionsObject) {
		PermissionsObject = permissionsObject;
	}

	public boolean isActivePro() {
		return isActivePro;
	}

	public void setActivePro(boolean isActivePro) {
		this.isActivePro = isActivePro;
	}

	public boolean isActiveProPlus() {
		return isActiveProPlus;
	}

	public void setActiveProPlus(boolean isActiveProPlus) {
		this.isActiveProPlus = isActiveProPlus;
	}

	public boolean isVerifiedAccount() {
		return isVerifiedAccount;
	}

	public void setVerifiedAccount(boolean isVerifiedAccount) {
		this.isVerifiedAccount = isVerifiedAccount;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getHashedAccountId() {
		return hashedAccountId;
	}

	public void setHashedAccountId(String hashedAccountId) {
		this.hashedAccountId = hashedAccountId;
	}

	public float getActiveTs() {
		return activeTs;
	}

	public void setActiveTs(float activeTs) {
		this.activeTs = activeTs;
	}

	public Preferences getPreferencesObject() {
		return PreferencesObject;
	}

	public void setPreferencesObject(Preferences preferencesObject) {
		PreferencesObject = preferencesObject;
	}

}
