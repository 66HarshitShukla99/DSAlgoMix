package com.thread;

import java.util.concurrent.Exchanger;

public class OddThread implements Runnable{

	int i;
	Exchanger<Integer> exc;
	
	OddThread(int i, Exchanger<Integer> exc){
		this.i=i;
		this.exc=exc;
	}
	@Override
	public void run() {
		System.out.println("In Odd");
		try {
			while(true) {
			int k=exc.exchange(++i);
			System.out.println("Got Odd :: "+k);
			Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
