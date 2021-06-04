package com.main.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
