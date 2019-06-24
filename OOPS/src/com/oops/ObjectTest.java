package com.oops;

import java.util.ArrayList;
import java.util.List;

public class ObjectTest {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("HI!!");
		l.add("I am Harshit");
		method(l,"Shukla");

	}
	public static <T> void method(List<T> l,T a) {
	
		l.add(a);
		System.out.println(l);
	}
	

}
