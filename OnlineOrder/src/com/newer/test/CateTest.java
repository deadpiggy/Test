package com.newer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.newer.dao.CateDao;
import com.newer.model.Cate;

public class CateTest {

	public static void main( String[] args ) {
		
		CateDao dao = new CateDao();
		List<Cate> list = dao.getAll();
		for( Cate c : list ) {
			System.out.println( c );
		}

//		List<Cate> list = dao.selectCate( "2003" );
//		for( Cate c : list ) {
//			System.out.println( c );
//		}
		
//		System.out.println( dao.getOne( 35 ) );
		
//		List<Cate> list = dao.getThreeCate();
//		for( Cate c : list ) {
//			System.out.println( c );
//		}
		
//		System.out.println( dao.getRandom( 12 ) );
		
//		System.out.println( dao.getOne( 33 ).getCate_id() );
		
		
//		Random random = new Random();
//		int randomNum = random.nextInt(15) + 1;
//		List<Cate> listThreeCate = new ArrayList<>();
//		for (int i = 0; i < 3; i++) {
//			Cate cateDemo = dao.getRandom(randomNum);
//			listThreeCate.add(cateDemo);
//			randomNum = randomNum + 5;
//		}
//		for( Cate c : listThreeCate ) {
//			System.out.println( c );
//		}
		
		
	}
}