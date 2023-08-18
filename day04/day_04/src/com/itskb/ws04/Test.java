package com.itskb.ws04;

import com.itskb.ws04.service.BankService;

public class Test {

	public static void main(String[] args) {
		
		BankService bankService = new BankService();
		System.out.println(bankService.getUserDetail(101));
		System.out.println(bankService.getAccountList(101));
        System.out.println(bankService.getAccountList());
        System.out.println(bankService.getAccountListSortByBalance());
        System.out.println(bankService.getAccountListSortByUserSeq());
	}

}
