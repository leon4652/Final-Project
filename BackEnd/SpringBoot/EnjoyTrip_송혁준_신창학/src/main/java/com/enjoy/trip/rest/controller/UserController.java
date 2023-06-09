package com.enjoy.trip.rest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enjoy.trip.dto.User;
import com.enjoy.trip.service.JWTService;
import com.enjoy.trip.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private UserService userService;
	private JWTService jwtService;

	public UserController(UserService userService, JWTService jwtService) {
		this.userService = userService;
		this.jwtService = jwtService;
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody  User user) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			// user_id, user_no, is_admin 정보를 담고 있는 user 객체
			User loginUser = userService.getUser(user);
			if (loginUser != null) {
				String accessToken = jwtService.createAccessToken(loginUser);
				String refreshToken = jwtService.createRefreshToken(loginUser);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 회원 상세 정보 가져오기
	@GetMapping("/info/{userId}")
	public ResponseEntity<Map<String, Object>> getInfo(@PathVariable("userId") String userId, HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			try {
				User user = userService.getUserById(userId);
				resultMap.put("userInfo", user);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 로그아웃
	@GetMapping("/logout/{userId}")
	public ResponseEntity<?> removeToken(@PathVariable("userId") String userId) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleRefreshToken(userId);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}

	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		Map<String, Object> map = jwtService.get(token);
		if (jwtService.checkToken(token)) {
			User refreshUser = new User();
			refreshUser.setUserId((String) map.get("userId"));
			refreshUser.setUserNo(Integer.parseInt((String) map.get("userNo")));
			refreshUser.setIsAdmin(Integer.parseInt((String) map.get("isAdmin")));
			
			String accessToken = jwtService.createAccessToken(refreshUser);
			resultMap.put("access-token", accessToken);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;

		} else {
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	//아이디중복확인
	@GetMapping("checkDuplicateId/{userId}")
	public boolean checkDuplicateId(@PathVariable("userId") String userId) throws Exception {
		System.out.println(userId);
		return userService.checkDuplicateId(userId);
	}

	//회원가입
	@PostMapping("signUp")
	public ResponseEntity<?> signUp(@RequestBody User user) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (userService.signUp(user)) resultMap.put("message", SUCCESS);
		else resultMap.put("message", FAIL);
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	//비밀번호찾기
	@PostMapping("findPw")
	public User findPwByUser(@RequestBody User user) throws Exception {
		return userService.findPwByUser(user);
	}
}
