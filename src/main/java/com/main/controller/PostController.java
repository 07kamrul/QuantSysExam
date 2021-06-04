package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Post;
import com.main.service.IPostService;

@RestController
public class PostController {

	@Autowired
	IPostService postService;

	@GetMapping("/get_posts")
	public List<Post> getPost() throws Exception {

		return postService.getAllPost();

	}

	@GetMapping("/save_post")
	public String savePost() throws Exception {

		return postService.saveAllPost();

	}

}
