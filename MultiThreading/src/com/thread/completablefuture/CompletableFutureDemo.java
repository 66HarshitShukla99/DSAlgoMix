package com.thread.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Future<Void>f=findDoubleAsync(23);
		while(!f.isDone()) {
			System.out.println("Trying");
			Thread.sleep(1500);
		}
		System.out.println(f.get());
	}
	
	private static int root(int k) {
		 try { 
			 Thread.sleep(2000); 
		 } 
		 catch (InterruptedException e) {
			  e.printStackTrace();
			  }
		 
		return (int)Math.sqrt(k);
	}
	private static int doubleIt(int k) {
		
		  try { 
			  Thread.sleep(2000); 
			  }
		  catch (InterruptedException e) {
			  e.printStackTrace(); 
		  }
		 
		return 2*k;
	}

	private static Future<Void> findDoubleAsync(int k) {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(()->doubleIt(8)).
				exceptionally(l->0).
				thenApplyAsync(j->root(j)).thenRun(()->System.out.println("Finished"));
		return cf;
	}

}
