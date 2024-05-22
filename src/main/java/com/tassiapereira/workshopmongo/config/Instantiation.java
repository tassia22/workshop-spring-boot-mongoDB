package com.tassiapereira.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tassiapereira.workshopmongo.domain.User;
import com.tassiapereira.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public void run(String... args) throws Exception {
		
		//zerar a colecao no mongoDb
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "silva@gmail.com");
		User jorge = new User(null, "Jorge Amado", "amado@gmail.com");
		User saulo = new User(null, "Saulo Medeiros", "ss@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, jorge, saulo));
	}

}
