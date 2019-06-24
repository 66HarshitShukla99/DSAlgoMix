package com.ds.algo;

public class findRepeatingNumTillN {

	public static void main(String[] args) {
		int [] arr = {1,1,2,3,4,5,6,7,8,9};
		findRepeatingNum(arr,9);

	}

	private static void findRepeatingNum(int[] arr, int N) {
		
		int xorArr=arr[0];
		for(int i=1;i<arr.length;i++) {
			xorArr= xorArr^arr[i];
		}
		int xorN=1;
		for(int i=2; i<=N;i++) {
			xorN=xorN^i;
		}
		System.out.println(xorN^xorArr);
		
	}

}
