package com.graph;

public class AmazonQuesNew {

	public static void main(String[] args) {

		int [][] arr = {
						{1,1,1},
						{1,1,1},
						{1,9,1}
						};
		
		boolean [][] bool= new boolean [arr.length][arr.length];
		
		for(int i=0; i< arr.length;i++) {
			for(int j=0; j < arr[0].length;j++) {
				bool[i][j]=false;
			}
		}
		Integer count=0;
		System.out.println(findLowestPath(arr, bool,0,0,count));
	}
	
	public static int findLowestPath(int [][] arr, boolean [][] bool, 
			int i, int j,Integer count) {
		//System.out.println("i ::"+i+" & j :"+j);
		
		if(i < 0 || j < 0 || i>=arr.length|| j>= arr.length || (arr[i][j]==0 || bool[i][j])) {
			return Integer.MAX_VALUE;
		}
		
		else if(arr[i][j]==9) {
			//System.out.println("Found 9 at i ::" +i+ " j ::"+j+" with count :: "+count);
			return count;
		}
		else {
			if(!bool[i][j] && arr[i][j]==1) {
			bool[i][j]=true;
			
			int k1=findLowestPath(arr, bool, i, j-1,count+1);
			int k2=findLowestPath(arr, bool, i, j+1,count+1);
			int k3=findLowestPath(arr, bool, i+1, j,count+1);
			int k4=findLowestPath(arr, bool, i-1, j,count+1);
			
			
			System.out.println("k1 :"+k1+" k2 : "+k2+ " k3 : "+k3+" k4 :"+k4);
			
			if(k1!=0 || k2!=0 )
			k1=Math.min(k1, k2);
			if(k3!=0 || k4!=0 )
			k3=Math.min(k3, k4);
			if(k1!=0 ||  k3!=0) {
				
			count=Math.min(k1, k3);
			return count;
			}
			else return 0;
						  
			}
			return count;
		}
	}

}
