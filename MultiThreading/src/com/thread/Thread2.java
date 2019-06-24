package com.thread;

import javax.management.RuntimeErrorException;

public class Thread2 implements Runnable{

	@Override
	public void run() {
		throw new RuntimeException("Exception thrown");
	}

}
