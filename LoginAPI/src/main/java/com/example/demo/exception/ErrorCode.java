package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	Duplicate_userEmail("이메일 중복!"),
	CHECK_PASSWORD("비밀번호 불일치"),
	CHECK_EMAIL_OR_PASSWORD("이메일 또는 비밀번호가 틀립니다."),
	INTERNAL_SERVER_ERROR("서버에 오류가 발생했습니다."),
	INVALID_REQUEST("잘못된 요청입니다.");
	
	private final String message;
	
}
