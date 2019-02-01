package com.example.threading;

public class Worker implements Runnable {
	public void run() {
		for (int i = 0; i < 100; ++i) {
			System.out.println("Runnable: " + i);
		}
	}
}
