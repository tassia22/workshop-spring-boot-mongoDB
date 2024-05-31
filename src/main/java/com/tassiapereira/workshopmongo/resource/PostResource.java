package com.tassiapereira.workshopmongo.resource;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tassiapereira.workshopmongo.domain.Post;
import com.tassiapereira.workshopmongo.resource.util.URL;
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
	
	@RequestMapping(value="/titlesearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>>findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		//decodificando o texto
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> fullSearch(
 		@RequestParam(value="text", defaultValue="") String text,
 		@RequestParam(value="minDate", defaultValue="") String minDate,
 		@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		
 		//decodificando o texto
		text = URL.decodeParam(text);
		
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		
		List<Post> list = service.fullSearch(text, min, max);
		
		return ResponseEntity.ok().body(list);
	}
	
}