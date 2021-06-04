package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Comment;
import com.main.service.ICommentService;

@RestController
public class CommentController {

	@Autowired
	ICommentService commentService;

	@GetMapping("/get_comments")
	public List<Comment> getComments() throws Exception {

		return commentService.getAllComment();

	}

	@GetMapping("/save_comments")
	public String saveComments() throws Exception {

		return commentService.saveAllComment();

	}

}
