package com.tassiapereira.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tassiapereira.workshopmongo.domain.Post;
import com.tassiapereira.workshopmongo.domain.User;
import com.tassiapereira.workshopmongo.dto.AuthorDTO;
import com.tassiapereira.workshopmongo.dto.CommentDTO;
import com.tassiapereira.workshopmongo.repository.PostRepository;
import com.tassiapereira.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM//yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		//zerar a colecao no mongoDb
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "silva@gmail.com");
		User jorge = new User(null, "Jorge Amado", "amado@gmail.com");
		User saulo = new User(null, "Saulo Medeiros", "ss@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, jorge, saulo));
		
		Post post1 = new Post(null, sdf.parse("21/02/2024"), "partiu viagem", "vou viajar para o nordeste, abracos", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/02/2024"), "bom dia", "hoje eu acordei animado", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("boa viagem mano", sdf.parse("21/03/2024"), new AuthorDTO(jorge));
		CommentDTO c2 = new CommentDTO("aproveite", sdf.parse("23/03/2024"), new AuthorDTO(saulo));
		CommentDTO c3 = new CommentDTO("tenha um otimo dia", sdf.parse("23/03/2024"), new AuthorDTO(jorge));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post1.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
