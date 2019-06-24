package com.thread;

import java.util.concurrent.Semaphore;

public class Q {

	int n;
	
	static Semaphore semCon=new Semaphore(0);
	static Semaphore semProd=new Semaphore(1);
	
	void get() {
		try {
			semCon.acquire();
		}
		catch(InterruptedException e) {
			
		}
		System.out.println("Get :: "+n);
		semProd.release();
	}
	
	void put(int n) {
		try {
			semProd.acquire();
		}
		catch(InterruptedException e) {
			
		}
		this.n=n;
		System.out.println("Put :: "+n);
		semCon.release();
	}
	
}
