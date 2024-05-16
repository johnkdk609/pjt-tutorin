package com.pjt.tutorin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjt.tutorin.model.dto.SearchCondition;
import com.pjt.tutorin.model.dto.User;
import com.pjt.tutorin.model.service.UserService;
import com.pjt.tutorin.util.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api-user")
@CrossOrigin(origins = "*")
public class UserController {

	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtUtil jwt;
	
	
	/*
	 * 사용자 전체 목록 조회 (GET /user)
	 */
	@Operation(summary = "사용자 목록 조회", description = "모든 사용자의 정보를 조회합니다.")
	@GetMapping("")
	public ResponseEntity<?> list() {
		List<User> users = userService.getUserList();
		return ResponseEntity.ok(users);
	}
	
	
	/*
	 * 사용자 상세 조회 (GET /user/{id})
	 */
	@Operation(summary = "사용자 등록", description = "사용자를 등록합니다.")
	@PostMapping("/{id}")
	public ResponseEntity<?> detail(@PathVariable String id) {
		User user = userService.readUser(id);
		return new ResponseEntity<>(user, user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	
	
	/*
	 * 사용자 등록
	 */
	@Operation(summary = "사용자 등록", description = "사용자를 등록합니다.")
	@PostMapping("")
	public ResponseEntity<?> create(User user) {
		int result = userService.writeUser(user);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);		
	}
	
	
	/*
	 * 사용자 정보 수정 (PUT /user/{id})
	 */
	@Operation(summary = "사용자 정보 수정", description = "사용자 정보를 수정합니다.")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody User updatedUser) {
		updatedUser.setId(id);
		int result = userService.modifyUser(updatedUser);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	
	/*
	 * 사용자 삭제 (DELETE /user/{id})
	 */
	@Operation(summary = "사용자 삭제", description = "사용자 정보를 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		int result = userService.removeUser(id);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
	
	
	/*
	 * 사용자 검색 (GET /user/search)
	 */
	@Operation(summary = "사용자 검색", description = "사용자를 검색합니다.")
	@GetMapping("/search")
	public ResponseEntity<?> search(@ModelAttribute SearchCondition condition) {
		List<User> users = userService.searchUser(condition);
		return ResponseEntity.ok(users);
	}
	
	
	/*
	 * 로그인
	 */
	@Operation(summary = "JWT를 이용한 로그인", description = "JWT를 이용해 로그인 합니다.")
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		User tmp = userService.login(user);
		
		if (tmp != null) {
			
			String token = jwt.createToken(user.getEmail());
			Map<String, Object> map = new HashMap<>();
			map.put("access-token", token);
			map.put("user", tmp);
			
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
	}
	
	
	/*
	 * 회원가입
	 */
	@Operation(summary = "회원가입", description = "회원가입을 합니다.")
	@PostMapping("/regist")
	public ResponseEntity<Void> signup(@RequestBody User user) {
		int result = userService.signup(user);
		if (result >= 1) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	
}
















