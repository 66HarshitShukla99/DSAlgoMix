package com.thread.completablefuture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenCompose {

	public static List<String> retDemo() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<String> l = new ArrayList<>();
		l.add("Harshit");
		l.add("Shukla");
		return l;
	}
	public static List<String> retDemo2(List<String> s) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		s.add("Anukriti");
		s.add("Shukla");
		Collections.sort(s);
		return s;
	}
	public static void main(String[] args) {

		CompletableFuture<List<String>> c1= CompletableFuture.supplyAsync(()-> retDemo()).
				thenComposeAsync(s-> CompletableFuture.supplyAsync(()->retDemo2(s)));
		
		try {
			System.out.println(c1.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
