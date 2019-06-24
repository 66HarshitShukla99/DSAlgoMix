package com.graph;

/**
 * @author HulkSmash
 *
 */
public class AmazonQues {

	//Given a matrix of 0,1 & 9, find a path from 1s to 9.
	
	public static void main(String[] args) {

		int [][] arr = {{1,1,1},
						{0,0,1},
						{1,9,1}};
		int count=0;
		int[][] dp=new int[arr.length][arr.length];
		for(int i=0; i < arr.length;i++){
			for(int j=0; j < arr.length;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
					
		findLowestPath(arr,count,dp);
	}
	}
	private static int findLowestPath(int[][] arr ,int count, int [][] dp) {
		
		int i1=0,i2=0;;
		boolean flag=true;
		System.out.println("Calling");
		int i=0;
		while( i < arr.length && flag) {
			for(int j=0; j < arr.length;) {
				System.out.println(arr[i][j]);
				if(i < 0 || j < 0 || i ==arr.length || j >= arr.length) {
					i=i1;j=i2;
				}
				
				else if(j+1 < arr.length && arr[i][j+1]==9) {
					System.out.println("Found 9");
					int temp=dp[i][j]+1;
					if(temp < dp[i][j+1])
						dp[i][j+1]=temp;
					flag = false;
					i1=i;i2=j;
					break;
				}
				else if(j-1 >= 0 && arr[i][j-1]==9  ) {
					System.out.println("Found 9");
					int temp=dp[i][j]+1;
					if(temp < dp[i][j-1])
						dp[i][j-1]=temp;
					flag = false;
					i1=i;i2=j;
					break;
				}
				else if(i+1 < arr.length && arr[i+1][j]==9) {
					System.out.println("Found 9");
					int temp=dp[i][j]+1;
					if(temp < dp[i+1][j])
						dp[i+1][j]=temp;
					flag = false;
					i1=i;i2=j;
					break;
				}
				else if(i-1>= 0 && arr[i-1][j]==9) {
					System.out.println("Found 9");
					int temp=dp[i][j]+1;
					if(temp < dp[i-1][j])
						dp[i-1][j]=temp;
					flag = false;
					i1=i;i2=j;
					break;
				}
				else if(j+1 <arr.length && arr[i][j+1]==1) {
					int temp=dp[i][j]+1;
					if(temp < dp[i][j+1])
						dp[i][j+1]=temp;
					j++;
				}
				else if(j-1 >=0 && arr[i][j-1]==1) {
					int temp=dp[i][j]+1;
					if(temp < dp[i][j-1])
						dp[i][j-1]=temp;
					j--;
				}
				else if(i+1 <arr.length && arr[i+1][j]==1) {
					int temp=dp[i][j]+1;
					if(temp < dp[i+1][j])
						dp[i+1][j]=temp;
					i++;
				}
				else if(i-1 >=0 && arr[i-1][j]==1) {
					int temp=dp[i-1][j]+1;
					if(temp < dp[i][j])
						dp[i-1][j]=temp;
					i--;
				}
				else {
					i=i1;i=i2;
				}
				
				i1=i; i2=j;
			}
		}
		return dp[i1][i2];
	}
}
