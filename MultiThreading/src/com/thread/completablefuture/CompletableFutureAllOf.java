package com.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureAllOf {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<String> c1= CompletableFuture.supplyAsync(()-> waitFor1s());
		CompletableFuture<String> c2= CompletableFuture.supplyAsync(()-> waitFor2s());
		CompletableFuture<String> c3= CompletableFuture.supplyAsync(()-> waitFor3s());
		
		CompletableFuture<Void> combinedFuture=CompletableFuture.allOf(c1,c2,c3);
		System.out.println(combinedFuture.get()); // No result
		
		String combinedResult= Stream.of(c1,c2,c3)
				.map(CompletableFuture:: join)
				.collect(Collectors.joining(","));
		System.out.println(combinedResult);
	}

	private static String waitFor1s() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		return "Done waiting for 1s ";
	}
	
	private static String waitFor2s() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		return "Done waiting for 2s ";
	}
	
	private static String waitFor3s() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Done waiting for 3s ";
	}

}
