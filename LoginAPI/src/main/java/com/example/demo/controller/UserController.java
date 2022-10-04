package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.CustomException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping({ "/", "/home" })
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String email, String password) {
		userService.login(email, password);
		
		return "login";
	}
	
	@GetMapping("/signUp")
	public String signUp() {
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public String signUp(@Valid UserDto userDto) {
		
		if(!userDto.getPassword1().equals(userDto.getPassword2())) {
			throw new CustomException(ErrorCode.CHECK_PASSWORD);
		}
		
		userService.save(userDto.getEmail(), userDto.getPassword1());
		return "redirect:/login";
	}
}
