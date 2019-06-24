package com.ds.algo;

public class MaxSumSubsequence {

	/*
	 * Kadane's algorithm
	 */
	public static void main(String[] args) {

		int [] arr=  {-2, -3, 4, -1, -2, 1, 5, -3};
		
		int k=maxSumSubequence(arr);
		System.out.println(k);
	}

	private static int maxSumSubequence(int[] arr) {
		int maxSoFar=arr[0];
		int maxTemp=arr[0];
		for(int i=1; i< arr.length;i++) {
			maxTemp+=arr[i];
			if(maxTemp < 0)
				maxTemp=0;
			if(maxTemp > maxSoFar)
				maxSoFar=maxTemp;
			
		}
		return maxSoFar;
	}

}
