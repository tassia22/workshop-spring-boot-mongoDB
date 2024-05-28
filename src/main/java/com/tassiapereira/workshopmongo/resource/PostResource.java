package com.tassiapereira.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tassiapereira.workshopmongo.domain.Post;
import com.tassiapereira.workshopmongo.domain.User;
import com.tassiapereira.workshopmongo.dto.UserDTO;
import com.tassiapereira.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/users")
public class PostResource {

	@Autowired
	private PostService service;
	
	//buscar usuario por id
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	

	
}