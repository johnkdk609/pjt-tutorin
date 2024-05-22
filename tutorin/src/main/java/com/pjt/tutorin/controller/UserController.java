package com.pjt.tutorin.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjt.tutorin.annotation.AuthRequired;
import com.pjt.tutorin.model.dto.SearchCondition;
import com.pjt.tutorin.model.dto.User;
import com.pjt.tutorin.model.service.UserService;
import com.pjt.tutorin.util.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
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
	@Operation(summary = "사용자 상세 조회", description = "사용자를 상세 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<?> detail(@PathVariable String id) {
		User user = userService.readUser(id);
		return new ResponseEntity<>(user, user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	
	
	/*
	 * 사용자 등록
	 */
//	@Operation(summary = "사용자 등록", description = "사용자를 등록합니다.")
//	@PostMapping("")
//	public ResponseEntity<?> create(User user) {
//		int result = userService.writeUser(user);
//		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);		
//	}
//	
	
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
	
	
	/*
	 * Refrest-Token을 이용한 로그인 최종 구현
	 */
	@Value("${jwt.refreshtoken.expiretime}")
	private int refreshTokenExpireTime;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println("loginHandler");
		System.out.println(user);
		Map<String, Object> result = new HashMap<>();
		
		// DB에서 유저 가져오기
		User dbUser = userService.loginUser(user);
		
		// 일치하는 유저가 없다면 UNAUTHORIZED 반환.
		if(dbUser == null) {
			result.put("message", "일치하는 유저가 없습니다.");
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.UNAUTHORIZED);
		}
		
		// 있으면 Token 발급
		// AccessToken, RefreshToken 두 개를 발급해준다.
		String accessToken = jwt.createAccessToken(dbUser.getId());
		String refreshToken = jwt.createRefreshToken(dbUser.getId());
		
		Cookie cookie = new Cookie("refreshToken", refreshToken);
		cookie.setMaxAge(refreshTokenExpireTime);
		cookie.setHttpOnly(true);
		cookie.setPath("/");
		response.addCookie(cookie);
		
		result.put("accessToken", accessToken);
		result.put("id", dbUser.getId());
		result.put("password", dbUser.getPassword());
		result.put("email", dbUser.getEmail());
		result.put("name", dbUser.getName());
		result.put("nickname", dbUser.getNickname());
		result.put("phoneNum", dbUser.getPhoneNum());
		result.put("image", dbUser.getImage());
		result.put("menteeIntro", dbUser.getMenteeIntro());
		result.put("status", dbUser.getStatus());
		result.put("createTime", dbUser.getCreateTime());
		
		
		
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
		
		
	@AuthRequired // 토큰이 있어야지만 접근 가능한 메서드.
	@GetMapping("/mypage")
	ResponseEntity<?> mypage(HttpServletRequest request) throws ParseException{
		String accessToken = request.getHeader("Authorization");
		String userId = jwt.getUserId(accessToken);
		
		return new ResponseEntity<String>(userId, HttpStatus.OK);
	}
		
	@GetMapping("/refresh")
	ResponseEntity<?> refreshToken(){
				
		return null;
	}
	
	
}
