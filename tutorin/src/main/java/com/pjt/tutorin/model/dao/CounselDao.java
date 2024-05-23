package com.pjt.tutorin.model.dao;

import java.util.List;
import com.pjt.tutorin.model.dto.Counsel;

public interface CounselDao {
	// 게시글 전체 조회 및 검색 기능
	public List<Counsel> getCounsels();

	// 게시글 상세 조회
	public Counsel selectCounsel(int id);

	// 게시글 등록
	public int insertCounsel(Counsel counsel);

	// 게시글 삭제
	public int deleteCounsel(int id);

	// 게시글 수정
//	public int upCounsel(Counsel counsel);

	public int acceptCounsel(Counsel counsel);

	public int answerCounsel(Counsel counsel);

	public int feedbackQuestionCounsel(Counsel counsel);

	public int feedbackAnswerCounsel(Counsel counsel);

	public int reviewCounsel(Counsel counsel);

	public int updateStatusCounsel(Counsel counsel);

	public int secession(String id);
	
	public int secession2(String id);

}
