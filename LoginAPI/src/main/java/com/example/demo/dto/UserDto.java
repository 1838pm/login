package com.example.demo.dto;

import com.example.demo.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	
	private String email;
	private String password1;
	private String password2;
	
	public static UserDto fromEntity(User user) {
		return UserDto.builder()
				.email(user.getEmail())
				.password1(user.getPassword())
				.build();
	}
}
