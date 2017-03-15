package com.newer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.newer.dao.DiscussDao;
import com.newer.model.Discuss;

public class DiscussTest {
	
	public static void main( String[] args ) {
	
		DiscussDao dao = new DiscussDao();
		
//		System.out.println( dao.getCate( 12 ) );
//		List<Discuss> list = dao.getCate( 34 );
//		for( Discuss dis : list ) {
//			System.out.println( dis );
//		}
		
//		System.out.println( dao.getOneDiscuss( 6 ) );
		
//		System.out.println( dao.getNum() );
		
		
//		Random random = new Random();
//		int num = random.nextInt( dao.getNum()-7 )+1;
//		List<Discuss> listDis = new ArrayList<>();
//		for( int i = 0; i < 3; i++ ) {
//			Discuss dis = dao.getOneDiscuss(num);
//			listDis.add( dis );
//			num = num+2;
//		}
		
		List<Discuss> listDis = dao.getAllDis();
		
		for( Discuss d : listDis ) {
			System.out.println( d );
		}
		
		
		
	}
	
}