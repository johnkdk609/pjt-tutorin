package com.pjt.tutorin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjt.tutorin.model.dto.Mentor;
import com.pjt.tutorin.model.dto.User;
import com.pjt.tutorin.model.service.MentorService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/mentor")
public class MentorController {

	@Autowired
	MentorService mentorService;
	
	/*
	 * mentor 전체 목록 조회 (GET /mentor)
	 */
	@Operation(summary = "멘토 목록 조회", description = "모든 멘토의 정보를 조회합니다.")
	@GetMapping("")
	public ResponseEntity<?> list() {
		List<Mentor> mentors = mentorService.getMentorList();
		return ResponseEntity.ok(mentors);
	}
	
	
	/*
	 * mentor 상세 조회 (GET /mentor/{id})
	 */
	@Operation(summary = "멘토 상세 조회", description = "멘토를 상세 조회합니다.")
	@GetMapping("/{id}")
	public ResponseEntity<?> detail(@PathVariable String id) {
		Mentor mentor = mentorService.readMentor(id);
		return new ResponseEntity<>(mentor, mentor == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
	
	
	
	/*
	 * mentor 등록 (POST)
	 */
	@Operation(summary = "멘토 등록", description = "멘토를 등록합니다.")
	@PostMapping("")
	public ResponseEntity<?> create(Mentor mentor) {
		int result = mentorService.insertMentor(mentor);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);		
	}	
	
	
	/*
	 * mentor 정보 수정 (PUT /mentor/{id})
	 */
	@Operation(summary = "멘토 정보 수정", description = "멘토 정보를 수정합니다.")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody Mentor updatedMentor) {
		updatedMentor.setId(id);
		int result = mentorService.modifyMentor(updatedMentor);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}	
	
	
	/*
	 * mentor 삭제
	 */
	@Operation(summary = "멘토 자격 삭제", description = "멘토 정보를 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		int result = mentorService.removeMentor(id);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}	
	
}
