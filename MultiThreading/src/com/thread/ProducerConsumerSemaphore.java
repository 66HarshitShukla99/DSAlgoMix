package com.thread;

public class ProducerConsumerSemaphore {

	public static void main(String[] args) {

		Q q = new Q();
		Thread t1=new Thread(new Consumer(q),"Consumer");
		Thread t2=new Thread(new Producer(q),"Producer");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
