package com.pjt.tutorin.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.pjt.tutorin.annotation.AuthRequired;
import com.pjt.tutorin.util.JwtUtil;

import io.swagger.v3.oas.models.PathItem.HttpMethod;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
//	private final String HEADER_AUTH = "access-token";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		
		// FrontEnd에서 HTTP 요청이 올 때
		// Authorization이라는 헤더에 AccessToken을 같이 넘겨줘야 유효한 요청으로 보겠다. 
		
		// 요청이 로그인으로 왔다면 (토큰 없이 오는 곳) 허용해줘야 함 
		// 요청이 POST 이면서 /user/login으로 요청이 왔다면 그것은 그냥 허용해줘야 함... 
		System.out.println(request.getMethod());
		if (request.getMethod().equals("OPTIONS")) {
			return true;
		}
		
		
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		
		HandlerMethod method = (HandlerMethod) handler;
		
		// @AuthRequired가 붙어있는 메서드라면 
		if (method.getMethodAnnotation(AuthRequired.class) != null) {
			
			// 그 외 나머지 요청 (토큰이 있는 상태로 와야) 
			
			// request 객체에서 요청 헤더를 꺼내서 확인. 
			String accessToken = request.getHeader("Authorization");
			System.out.println(accessToken);
			
			if (accessToken != null) {
				if (jwtUtil.validCheck(accessToken)) {	// 유효한 토큰이라면 
					System.out.println("interceptor: valid");
					return true;	// 요청을 계속 진행. 
				}
			}
			
			System.out.println("interceptor: invalid");
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false;	// 요청을 중지.
			
		}
		
		return true;	// @AuthRequired가 붙어있지 않다면 그냥 통과 
		
	}
	
}
