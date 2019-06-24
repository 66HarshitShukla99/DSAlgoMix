package com.generics;

import java.util.Map;
import java.util.WeakHashMap;

public class Test {

	public static void main(String[] args) {

		Map<Employee,Integer> map = new WeakHashMap<>();
		Employee e1= new Employee(1,"Harshit");
		map.put(e1, 1000);
		System.out.println(map.get(e1));
		e1.id=2;
		System.out.println(map.size());
		System.gc();
		System.out.println(map.size());
	}

}
