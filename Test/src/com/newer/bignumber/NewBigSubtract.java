package com.newer.bignumber;

public class NewBigSubtract {

	public static String compute(String s1, String s2) {

		char[] ch = new char[s1.length()];
		int abs = s1.length() - s2.length();
		boolean flag = false; // flag = false, 说明没有向前一位借1， flag = true, 代表向前一位借1

		for (int i = s1.length() - 1; i >= 0; i--) {
			if (i >= abs) {
				int a = s1.charAt(i) - '0';
				int b = s2.charAt(i - abs) - '0';

				if (flag == false) {
					if (a >= b) {
						ch[i] = (char) (a - b + 48);
					} else {
						ch[i] = (char) (a + 10 - b + 48);
						flag = true;
					}
				} else {
					if (a - 1 >= b) {
						ch[i] = (char) (a - b - 1 + 48);
						flag = false;
					} else {
						ch[i] = (char) (a - 1 + 10 - b + 48);
					}
				}
			} else {// -----------------------------------------------------------------------------------------------------------------------
				int c = s1.charAt(i) - '0';
				if (flag == true) {
					if (c - 1 >= 0) {
						ch[i] = (char) (c - 1 + 48);
						flag = false;
					} else {
						ch[i] = (char) (c + 10 - 1 + 48);
					}
				}else {
					ch[ i ] = s1.charAt( i );
				}
			}
		}
	//------------------判断第一位是否为0---------------
		if( ch[ 0 ] == '0' ) {
			ch[ 0 ] = ' ';
		} 

		// for (int j = abs - 1; j >= 0; j--) {
		//
		// }

		String s3 = new String(ch);
		return s3;
	}

	public static void main(String[] args) {

		// String s1 = "2222";
		// String s2 = "11";

		// String s1 = "12345";
		// String s2 = "216";

//		String s1 = "1000";
//		String s2 = "1";
		
		String s1 = "121232425323221";
		String s2 = "899897890878";
		
		
		

		System.out.println(compute(s1, s2).toString());

	}
	
}
