package com.example.calculator;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ti84 implements SimpleCalculator {
	
	private static Logger logger = LogManager.getLogger(Ti84.class);

	@Override
	public int add(int i, int j) {
		logger.info("This is a sample log");
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
		throw new IOException();
	}

}
