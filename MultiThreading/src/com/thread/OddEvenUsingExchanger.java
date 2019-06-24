package com.thread;

import java.util.concurrent.*;
public class OddEvenUsingExchanger {

	public static void main(String[] args) {
		Exchanger<Integer> exc= new Exchanger<>();
		int i=1;
		Thread tOdd=new Thread(new OddThread(i, exc));
		Thread tEven=new Thread(new EvenThread(i, exc));
		
		tOdd.start();
		tEven.start();
		
		
	}
}
