package com.newer.bignumber;

import java.util.Scanner;

public class BigBigNumberAdd {

	public static String computerBigNumber(String s1, String s2) {

		String s = "";
		
		if (s1.length() > s2.length()) {
			int length = 0;
			int abs = Math.abs(s1.length() - s2.length());// 1
			length = s1.length()+1;
			char[] ch = new char[length];
			int sum = 0;
			boolean flag1 = false;
			boolean flag2 = false;

			for (int i = s1.length() - 1; i >= abs; i--) {
				if (flag1 == false) {
					sum = (s1.charAt(i) - '0') + (s2.charAt(i - abs) - '0');// 10
					flag2 = false;
				} else {
					sum = (s1.charAt(i) - '0') + (s2.charAt(i - abs) - '0') + 1;// 11
					flag1 = false;// false
					flag2 = true;// true
				}
				if (sum < 10) {
					ch[i + 1] = (char) (sum + 48);
				} else {
					ch[i + 1] = (char) (sum % 10 + 48);// 0
					flag1 = true;// true true
					flag2 = true;
				}
			}
			// --------------------------------------------------
			// 计算s2之后的数---------------------------------------------------
			for (int j = abs - 1; j >= 0; j--) {
				if (flag2 == false) {
					ch[j + 1] = (char) ((s1.charAt(j) - '0') % 10 + 48);
				} else {
					// ch[ j + 1 ] = ( char )((s1.charAt( j )-'0')+1+48);
					ch[j + 1] = (char) (((s1.charAt(j) - '0') + 1) % 10 + 48);
					if ((s1.charAt(j) - '0' + 1) < 10) {
						flag2 = false;
					} else {
						flag2 = true;
					}
				}
			}
			// -----------------------------------------------
			// 打印出ch2数组第一个数------------------------------------------------
			if ((ch[1] - '0') + (s1.charAt(0) - '0') < 10) {
				if (ch[1] - '0' == 0) {
					ch[0] = '1';
				} else {
					ch[0] = ' ';
				}
			} else {
				ch[0] = '1';
			}
			String s3 = new String(ch);
			s = s3;
			//==============================s1<s2的情况=====================================
		} else if( s1.length()<s2.length() ) {
			int length = 0;
			int abs = Math.abs(s1.length() - s2.length());// 1
			length = s2.length()+1;
			char[] ch = new char[length];
			int sum = 0;
			boolean flag1 = false;
			boolean flag2 = false;

			for (int i = s2.length() - 1; i >= abs; i--) {
				if (flag1 == false) {
					sum = (s2.charAt(i) - '0') + (s1.charAt(i - abs) - '0');//10
					flag2 = false;
				} else {
					sum = (s2.charAt(i) - '0') + (s1.charAt(i - abs) - '0') + 1;//11
					flag1 = false;//false
					flag2 = true;//true
				}
				if (sum < 10) {
					ch[i + 1] = (char) (sum + 48);
				} else {
					ch[i + 1] = (char) (sum % 10 + 48);//0
					flag1 = true;//true true
					flag2 = true;
				}
			}
			//-------------------------------------------------- 计算s2之后的数---------------------------------------------------
			for (int j = abs-1; j >= 0; j--) {
				if( flag2 == false ) {
					ch[j + 1] = ( char )((s2.charAt(j)-'0')%10+48);
				}else {
//					ch[ j + 1 ] = ( char )((s1.charAt( j )-'0')+1+48);
					ch[ j + 1 ] = ( char )( ((s2.charAt( j )-'0')+1)%10+48 );
					if( (s2.charAt( j )-'0'+1) <10 ) {
						flag2 = false;
					}else {
						flag2 = true;
					}
				}
			}
			//----------------------------------------------- 打印出ch2数组第一个数------------------------------------------------
			if( (ch[ 1 ]-'0')+(s2.charAt( 0 )-'0') < 10 ) {
				if( ch[ 1 ]-'0' == 0 ) {
					ch[ 0 ] = '1';
				}else {
					ch[ 0 ] = ' ';
				}
			}else {
				ch[ 0 ] = '1';
			}
			String s3 = new String(ch);
			return s3;
		}
		//================================s1 = s2的情况=======================================
		else if( s1.length() == s2.length() ){
			int length = 0;
			int abs = Math.abs(s1.length() - s2.length());// 1
			length = s1.length()+1;
			char[] ch = new char[length];
			int sum = 0;
			boolean flag1 = false;
			boolean flag2 = false;

			for (int i = s1.length() - 1; i >= abs; i--) {
				if (flag1 == false) {
					sum = (s1.charAt(i) - '0') + (s2.charAt(i - abs) - '0');
					flag2 = false;
				} else {
					sum = (s1.charAt(i) - '0') + (s2.charAt(i - abs) - '0') + 1;
					flag1 = false;
					flag2 = true;
				}
				if (sum < 10) {
					ch[i + 1] = (char) (sum + 48);
				} else {
					ch[i + 1] = (char) (sum % 10 + 48);
					flag1 = true;
					flag2 = true;
				}
			}
			//-------------------------------------------------- 计算s2之后的数---------------------------------------------------

			//----------------------------------------------- 打印出ch2数组第一个数------------------------------------------------
			if( (s2.charAt( 0 )-'0')+(s1.charAt( 0 )-'0')<10 ) {
				ch[ 0 ] = ' ';
			}else {
				ch[ 0 ] = '1';
			}
			String s3 = new String( ch );
			s = s3;
		}
		
		//返回String型的s
		return s;
	}

	public static void main(String[] args) {

//		String s1 = "999";
//		String s2 = "999";
		
		Scanner sc = new Scanner( System.in );
		System.out.println( "请输入一个正整数：" );
		String s1 = sc.nextLine();
		System.out.println( "请输入一个正整数：" );
		String s2 = sc.nextLine();

		System.out.println(computerBigNumber(s1, s2).toString());

	}
}
