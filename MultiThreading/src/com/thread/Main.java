package com.thread;

public class Main {

	public static void main(String[] args) {

		String s="TRAX_UTIP_TRAN_1_20180523";//1234.CSV";
		
		String date="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
		
		String regex="TRAX_UTIP_TRAN_[0-9]{1,8}_"+date;//+".*";//+"[0-9]{4}"+".CSV";
		
		boolean x= "29-04-2019".matches(date);
		//System.out.println(x);
		boolean b= s.matches(regex);
		System.out.println(b);
		
	}
	

}
