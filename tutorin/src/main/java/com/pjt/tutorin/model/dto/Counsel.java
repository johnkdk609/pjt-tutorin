package com.pjt.tutorin.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "상담 DTO")
public class Counsel {
	private int id;
	private String menteeId; // mybatis.configuration.map-underscore-to-camel-case=true: menteeId <- memtee_id
	private String mentorId;
	private int status;
	private String title;
	private String content;
	private String video;
	private String answerContent;
	private String answerVideo;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	private String question3;
	private String answer3;
	private int reviewStar;
	private String reviewContent;
	private String createTime;
	private String acceptTime;
	private String answerTime;
	private String feedbackTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMenteeId() {
		return menteeId;
	}
	public void setMenteeId(String menteeId) {
		this.menteeId = menteeId;
	}
	public String getMentorId() {
		return mentorId;
	}
	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerVideo() {
		return answerVideo;
	}
	public void setAnswerVideo(String answerVideo) {
		this.answerVideo = answerVideo;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public int getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}
	public String getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}
	public String getFeedbackTime() {
		return feedbackTime;
	}
	public void setFeedbackTime(String feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	@Override
	public String toString() {
		return "Counsel [id=" + id + ", menteeId=" + menteeId + ", mentorId=" + mentorId + ", status=" + status
				+ ", title=" + title + ", content=" + content + ", video=" + video + ", answerContent=" + answerContent
				+ ", answerVideo=" + answerVideo + ", question1=" + question1 + ", answer1=" + answer1 + ", question2="
				+ question2 + ", answer2=" + answer2 + ", question3=" + question3 + ", answer3=" + answer3
				+ ", reviewStar=" + reviewStar + ", reviewContent=" + reviewContent + ", createTime=" + createTime
				+ ", acceptTime=" + acceptTime + ", answerTime=" + answerTime + ", feedbackTime=" + feedbackTime + "]";
	}
	
	

	

}
