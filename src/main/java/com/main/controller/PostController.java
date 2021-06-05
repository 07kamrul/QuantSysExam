package com.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Post;
import com.main.service.IPostService;

@RestController
public class PostController {

	@Autowired
	IPostService postService;

	@GetMapping("/get_posts")

	public ResponseEntity<Map<String, Object>> getPosts() throws Exception {
		Map<String, Object> data = new HashMap<>();

		List<Post> list = postService.getAllPost();

		data.put("posts", list);

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@GetMapping("/save_post")
	public String savePost() throws Exception {

		return postService.saveAllPost();

	}

}
