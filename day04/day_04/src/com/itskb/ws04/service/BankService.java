package com.itskb.ws04.service;

import java.util.ArrayList;
import java.util.Collections;
import com.itskb.ws04.dto.AccountDto;
import com.itskb.ws04.dto.UserDto;

public class BankService{
	
	private ArrayList<AccountDto> accountList = new ArrayList<>();
	private ArrayList<UserDto> userList = new ArrayList<>();
	
	/** 기본생성자에 테스트 데이터 삽입*/
	public BankService() {
		accountList.add(new AccountDto(1000,"123-456-789",50000,100));
		accountList.add(new AccountDto(1001,"123-678-456",20000,101));
		accountList.add(new AccountDto(1002,"123-234-234",100000,102));
		accountList.add(new AccountDto(1003,"123-789-123",150000,103));
		accountList.add(new AccountDto(1005,"123-678-123",100000,101));
		
		userList.add(new UserDto(100,"홍길동","hong@naver.com","010-1111-1111", false));
		userList.add(new UserDto(101,"최길동","choi@gmail.com","010-2222-2222", false));
		userList.add(new UserDto(102,"김길동","kim@gmail.com","010-3333-3333", true));
		userList.add(new UserDto(103,"박길동","park@naver.com","010-4444-4444", false));
	}
	
	/** 사용자일련번호를 통해 계좌목록 출력*/
	public ArrayList<AccountDto> getAccountList(int userSeq){
		ArrayList<AccountDto> list = new ArrayList<>();
		for(int i=0;i<accountList.size();i++) {
			if(accountList.get(i).getUserSeq() == userSeq) {
				list.add(accountList.get(i));
			}
		}
		return list;
	}
	
	/**사용자 일련번호를 통해 사용자 정보 출력 */
	public UserDto getUserDetail(int userSeq) {
		for(int i=0;i<userList.size();i++) {
			if(userList.get(i).getUserSeq() == userSeq) {
				return userList.get(i);
			}
		}
		return null;
	}
	
	/** 모든 계좌 정보 출력*/
	public ArrayList<AccountDto> getAccountList(){

		return this.accountList;
	}
	
	/** 모든 계좌 정보를 계좌잔액을 기준으로 정렬하여 출력 */
	public ArrayList<AccountDto> getAccountListSortByBalance(){
		Collections.sort(this.accountList);
		return this.accountList;
	}
	
	/** 모든 계좌 정보를 사용자 일련번호를 기준으로 정렬하여 출력 */
	public ArrayList<AccountDto> getAccountListSortByUserSeq(){
		Collections.sort(this.accountList, new AccountDto());
		return this.accountList;
	}


}
