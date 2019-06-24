package com.thread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	public static void main(String[] args) {

		ConcurrentHashMap<Integer,String> chm= new ConcurrentHashMap<>();
		
		chm.put(1, "Harshit");
		chm.put(2, "Shukla");
		
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(chm.containsKey(1)) {
					try {
						chm.put(1, "Kavita");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("get :: "+chm.get(1));
			}
		});
		t2.start();
		
	}

}
