package com.ds.algo;

public class MinNoOfInsertionsToFormPalindrome {

	public static void main(String[] args) {

		String s="aabaaza";
		
		int ans=minInsertions(s);
		System.out.println(ans);
	}

	private static int minInsertions(String s) {
		boolean [] T = new boolean[s.length()];
		int i=0;
		int j=s.length()-1;
		
		while(i < j) {
			if(s.charAt(i)==s.charAt(j)) {
				i++;
				j--;
			}
			if(s.charAt(i)!=s.charAt(j)) {
				T[j]=true;
				j--;
			}
		}
		int count=0;
		
		for(boolean b : T)
			if(b) count++;
		return count;
	}

}
