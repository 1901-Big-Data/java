package com.example.threading;

public class Application {
	
	public static void main(String[] args) throws InterruptedException {		
		Thread t1 = new MyThreadClass();
		Thread t2 = new MyThreadClass();
		Thread t3 = new MyThreadClass();
		
		t1.setDaemon(true);
		
		Thread t4 = new Thread(new Worker());
		Thread t5 = new Thread(((Runnable)() -> {
			for (int i = 0; i < 100; ++i) {
				System.out.println("Lambda: " + i);
			}
		})); 
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		
		System.out.println(MyThreadClass.str.toString());
	}
	
}
