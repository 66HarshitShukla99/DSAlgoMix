package com.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureThenCombine {

	public static void main(String[] args) {

		CompletableFuture<String> c1= CompletableFuture.supplyAsync(()->"Hello")
				.thenCombineAsync(CompletableFuture.supplyAsync(()->" World!!"), (s1,s2)->s1+s2);
		
		try {
			System.out.println(c1.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
