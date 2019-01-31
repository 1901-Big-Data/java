package com.example.calculator;

import java.io.IOException;

public class Ti84 implements SimpleCalculator {

	@Override
	public int add(int i, int j) {
		return i + j;
	}

	@Override
	public int subtract(int i, int j) {
		return i - j;
	}

	@Override
	public double add(double i, double j) {
		return i + j;
	}

	@Override
	public double subtract(double i, double j) {
		return i - j;
	}
	
	public void errorProne() throws IOException {
		throw new IllegalAccessError();
	}

}
