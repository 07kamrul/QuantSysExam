package com.main.service;

import java.util.List;

import com.main.model.Post;

public interface IPostService {

	String saveAllPost() throws Exception;

	List<Post> getAllPost();

}
