# login

■ 개발환경
- spring boot 2.7.4
- spring security
- h2
- JPA
- thymeleaf
- lombok

■ 요구사항 중 해결하지 못한 부분 : 로그인, email의 양방향 암호화

■ 분석 및 구현한 내용
1. 회원가입
  - 회원가입 시 중복이 있는 email 인지 확인. -> 에러가 없다면 서버에 저장, 에러가 있다면 Exception
  - 사용자의 email, password를 받아 저장하고 password는 복호화 할 수 없는 암호화 후 저장.
  
2. 로그인
  - 서버에 저장되어 있는 사용자 정보와 사용자가 입력한 정보의 일치 여부 확인 후 로그인 처리(stackoverflow 발생 - 해결하지 못함)
