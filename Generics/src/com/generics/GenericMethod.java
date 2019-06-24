package com.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod<T extends Comparable<T>> {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		for(int i =0; i < 10;i++) {
			l.add(i);
		}
		newMethod(l);
	}
	
	public static <T extends Number> void newMethod(List<T> l){
		
	}
	
	public  int method(T t1, T t2) {
		return t1.compareTo(t2);
		
	}

}
