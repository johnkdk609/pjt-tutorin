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

import com.pjt.tutorin.model.dto.Counsel;
import com.pjt.tutorin.model.service.CounselService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/counsel")
@Tag(name = "CounselController", description = "상담 CRUD")
public class CounselController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private final CounselService counselService;

	@Autowired
	public CounselController(CounselService counselService) {
		this.counselService = counselService;
	}

	// 상담
	// @ModelAttribute: form-tag형식 이용.
	@GetMapping("")
	public ResponseEntity<?> list() {
		List<Counsel> list = counselService.counselList(); // 검색 조회
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Counsel>>(list, HttpStatus.OK);
	}

	// 상담 상세
	// @PathVariable: 값 만을 이용?
	@GetMapping("/{id}")
	public ResponseEntity<Counsel> detail(@PathVariable("id") int id) {
		Counsel counsel = counselService.counselInfo(id);
		if (counsel != null)
			return new ResponseEntity<Counsel>(counsel, HttpStatus.OK);
		return new ResponseEntity<Counsel>(HttpStatus.NOT_FOUND);
	}

	// 게시글 등록 (JSON형태로 보낸다)
	// @RequestBody: 위에거 사용, JSON을 이용함.
	@PostMapping("")
	public ResponseEntity<?> write(@RequestBody Counsel counsel) {
		counselService.createCounsel(counsel);
		return new ResponseEntity<Counsel>(counsel, HttpStatus.CREATED);
	}

	// 게시글 수정 (JSON형태로 보낸다) 경로 중요
//	@PutMapping("/board/{id}") --> PathVariable 처리와 ID 추가 작업 필요
	@PutMapping("/accept")
	public ResponseEntity<String> updateAccept(@RequestBody Counsel counsel) {
		counselService.updateAccept(counsel);
		if (counselService.updateAccept(counsel))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/answer")
	public ResponseEntity<String> updateAnswer(@RequestBody Counsel counsel) {
		counselService.updateAnswer(counsel);
		if (counselService.updateAnswer(counsel))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/fq")
	public ResponseEntity<String> updateFeedbackQ(@RequestBody Counsel counsel) {
		counselService.updateFeedbackQ(counsel);
		if (counselService.updateFeedbackQ(counsel))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/fa")
	public ResponseEntity<String> updateFeedbackA(@RequestBody Counsel counsel) {
		counselService.updateFeedbackA(counsel);
		if (counselService.updateFeedbackA(counsel))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/review")
	public ResponseEntity<String> updateReview(@RequestBody Counsel counsel) {
		counselService.updateReview(counsel);
		if (counselService.updateReview(counsel))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/reject")
	public ResponseEntity<String> updateReject(@RequestBody Counsel counsel) {
		counselService.updateReview(counsel);
		if (counselService.updateReject(counsel))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	

	// 게시글 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		if (counselService.deleteCounsel(id))
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<String>(FAIL, HttpStatus.NOT_FOUND);
	}

}
