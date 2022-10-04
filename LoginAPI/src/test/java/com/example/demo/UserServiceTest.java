package com.example.demo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@SpringBootTest
@Transactional
@ActiveProfiles(profiles = "test")
@AllArgsConstructor
public class UserServiceTest {

	private final UserService userService;
	private final UserRepository UserRepository;
	
	@Test
	void signUp() {
		String email = "test@test.com";
		String password = "test";
		
		User user = userService.save(email, password);
		// email 확인
		boolean CheckEmail = user.getEmail().isEmpty();
		System.out.println("CheckEmail : " + CheckEmail);
		// password 확인
		boolean CheckPassword = user.getPassword().isEmpty(); 
		System.out.println("CheckPassword : " + CheckPassword);
	}
	
	@Test
	void findByEmail() {
		UserRepository.save(new User("test@test.com", "test"));
		
		Optional<User> findByEmail = UserRepository.findByEmail("test@test.com");
		
		System.out.println("findByEmail : " + findByEmail);
	}
}
