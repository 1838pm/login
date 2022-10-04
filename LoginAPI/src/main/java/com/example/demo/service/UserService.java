package com.example.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.CustomException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public User save(String email, String password) {
		// Check Email
		Optional<User> findByEmail = userRepository.findByEmail(email);
		if(findByEmail.isPresent()) throw new CustomException(ErrorCode.Duplicate_userEmail);
		
		User user = new User();
		
		user.setEmail(email);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		
		userRepository.save(user);
		return user;
	}
	
	public User login(String email, String password) {
		User user = userRepository.findByEmail(email).orElseThrow(
				()-> new CustomException(ErrorCode.CHECK_EMAIL_OR_PASSWORD));
		
		return user;
	}
	
}
