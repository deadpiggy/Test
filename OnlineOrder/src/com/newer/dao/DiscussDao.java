package com.newer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.newer.model.Discuss;
import com.newer.util.DBUtil;

public class DiscussDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	/**
	 * 拿到全部评论
	 * @return
	 */
	public List<Discuss> getAllDis() {
		List<Discuss> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from discuss";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				Discuss dis = new Discuss();
				dis.setDis_id( rs.getInt( 1 ) );
				dis.setCate_id( rs.getInt( 2 ) );
				dis.setUser_name( rs.getString( 3 ) );
				dis.setContent( rs.getString( 4 ) );
				dis.setDis_date( rs.getDate( 5 ) );
				dis.setImg_path( rs.getString( 6 ) );
				list.add( dis );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 单件商品评论详情
	 * @param cate_id
	 * @return
	 */
	public List<Discuss> getCate( int cate_id ) {
		List<Discuss> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from discuss where cate_id=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, cate_id );
			rs = ps.executeQuery();
			while( rs.next() ) {
				Discuss dis = new Discuss();
				dis.setDis_id( rs.getInt( 1 ) );
				dis.setCate_id( rs.getInt( 2 ) );
				dis.setUser_name( rs.getString( 3 ) );
				dis.setContent( rs.getString( 4 ) );
				dis.setDis_date( rs.getDate( 5 ) );
				dis.setImg_path( rs.getString( 6 ) );
				list.add( dis );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 拿到总的评论数
	 * @param cate_id
	 * @return
	 */
	public int getNum() {
		int num = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "select count( demo.rn ) from ( select s.*, rownum rn "
					+ "from (select * from discuss) s order by s.cate_id ) demo ";
			ps = conn.prepareStatement( sql );
			rs = ps.executeQuery();
			while( rs.next() ) {
				num = rs.getInt( 1 );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	
	/**
	 * 从一个菜的所有评论中随机取一条
	 * @param cate_id
	 * @return
	 */
	public Discuss getOneDiscuss( int num ) {
		Discuss dis = new Discuss();

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from ( select d.*, rownum rn from discuss d ) demo where demo.rn=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, num );
			rs = ps.executeQuery();
			while( rs.next() ) {
				dis.setDis_id( rs.getInt( 1 ) );
				dis.setCate_id( rs.getInt( 2 ) );
				dis.setUser_name( rs.getString( 3 ) );
				dis.setContent( rs.getString( 4 ) );
				dis.setDis_date( rs.getDate( 5 ) );
				dis.setImg_path( rs.getString( 6 ) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dis;
	}
	
	/**
	 * 添加评论
	 * @param dis
	 * @return
	 */
	public boolean addDiscuss( Discuss dis ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into discuss values( discuss_seq.nextval, ?, ?, ?, sysdate, ? )";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, dis.getCate_id() );
			ps.setString( 2, dis.getUser_name() );
			ps.setString( 3, dis.getContent() );
			ps.setString( 4, dis.getImg_path() );
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
