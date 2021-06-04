package com.main.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
