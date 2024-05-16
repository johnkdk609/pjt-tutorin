package com.pjt.tutorin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pjt.tutorin.model.dao.UserDao;
import com.pjt.tutorin.model.dto.SearchCondition;
import com.pjt.tutorin.model.dto.User;
import com.pjt.tutorin.util.JwtUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public User readUser(String id) {
		return userDao.selectOne(id);
	}

	@Override
	public int writeUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public int removeUser(String id) {
		return userDao.deleteUser(id);
	}

	@Override
	public int modifyUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> searchUser(SearchCondition condition) {
		return userDao.searchUser(condition);
	}

	@Override
	public User login(User user) {
		User tmp = userDao.login(user);
		if (tmp != null) {
			tmp.setAccessToken(jwtUtil.createToken(tmp.getEmail()));
		}
		return tmp;
	}

	@Transactional
	@Override
	public int signup(User user) {
		return userDao.regist(user);
	}

}
