package com.main.service;

import java.util.List;

import com.main.model.Comment;

public interface ICommentService {

	List<Comment> getAllComment();

	String saveAllComment() throws Exception;

}
