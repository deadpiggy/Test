package com.newer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newer.model.Detail;
import com.newer.util.DBUtil;

public class DetailDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	/**
	 * 添加detail对象
	 * @param detail
	 * @return
	 */
	public boolean addDetail( Detail detail ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into detail values( detail_seq.nextval, ?, ?, ?, ?, ?, ?, ? )";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, detail.getCate_id() );
			ps.setInt( 2, detail.getId() );
			ps.setInt( 3, detail.getAmount() );
			ps.setString( 4, detail.getCate_name() );
			ps.setDouble( 5, detail.getPrice() );
			ps.setString( 6, detail.getPicture() );
			ps.setString( 7, detail.getDescribe() );
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
	 * 拿到商品
	 * @param id
	 * @return
	 */
	public List<Detail> getNum( int id ) {
		List<Detail> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from detail where id=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, id );
			rs = ps.executeQuery();
			while( rs.next() ) {
				Detail d = new Detail();
				d.setCate_name( rs.getString( 5 ) );
				list.add( d );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
