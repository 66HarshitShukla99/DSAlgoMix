package com.thread;

public class Caller implements Runnable {
	
	String msg;
	Callme target;
	Thread t;
	
	public Caller(Callme target,String s) {
		this.target = target;
		msg=s;
		this.t=new Thread(this);
	}
	public void run() {
		target.call(msg);
	}

}
