package com.design.collections;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		CustomHashMap<Integer, Integer> chm = new CustomHashMap<>(10);
		chm.put(1, 2);
		System.out.println(chm.get(1));
	}

}
