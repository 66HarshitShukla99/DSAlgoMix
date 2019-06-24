package com.thread;

public class RaceConditionDemo {

	public static void main(String[] args) {
		Callme target = new Callme();
		Caller obj1 = new Caller(target,"Hello");
		Caller obj2 = new Caller(target,"Synchronized");
		Caller obj3 = new Caller(target,"World");
		
		obj1.t.start();
		obj2.t.start();
		obj3.t.start();
		
		try {
			obj1.t.join();
			obj2.t.join();
			obj3.t.join();
		}
		catch(InterruptedException e) {
			System.out.println("Interrupted");
		}

	}

}
