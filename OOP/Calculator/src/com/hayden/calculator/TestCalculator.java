package com.hayden.calculator;

public class TestCalculator {

	public static void main(String[] args) {
		Calculator calc1 = new Calculator();
		
		System.out.println(calc1.performOperation(10.5));
		System.out.println(calc1.performOperation("+"));
		System.out.println(calc1.performOperation(5.2));
		System.out.println(calc1.performOperation("*"));
		System.out.println(calc1.performOperation(10));
		System.out.println(calc1.performOperation("="));

	}

}
