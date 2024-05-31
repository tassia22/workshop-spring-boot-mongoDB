package com.tassiapereira.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tassiapereira.workshopmongo.domain.Post;
import com.tassiapereira.workshopmongo.repository.PostRepository;
import com.tassiapereira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id){
		Post user = repo.findOne(id);
		if(user == null) {
			throw new ObjectNotFoundException("objeto não encontrado");
		}
	
		return user;
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
}
