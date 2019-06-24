package com.ds.algo;

public class DifferenceProb {

	
	
	public static void main(String[] args) {

		int [] arr= {1, 2, 90, 10, 110};
		System.out.println(maxDiffTwoNum(arr));
	}

	/*
	 * Given an array arr[] of integers, find out the maximum difference 
	 * between any two elements such that larger element appears after the smaller number.
	 */
	private static int maxDiffTwoNum(int[] arr) {
		
		int max=arr[arr.length-1];
		int maxIndex=arr.length-1;
		for(int i=arr.length-2;i>=0;i--) {
			if(arr[i]> max)
			{
				max= arr[i];
				maxIndex=i;
			}
		}
		if(maxIndex==0) return 0;
		else {
			int diff=0;
			for(int i=0;i<maxIndex-1;i++) {
				if(diff < max-arr[i])
					diff=max-arr[i];
			}
			return diff;
		}
	}

}
