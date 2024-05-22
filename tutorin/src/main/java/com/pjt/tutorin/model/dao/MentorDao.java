package com.pjt.tutorin.model.dao;

import java.util.List;

import com.pjt.tutorin.model.dto.Mentor;

public interface MentorDao {

	// 전체 멘토 조회
	public List<Mentor> selectAll();
	
	// ID에 해당하는 멘토 한 명 정보 가져오기
	public Mentor selectOne(String id);
	
	// 멘토 등록 (자격 신청 즉시)
	public int insertMentor(String id);
	
	// 멘토 정보 수정
	public int updateMentor(Mentor mentor);
	
	// 멘토 삭제
	public int deleteMentor(String id);
	
}
