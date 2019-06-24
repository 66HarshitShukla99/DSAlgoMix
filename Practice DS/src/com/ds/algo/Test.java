package com.ds.algo;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {

		findNoOfPowerSum(25,30);
	}
	    
    public static int findNoOfPowerSum(int i,int j){
        int X=0;
        int n1=1;
        int n2=0;
        Set<Integer> l= calculateNumTill(i);
 
        Set<Integer> m= calculateNumTill(j);    
        
        Set<Integer> s = new TreeSet<>();
        
        for(Integer  h : l) {
        	if(h >=i && h <= j)
        		s.add(h);
        }
        for(Integer  h : m) {
        	if(h >=i && h <= j)
        		s.add(h);
        }
        int num=0;
        int count=s.size();
        
        return 0;
        
}

    public static Set<Integer> calculateNumTill(int K){
        Set<Integer> set = new LinkedHashSet<>();
            int base=2;
            int exponent=2;
            while(base <= K){
                while((int)Math.pow(base,exponent) <= K){
                    set.add((int)Math.pow(base,exponent));
                    exponent++;
                }
                exponent=2;
                base++;
            }
            return set;
        }
}
