package com.spring.service;

import java.util.List;

import com.spring.model.Post;

public interface CodeService {
	
	
	List<Post> findAll();
	Post findById(Long Id);
	Post save(Post post);
	void delete(Long id);
	void delete(Post post);
	
	
	
	
	
	

}
