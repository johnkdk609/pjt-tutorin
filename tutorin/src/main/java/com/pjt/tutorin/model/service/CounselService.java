package com.pjt.tutorin.model.service;

import java.util.List;

import com.pjt.tutorin.model.dto.Counsel;

public interface CounselService {
	// 게시글 전체 조회 
	public List<Counsel> counselList();

	// 게시글 상세조회
	public Counsel counselInfo(int id);

	// 게시글 작성
	public boolean createCounsel(Counsel counsel);

	/// 게시글 삭제
	public boolean deleteCounsel(int id);

	// 게시글 수정
//	public boolean updateCounsel(Counsel counsel);

	public boolean updateAccept(Counsel counsel);

	public boolean updateAnswer(Counsel counsel);

	public boolean updateFeedbackQ(Counsel counsel);

	public boolean updateFeedbackA(Counsel counsel);

	public boolean updateReview(Counsel counsel);

	public boolean updateStatus(Counsel counsel);
}
