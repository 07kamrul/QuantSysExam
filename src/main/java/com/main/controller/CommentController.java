package com.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Comment;
import com.main.service.ICommentService;

@RestController
public class CommentController {

	@Autowired
	ICommentService commentService;

	@GetMapping("/get_comments")
	public ResponseEntity<Map<String, Object>> getComments() throws Exception {
		System.out.println("get_comments---------------------");

		Map<String, Object> data = new HashMap<>();

		List<Comment> list = commentService.getAllComment();

		data.put("comments", list);

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@GetMapping("/save_comments")
	public String saveComments() throws Exception {

		return commentService.saveAllComment();

	}

}
