package com.ds.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsSuchThatDiffToSum {

	/*
	 * Given an array of elements,you have determine the 
	 * number of pairs(a,b) such that |a-b|=K; Assuming they are not distinct
	 */
	
	
	public static void main(String[] args) {

		int [] arr= {-2,-12,0,1,3,4,5,6,7,9,10,11,8,100};
		final int K= 9;
		List<int []> l = search(arr,10);
		for (int[] is : l) {
			System.out.println(arr[is[0]]+","+arr[is[1]]);
		}
	}

	private static List<int []> search(int[] arr,int K) {
		List<int []> l = new ArrayList<>();
		
		Arrays.sort(arr);//nlogn
		int i=0; int j=1;
		while(j<=arr.length-1) {
			if(Math.abs(arr[i]-arr[j])==K) {
				l.add(new int [] {i,j});
				i++; 
				j++;
			}
			else ++j;
		}
		
		return l;
	}

}
