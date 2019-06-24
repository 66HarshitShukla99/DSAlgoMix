package com.oops;

import java.io.IOException;

public class ExceptionInInheritance {

	public Animal method() throws NoClassDefFoundError {
		return null;
	}
	
	public static void main(String[] args) {

	}

}

class ExceptionInInheritanceChild extends ExceptionInInheritance{
	
	public Dog method() throws Error{
		return null;
	}
	
}
