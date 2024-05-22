package com.pjt.tutorin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt.tutorin.model.dao.MentorDao;
import com.pjt.tutorin.model.dto.Mentor;

@Service
public class MentorServiceImpl implements MentorService {

	@Autowired
	private MentorDao mentorDao;
	
	@Override
	public List<Mentor> getMentorList() {
		return mentorDao.selectAll();
	}

	@Override
	public Mentor readMentor(String id) {
		return mentorDao.selectOne(id);
	}

	@Override
	public int insertMentor(Mentor mentor) {
		return mentorDao.insertMentor(mentor);
	}

	@Override
	public int modifyMentor(Mentor mentor) {
		return mentorDao.updateMentor(mentor);
	}

	@Override
	public int removeMentor(String id) {
		return mentorDao.deleteMentor(id);
	}

	
}
