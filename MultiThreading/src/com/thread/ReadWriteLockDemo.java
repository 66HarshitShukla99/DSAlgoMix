package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

	static void method(){
		ReadWriteLock lock = new ReentrantReadWriteLock();
		Lock lw=lock.writeLock();
		int i=0;
		while(i < 10) {
			System.out.println(i);
			i++;
		}
		lw.unlock();
		System.out.println("calling");
	}
	public static void main(String[] args) {

		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {

				method();
				
			}
		});
		t1.start();
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {

				method();
				
			}
		});
		t2.start();
	}

}
