package com.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Post;

@Repository
@Transactional
public interface CodeRepository extends JpaRepository<Post, Long>{

	
	
}
