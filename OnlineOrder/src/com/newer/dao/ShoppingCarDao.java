package com.newer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newer.model.ShoppingCar;
import com.newer.util.DBUtil;

public class ShoppingCarDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	/**
	 * 查看用户购物车的商品类型数量
	 * @return
	 */
	public int getNum( int user_id ) {
		int listNum=0;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(user_id) from shoppingcar where user_id=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, user_id );
			rs = ps.executeQuery();
			if( rs.next() ) {
				listNum = rs.getInt( 1 );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listNum;
	}
	
	
	/**
	 * 查询用户的购物车详情
	 * @param user_id
	 * @return
	 */
	public List<ShoppingCar> getAll( int user_id ) {
		List<ShoppingCar> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from shoppingcar where user_id=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, user_id );
			rs = ps.executeQuery();
			while( rs.next() ) {
				ShoppingCar sc = new ShoppingCar();
				sc.setSid( rs.getInt( 1 ) );
				sc.setCate_id( rs.getInt( 2 ) );
				sc.setCate_name( rs.getString( 3 ) );
				sc.setPrice( rs.getDouble( 4 ) );
				sc.setAmount( rs.getInt( 5 ) );
				sc.setUser_id( rs.getInt( 6 ) );
				sc.setPicture( rs.getString( 7 ) );
				list.add( sc );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 根据商品id 和用户id 查购物车单件商品
	 * @param user_id
	 * @param cate_id
	 * @return
	 */
	public ShoppingCar getOne( int user_id, int cate_id ) {
		ShoppingCar sc = new ShoppingCar();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from shoppingcar where user_id=? and cate_id=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, user_id );
			ps.setInt( 2, cate_id );
			rs = ps.executeQuery();
			if( rs.next() ) {
				sc.setSid( rs.getInt( 1 ) );
				sc.setCate_id( rs.getInt( 2 ) );
				sc.setCate_name( rs.getString( 3 ) );
				sc.setPrice( rs.getDouble( 4 ) );
				sc.setAmount( rs.getInt( 5 ) );
				sc.setUser_id( rs.getInt( 6 ) );
				sc.setPicture( rs.getString( 7 ) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sc;
	}
	
	
	/**
	 * 给购物车添加新商品
	 * @param sc
	 * @return
	 */
	public boolean addSC( ShoppingCar sc ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into shoppingcar values(shoppingcar_seq.nextval,?,?,?,?,?,?)";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, sc.getCate_id() );
			ps.setString( 2, sc.getCate_name() );
			ps.setDouble( 3, sc.getPrice() );
			ps.setInt( 4, sc.getAmount() );
			ps.setInt( 5, sc.getUser_id() );
			ps.setString( 6, sc.getPicture() );
			int rows = ps.executeUpdate();
			if( rows > 0 ) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * 删除购物车商品
	 * @param sid
	 * @return
	 */
	public boolean deleteSc( int sid ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete shoppingcar where sid=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, sid );
			int rows = ps.executeUpdate();
			if( rows > 0 ) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * 给已有商品添加数量
	 * @param num
	 * @param sid
	 * @return
	 */
	public boolean updateSC( int num, int cate_id ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update shoppingcar set amount=? where cate_id=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, num );
			ps.setInt( 2, cate_id );
			int rows = ps.executeUpdate();
			if( rows > 0 ) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * 删除用户购物车所有商品
	 * @return
	 */
	public boolean dropSC( int user_id ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete shoppingcar where user_id=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, user_id );
			int rows = ps.executeUpdate();
			if( rows > 0 ) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
