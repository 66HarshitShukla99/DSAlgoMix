package com.graph;

/*
 * Given a matrix of 0,1 & 9 find the shortest path from arr(0,0)=1 to unique 9 in the matrix
 */
public class AmazonQuesNew {

	static int kRight;
	static int kleft;
	static int kDown;
	static int kUp;
	static int i;
	static int j;
	public static void main(String[] args) {

		int [][] arr = {
						{1,1,1},
						{0,1,1},
						{1,9,1}
						};
		
		boolean [][] bool= new boolean [arr.length][arr.length];
		
		for(int i=0; i< arr.length;i++) {
			for(int j=0; j < arr[0].length;j++) {
				bool[i][j]=false;
			}
		}
		boolean [][] visited = new boolean[arr.length][arr.length];
		int [][] dp = new int[arr.length][arr.length];
		for(int i=0; i < arr.length;i++) {
			for(int j=0; j < arr.length;j++) {
				visited[i][j]=false;
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		visited[0][0]=true;
		dp[0][0]=0;
		System.out.println(findSmallestPath(arr,visited,dp,0,0));
		for(int i=0; i < arr.length;i++) {
			for(int j=0; j < arr.length;j++) {
				System.out.print(dp[i][j]+",");
			}
			System.out.println();
		}
	}
	private static int findSmallestPath(int[][] arr, boolean [][] visited, int [][] dp, int i, int j) {
		
		//Right
		
		if(j+1 < arr.length &&!visited[i][j+1] && arr[i][j+1]==1) {
			visited[i][j+1]=true;
			dp[i][j+1]=relax(dp, i, j+1)+1;
			kRight=findSmallestPath(arr, visited, dp, i, j+1);
			
		}
		if(j-1 >=0 &&!visited[i][j-1] && arr[i][j-1]==1) {
			visited[i][j-1]=true;
			dp[i][j-1]=relax(dp, i, j-1)+1;
			kleft=findSmallestPath(arr, visited, dp, i, j-1);
			
		}
		if(i+1 < arr.length && !visited[i+1][j] && arr[i+1][j]==1) {
			visited[i+1][j]=true;
			dp[i+1][j]=relax(dp, i+1, j)+1;
			kDown=findSmallestPath(arr, visited, dp, i+1, j);
			
		}
		if(i-1 >=0 && !visited[i-1][j] && arr[i-1][j]==1) {
			visited[i-1][j]=true;
			dp[i-1][j]=relax(dp, i-1, j)+1;
			kUp=findSmallestPath(arr, visited, dp, i-1, j);
			
		}
		//Found 9
		
		if(j+1 < arr.length &&!visited[i][j+1] && arr[i][j+1]==9) {
				dp[i][j+1]=relax(dp,i,j+1)+1;
				AmazonQuesNew.i=i;
				AmazonQuesNew.j=j+1;
			
			//return 0;
			return dp[i][j+1];
		}
		if(j-1 >=0 &&!visited[i][j-1] && arr[i][j-1]==9) {
			dp[i][j-1]=relax(dp,i,j-1)+1;
				AmazonQuesNew.i=i;
				AmazonQuesNew.j=j-1;
			return dp[i][j-1];
		}
		if(i+1 < arr.length && !visited[i+1][j] && arr[i+1][j]==9) {
			dp[i+1][j]=relax(dp,i+1,j)+1;
				AmazonQuesNew.i=i+1;
				AmazonQuesNew.j=j;
			return dp[i+1][j];
		}
		if(i-1 >=0 && !visited[i-1][j] && arr[i-1][j]==9) {
			dp[i-1][j]=relax(dp,i-1,j)+1;
				AmazonQuesNew.i=i-1;
				AmazonQuesNew.j=j;
			return dp[i-1][j];
		}
		return dp[AmazonQuesNew.i][AmazonQuesNew.j];
		
	}


	private static int relax(int[][] dp, int i, int j) {
		if(i==0 && j==0) //0 0
			return Math.min(Math.min(dp[i][j],dp[i][j]+1),Math.min(dp[i+1][j],dp[i][j]));
		else if(i==0 && j==dp.length-1) {// 0, 2
			return Math.min(dp[i][j-1],dp[i+1][j]);
		}
		else if(i==dp.length-1 && j==0) { // 2,0
			return Math.min(dp[i-1][j], dp[i][j+1]);
		}
		else if(i==dp.length-1 && j== dp.length-1) { //2,2
			return Math.min(dp[i-1][j], dp[i][j-1]);
		}
		else if(j==0 && i < dp.length-1 && i > 0 ) { // X,0
			return Math.min(Math.min(dp[i-1][j], dp[i+1][j]), dp[i][j+1]);
		}
		else if(j==dp.length-1 && i < dp.length-1 && i > 0 ) { //X,2
			return Math.min(Math.min(dp[i-1][j],dp[i+1][j]), dp[i][j-1]);
		}
		else if(i==0 && j < dp.length-1 && j > 0) { //0,X
			return Math.min(Math.min(dp[i][j-1],dp[i][j+1]), dp[i+1][j]);
		}
		else if(i==dp.length-1 && j < dp.length-1 && j > 0) { //2,X
			return Math.min(Math.min(dp[i][j-1],dp[i][j+1]), dp[i-1][j]);
		}
		else {
			return Math.min(Math.min(dp[i-1][j], dp[i+1][j]),
					Math.min(dp[i][j-1], dp[i][j+1]));
		}
		
	}
	

}
