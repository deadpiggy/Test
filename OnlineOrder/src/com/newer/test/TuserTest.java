package com.newer.test;

import java.util.List;

import com.newer.dao.TuserDao;
import com.newer.model.Tuser;

public class TuserTest {

	public static void main( String[] args ) {
		
		TuserDao dao = new TuserDao();
		List<Tuser> list = dao.getAll();
		
//		Tuser t = dao.getOne( "1001",  "123" );
//		System.out.println( t );
		
//		for( Tuser t : list ) {
//			System.out.println( t );
//		}
//		System.out.println();
//		boolean flag = dao.updatePWD( 11, "111111" );
//		if( flag ) {
//			List<Tuser> list1 = dao.getAll();
//			for( Tuser t : list1 ) {
//				System.out.println( t );
//			}
//		}
		
		System.out.println( dao.selectOne( 11 ) );
		
	}	
}