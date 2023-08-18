package day11;

public class Account {
	
	private int money=10;

	public void save(int val) {		
		money+=val;
		System.out.printf("입금액: %d, 입금후 잔액: %d%n", val, money);
	}
	
	public void get(int val) {
		if(money-val <0) {
			System.out.printf("현금 부족!! 현재 잔액:%d, 요청 금액: %d%n", money, val);
			return;
		}
		money-=val;
		System.out.printf("출금액: %d, 출금후 잔액: %d%n", val, money);
	}

}///////////////////////////////////////
