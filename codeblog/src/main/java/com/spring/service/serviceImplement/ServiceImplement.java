package com.spring.service.serviceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Post;
import com.spring.repository.CodeRepository;
import com.spring.service.CodeService;

@Service
public class ServiceImplement implements CodeService {

	@Autowired
	CodeRepository codeRepository;

	@Override
	public List<Post> findAll() {

		return codeRepository.findAll();
	}

	@Override
	public Post findById(Long Id) {

		return codeRepository.findById(Id).get();
	}

	@Override
	public Post save(Post post) {

		return codeRepository.save(post);
	}

	
	@Override
	public void delete(Post post) {

		codeRepository.delete(post);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}


	
	

}
