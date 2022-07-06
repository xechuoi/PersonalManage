package com.example.personalmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonalManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalManageApplication.class, args);
	}

//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
////		User user = new User();
////		user.setId(1);
////		user.setUsername("a");
////		user.setPassword("a");
////		user.setEmail("a");
////
////		userRepository.save(user);
//	}
}
