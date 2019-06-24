package com.thread;

public class Thread1 implements Runnable {

	@Override
	public void run() {

		System.out.println("Calling Thread2 exception");
		new Thread(new Thread2()).start();
		
	}

}
