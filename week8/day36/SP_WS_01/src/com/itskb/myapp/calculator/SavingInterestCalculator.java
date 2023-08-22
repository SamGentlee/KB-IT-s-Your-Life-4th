package com.itskb.myapp.calculator;

import org.springframework.stereotype.Component;

@Component("savingCalculator")
public class SavingInterestCalculator implements InterestCalculator {
	
	final private double RATE = 0.0334;
	
	@Override
	public double calculate(int amount) {
		System.out.println("SavingInterestCalculator - calculate()");
		return amount * RATE;
	}

}
