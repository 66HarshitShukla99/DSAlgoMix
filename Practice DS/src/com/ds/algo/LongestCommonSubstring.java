package com.ds.algo;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		
		String s1="GeeksForgeeks";
		String s2="GeeksQuiz";
		int l=longestCommonSubsLength(s1,s2);
		
		System.out.println(l);
	}

	private static int longestCommonSubsLength(String s1, String s2) {
		int m=s1.length();
		int n=s2.length();
		int result=0;
		
		int [][] arr= new int[m+1][n+1];
		
		for(int i=0; i <=m;i++) {
			
			for(int j=0; j <=n;j++) {
				if(i==0||j==0)
					arr[i][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					arr[i][j]=1+arr[i-1][j-1];
					result=Integer.max(result, arr[i][j]);
				}
				else arr[i][j]=0;
			}
		}
		StringBuilder sb = new StringBuilder();
		int k=0;
		for(int i=1; i <=m;i++) {
			for(int j=1; j <=n;j++) {
				
				if(arr[i-1][j-1]+1==arr[i][j] && k < result) {
				sb.append(s1.charAt(j-1));
				k++;
				break;
				
				}
				
			}
		}
		System.out.println(sb);
		return result;
	}

}
