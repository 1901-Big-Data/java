package com.example.threading;

public class MyThreadClass extends Thread {
	
	static public StringBuffer str = new StringBuffer("cats and dogs");
	static public char[] myChar = {'a','b','c'};
	
	
	@Override
	public void run() {
		for (int i = 0; i < 10000; ++i) {
			System.out.println("Thread: " + i);
			str.setCharAt(i % 13 , myChar[i%3]);;
		}
	}
}
