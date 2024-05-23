package com.pjt.tutorin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pjt.tutorin.model.dao.CounselDao;
import com.pjt.tutorin.model.dto.Counsel;

@Service
public class CounselServiceImpl implements CounselService {

	private final CounselDao counselDao;

	// 없어도 되지만 확인용
	@Autowired
	public CounselServiceImpl(CounselDao counselDao) {
		this.counselDao = counselDao;
	}

	@Override
	public List<Counsel> counselList() {
		return counselDao.getCounsels();
	}

	@Override
	public Counsel counselInfo(int id) {
		return counselDao.selectCounsel(id);
	}

	@Transactional
	@Override
	public boolean createCounsel(Counsel counsel) {
		return counselDao.insertCounsel(counsel) == 1;
	}

	@Transactional
	@Override
	public boolean deleteCounsel(int id) {
		return counselDao.deleteCounsel(id) == 1;
	}

//	@Transactional
//	@Override
//	public boolean updateCounsel(Counsel counsel) {
//		return counselDao.upCounsel(counsel) == 1;
//	}

	@Transactional
	@Override
	public boolean updateAccept(Counsel counsel) {
		return counselDao.acceptCounsel(counsel) == 1;
	}

	@Transactional
	@Override
	public boolean updateAnswer(Counsel counsel) {
		return counselDao.answerCounsel(counsel) == 1;
	}

	@Transactional
	@Override
	public boolean updateFeedbackQ(Counsel counsel) {
		return counselDao.feedbackQuestionCounsel(counsel) == 1;
	}

	@Override
	public boolean updateFeedbackA(Counsel counsel) {
		return counselDao.feedbackAnswerCounsel(counsel) == 1;
	}

	@Override
	public boolean updateReview(Counsel counsel) {
		return counselDao.reviewCounsel(counsel) == 1;
	}

	@Override
	public boolean updateStatus(Counsel counsel) {
		return counselDao.updateStatusCounsel(counsel) == 1;
	}

	@Override
	public boolean secession(String id) {
		return counselDao.secession(id) == 1;
	}
	
	@Override
	public boolean secession2(String id) {
		return counselDao.secession2(id) == 1;
	}

}
