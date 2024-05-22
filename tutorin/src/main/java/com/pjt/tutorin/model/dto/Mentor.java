package com.pjt.tutorin.model.dto;

public class Mentor {
	
	private String id;
	private int status;
	private String mentorIntro;
	private String accountNum;
	private int accountFee;
	private int reviewNum;
	private float reviewGrade;
	
	public Mentor() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMentorIntro() {
		return mentorIntro;
	}

	public void setMentorIntro(String mentorIntro) {
		this.mentorIntro = mentorIntro;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public int getAccountFee() {
		return accountFee;
	}

	public void setAccountFee(int accountFee) {
		this.accountFee = accountFee;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public float getReviewGrade() {
		return reviewGrade;
	}

	public void setReviewGrade(float reviewGrade) {
		this.reviewGrade = reviewGrade;
	}

	@Override
	public String toString() {
		return "Mentor [id=" + id + ", status=" + status + ", mentorIntro=" + mentorIntro + ", accountNum=" + accountNum
				+ ", accountFee=" + accountFee + ", reviewNum=" + reviewNum + ", reviewGrade=" + reviewGrade + "]";
	}
	
	
}
