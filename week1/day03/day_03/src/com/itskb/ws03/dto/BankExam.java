package com.itskb.ws03.dto;

public class BankExam {
	public static void main(String[] args) {
		UserDto user = new UserDto(1,"홍길동","hong@gmail.com","010-1111-2222",false);
		AccountDto account = new AccountDto(1,"123-45678-90",50000,1);
		
		System.out.println(user.toString());
		System.out.println(account.toString());
	}
}
