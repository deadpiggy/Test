package com.newer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newer.model.Order;
import com.newer.util.DBUtil;

public class OrderDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	/**
	 * 获得订单对象
	 * @param user_id
	 * @return
	 */
	public List<Order> getOrder( int user_id ) {
		List<Order> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select o.id, o.user_id, d.cate_id, d.cate_name, d.price, d.amount from order_num o, detail d "
					+ "where o.id=d.id and o.user_id=? and type=1";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, user_id );
			rs = ps.executeQuery();
			while( rs.next() ) {
				Order order = new Order();
				order.setId( rs.getInt( 1 ) );
				order.setUser_id( rs.getInt( 2 ) );
				order.setCate_id( rs.getInt( 3 ) );
				order.setCate_name( rs.getString( 4 ) );
				order.setPrice( rs.getDouble( 5 ) );
				order.setAmount( rs.getInt( 6 ) );
				list.add( order );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 获得订单Id
	 * @param user_id
	 * @return
	 */
	public List<Integer> getOrderID( int user_id ) {
		List<Integer> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select id from order_num where user_id=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, user_id );
			rs = ps.executeQuery();
			while( rs.next() ) {
				int i = rs.getInt( 1 );
				list.add( i );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 用户具体订单的详细信息
	 * @param user_id
	 * @param id
	 * @return
	 */
	public List<Order> getSingleOrder( int user_id, int id ) {
		List<Order> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select o.id, o.user_id, d.cate_id, d.cate_name, d.price, d.amount, o.address, "
					+ "o.words, d.picture, d.describe, o.status, o.order_date, o.phone, o.type from order_num o, detail d "
					+ "where o.id=d.id and o.user_id=? and o.id=? and type=1";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, user_id );
			ps.setInt( 2, id );
			rs = ps.executeQuery();
			while( rs.next() ) {
				Order order = new Order();
				order.setId( rs.getInt( 1 ) );
				order.setUser_id( rs.getInt( 2 ) );
				order.setCate_id( rs.getInt( 3 ) );
				order.setCate_name( rs.getString( 4 ) );
				order.setPrice( rs.getDouble( 5 ) );
				order.setAmount( rs.getInt( 6 ) );
				order.setAddress( rs.getString( 7 ) );
				order.setWords( rs.getString( 8 ) );
				order.setPicture( rs.getString( 9 ) );
				order.setDescribe( rs.getString( 10 ) );
				order.setStatus( rs.getString( 11 ) );
				order.setDate( rs.getDate( 12 ) );
				order.setPhone( rs.getString( 13 ) );
				order.setType( rs.getInt( 14 ) );
				list.add( order );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 查询所有用户的订单 ????????
	 * @return
	 */
//	public List<Order> getAll() {
//		List<Order> list = new ArrayList<>();
//		conn = DBUtil.getConnection();
//		
//		try {
//			String sql = "select o.id, o.user_id, d.cate_id, d.cate_name, d.price, d.amount, o.address, o.words, d.picture, "
//					+ "d.describe, o.status, o.order_date, o.phone from order_num o, detail d "
//						+ "where o.id=d.id order by o.user_id";
//			ps = conn.prepareStatement( sql );
//			rs = ps.executeQuery();
//			while( rs.next() ) {
//				Order order = new Order();
//				order.setId( rs.getInt( 1 ) );
//				order.setUser_id( rs.getInt( 2 ) );
//				order.setCate_id( rs.getInt( 3 ) );
//				order.setCate_name( rs.getString( 4 ) );
//				order.setPrice( rs.getDouble( 5 ) );
//				order.setAmount( rs.getInt( 6 ) );
//				order.setAddress( rs.getString( 7 ) );
//				order.setWords( rs.getString( 8 ) );
//				order.setPicture( rs.getString( 9 ) );
//				order.setDescribe( rs.getString( 10 ) );
//				order.setStatus( rs.getString( 11 ) );
//				order.setDate( rs.getDate( 12 ) );
//				order.setPhone( rs.getString( 13 ) );
//				list.add( order );
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	
	
}
