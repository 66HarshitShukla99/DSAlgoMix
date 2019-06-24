package com.thread;

public class Producer implements Runnable{
	Q q;

	Producer(Q q){
		this.q=q;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i<20;i++) {
			q.put(i++);
		}
		
	}



}
