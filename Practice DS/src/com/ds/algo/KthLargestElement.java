package com.ds.algo;

import java.util.Arrays;

public class KthLargestElement {

	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5,8,9,10,15,14,19};//1,2,3,4,5,8,9,10,14,15,19
		int start=0;
		int end=arr.length-1;
		int k=3;//Ans: 14
		
		System.out.println(findKthLargestElementUsingOrderStatistics(arr,k,start,end));

	}

	private static int findKthLargestElementUsingOrderStatistics(
			int[] arr, int k,int start, int end) {
		
		if(start < end) {
			
			int pos=partition(arr, start,end);
			if(pos-start==k) return arr[pos];
			
			if(pos-start < k)
				return findKthLargestElementUsingOrderStatistics(arr,k,pos+1,end);
			
			else return findKthLargestElementUsingOrderStatistics(arr,k-start+pos-1,start,pos-1);
		}
		return 0;
	}
	private static void swap(int [] arr, int i, int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=arr[i];
	}

	private static int partition(int[] arr,int start, int end) {
		int i=start,j=end;
		int pivot=arr[end];
		while(i < j) {
			if(arr[i]> pivot && arr[j] < pivot) {
				swap(arr,i,j);
				i++;
				}
			else if(arr[i]>pivot && arr[j]> pivot)
				j--;
			else {
				i++;
				j--;
				}
		}
		swap(arr,i,end);
		for(int l: arr) {
			System.out.print(l+",");
		}
		System.out.println();
		return i;
		
		
		
	}

}
