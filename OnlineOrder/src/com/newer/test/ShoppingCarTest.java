package com.newer.test;

import java.util.List;

import com.newer.dao.ShoppingCarDao;
import com.newer.model.ShoppingCar;

public class ShoppingCarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ShoppingCarDao dao = new ShoppingCarDao();
//		System.out.println( dao.getNum( 3 ) );
//		System.out.println( dao.getAll( 2 ) );
//		System.out.println( dao.getOne( 2, 11 ) );
//		System.out.println( dao.getOne(2,  12) );
//		System.out.println( dao.getOne( 2, 12 ).getCate_id() );
//		System.out.println( dao.getOne( 2, 12 ).getAmount() );
//		
		
		
//		boolean flag = dao.deleteSc( 13 );
		
//		ShoppingCar sc = new ShoppingCar( 10, "西红柿炒蛋", 14, 2, 2 );
//		boolean flag = dao.addSC( sc );
		
//		boolean flag = dao.updateSC( 3, 1 );

//		boolean flag = dao.updateSC( 2, 12 );
//		if( flag ) {
//			System.out.println( "succed" );
//		}else {
//			System.out.println( "fail" );
//		}
		
		
		List<ShoppingCar> list = dao.getAll( 2 );
		for( ShoppingCar sc : list ) {
			System.out.println( sc );
		}
		
		
		
	}

}
