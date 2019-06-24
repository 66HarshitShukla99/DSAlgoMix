package com.ds.algo;

public class Count0sAnd1s {

	public static void main(String[] args) {
		
		int [] arr= {0,0,0,0,1,0,1,0,1,0,0,1};
		
		sortArrOf0sAnd1s(arr,arr.length);
	
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void sortArrOf0sAnd1s(int[] arr, int length) {
		
		int i=0,j=length-1;
		while(i < j) {
			if(arr[i] > arr[j]) {
				swap(arr,i,j);
				i++;j--;
			}
			else if(arr[i]==arr[j] && arr[i]==0) {
				i++;
			}
			else if(arr[i]==arr[j] && arr[i]==1) {
				j--;
			}
			else {
				i++;
				j--;
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
