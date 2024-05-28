package com.tassiapereira.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tassiapereira.workshopmongo.domain.Post;
import com.tassiapereira.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	Post findOne(String id);

	
	
	

}
