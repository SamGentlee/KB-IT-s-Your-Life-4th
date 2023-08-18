package com.itskb.ws04.dto;

import java.util.Comparator;

public class AccountDto implements Comparable<AccountDto>, Comparator<AccountDto>{
	
	private int accountSeq;
	private String accountNumber;
	private int balance;
	private int userSeq;
	
	/** 기본 생성자*/
	public AccountDto() {
		
	}
	/** 모든 변수를 받는 생성자 */
	public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
		super();
		this.accountSeq = accountSeq;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userSeq = userSeq;
	}
	/** 사용자 일련번호를 기준으로 하는 정렬을 위한 compare() 오버라이딩 */
	@Override
	public int compare(AccountDto o1, AccountDto o2) {
		
		return o1.getUserSeq()-o2.getUserSeq();
	}
	/**계좌 잔액을 기준으로 하는 정렬을 위한 compareTo() 오버라이딩 */
	@Override
	public int compareTo(AccountDto o) {
		
		return this.balance-o.getBalance();
	}
	
	/** toString() 메서드 오버라이드*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("accountSeq=");
		builder.append(accountSeq);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", userSeq=");
		builder.append(userSeq);
		builder.append("\n");
		return builder.toString();
	}
	
	//  Getter/Setter
	public int getAccountSeq() {
		return accountSeq;
	}
	public void setAccountSeq(int accountSeq) {
		this.accountSeq = accountSeq;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
}
