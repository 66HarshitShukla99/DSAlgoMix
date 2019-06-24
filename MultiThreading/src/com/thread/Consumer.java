package com.thread;

public class Consumer implements Runnable{

	Q q;
	
	Consumer(Q q){
		this.q=q;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i< 20;i++) {
			q.get();
		}
		
	}

	
}
