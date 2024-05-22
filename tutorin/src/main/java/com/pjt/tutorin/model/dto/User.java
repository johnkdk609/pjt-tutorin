package com.pjt.tutorin.model.dto;

public class User {

	private String id;
	private String password;
	private String email;
	private String name;
	private String nickname;
	private String phoneNum;
	private String image;
	private String menteeIntro;
	private int status;
	private String createTime;
	private String updateTime;
	private String accessToken;		// JWT 토큰
	
	public User() {}

	public User(String id, String password, String email, String name, String nickname, String phoneNum) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.phoneNum = phoneNum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMenteeIntro() {
		return menteeIntro;
	}

	public void setMenteeIntro(String menteeIntro) {
		this.menteeIntro = menteeIntro;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", nickname="
				+ nickname + ", phoneNum=" + phoneNum + ", image=" + image + ", menteeIntro=" + menteeIntro
				+ ", status=" + status + ", createTime=" + createTime + ", updateTime=" + updateTime + ", accessToken="
				+ accessToken + "]";
	}
	
}
