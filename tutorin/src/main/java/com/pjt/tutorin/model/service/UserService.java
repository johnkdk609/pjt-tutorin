package com.pjt.tutorin.model.service;

import java.util.List;

import com.pjt.tutorin.model.dto.SearchCondition;
import com.pjt.tutorin.model.dto.User;

public interface UserService {

	// 사용자 전체 조회
	public List<User> getUserList();
	
	// 사용자 상세 조회 (클릭 시 읽는 것)
	public User readUser(String id);
	
	// 사용자 등록
	public int writeUser(User user);
	
	// 사용자 삭제
	public int removeUser(String id);
	
	// 사용자 정보 수정
	public int modifyUser(User user);
	
	// 사용자 검색
	public List<User> searchUser(SearchCondition condition);

	// 회원가입
	public int signup(User user);
	
	// refresh-token 사용한 로그인 
	public User loginUser(User user);
}
