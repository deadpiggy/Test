package com.newer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newer.model.Cate;
import com.newer.util.DBUtil;

public class PageDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	/**
	 * 查询数据条数
	 * @return
	 */
	public int selectPageRows() {
		int count = 0;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select count( cate_id ) from Cate";
			ps = conn.prepareStatement( sql );
			rs = ps.executeQuery();
			if( rs.next() ) {
				count = rs.getInt( 1 );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	

	
	
	
	
	
	
}
