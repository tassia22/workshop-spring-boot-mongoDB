package com.tassiapereira.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tassiapereira.workshopmongo.domain.User;
import com.tassiapereira.workshopmongo.dto.UserDTO;
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
	
	//inserindo um objeto
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	//deletando 
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	//atualizando
	public User update(User obj) {
		User newObj = repo.findOne(obj.getId());
		//copiar os dados que estao no obj para o newObj
		updateData(newObj, obj);
		return repo.save(newObj);
		
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		
		
	}
	
		

}
