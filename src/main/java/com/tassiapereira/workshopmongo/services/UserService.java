package com.tassiapereira.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tassiapereira.workshopmongo.domain.User;
import com.tassiapereira.workshopmongo.repository.UserRepository;
import com.tassiapereira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id){
		User user = repo.findOne(id);
		if(user == null) {
			throw new ObjectNotFoundException("objeto não encontrado");
		}
		return user;
	}

}
