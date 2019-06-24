package com.thread;

import java.util.concurrent.Exchanger;

public class EvenThread implements Runnable{

	int i;
	Exchanger<Integer> exc;
	
	EvenThread(int i, Exchanger<Integer> exc){
		this.i=i;
		this.exc=exc;
	}
	@Override
	public void run() {
		System.out.println("In Even");
		try {
			while(true) {
			int k=exc.exchange(++i);
			System.out.println("Got Even :: "+k);
			Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
