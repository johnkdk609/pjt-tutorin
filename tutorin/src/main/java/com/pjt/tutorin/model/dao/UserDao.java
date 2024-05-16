package com.pjt.tutorin.model.dao;

import java.util.List;

import com.pjt.tutorin.model.dto.SearchCondition;
import com.pjt.tutorin.model.dto.User;

public interface UserDao {

	// 전체 사용자 조회
	public List<User> selectAll();
	
	// ID에 해당하는 사용자 한 명 정보 가져오기
	public User selectOne(String id);
	
	// 사용자 등록
	public int insertUser(User user);
	
	// 사용자 삭제
	public int deleteUser(String id);
	
	// 사용자 수정
	public int updateUser(User user);
	
	// 사용자 검색
	public List<User> searchUser(SearchCondition condition);

	// 회원가입
	public int regist(User user);

	// 로그인
	public User login(User user);
	
}
