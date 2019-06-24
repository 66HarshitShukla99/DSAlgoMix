package com.ds.algo;

public class AliceCandiesDistributionProblem {

	
	static long candies(int n, int[] arr) {
        int [] T = new int[arr.length];
        for(int i=0; i < arr.length;i++)
            T[i]=1;
        int i=0;
        //forward sequence
        for(i=1; i< arr.length;i++){
        	if(arr[i]> arr[i-1])
        		T[i]=T[i-1]+1;
        }
        //backward sequence
        for(i=arr.length-1;i>0;i--) {
        	if(arr[i-1]> arr[i])
        		T[i-1]=Math.max(T[i-1], T[i]+1);
        }
        
		
        long sum=0L;
        for(int k: T){
        	System.out.print(k+" ");
            sum+=k;
        }
        System.out.println();
        return sum;
    }
	
	public static void main(String[] args) {

		int [] arr =  {2,4,3,5,2,6,4,5};
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(candies(arr.length,arr));
	}

}
