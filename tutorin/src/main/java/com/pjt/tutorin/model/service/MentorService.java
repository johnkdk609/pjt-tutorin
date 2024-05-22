package com.pjt.tutorin.model.service;

import java.util.List;

import com.pjt.tutorin.model.dto.Mentor;

public interface MentorService {

	// mentor 전체 조회
	public List<Mentor> getMentorList();
	
	// mentor 상세 조회
	public Mentor readMentor(String id);
	
	// mentor 등록 (멘토 자격 신청)
	public int insertMentor(String id);
	
	// mentor 회원정보 수정
	public int modifyMentor(Mentor mentor);
	
	// mentor 자격 삭제
	public int removeMentor(String id);
	
}
