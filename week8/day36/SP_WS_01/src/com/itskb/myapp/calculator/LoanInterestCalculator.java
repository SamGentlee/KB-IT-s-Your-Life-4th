package com.itskb.myapp.calculator;

import org.springframework.stereotype.Component;

@Component("loanCalculator")
public class LoanInterestCalculator implements InterestCalculator {
	
	final private double RATE = 0.0525;
	
	@Override
	public double calculate(int amount) {
		System.out.println("LoanInterestCalculator - calculate()");
		return amount * RATE;
	}

}
