package com.newer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newer.model.Tuser;
import com.newer.util.DBUtil;

public class TuserDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Tuser> getAll() {
		List<Tuser> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Tuser";
			ps = conn.prepareStatement( sql );
			rs = ps.executeQuery();
			while( rs.next() ) {
				Tuser t = new Tuser();
				t.setUser_id( rs.getInt( "user_id" ) );
				t.setUser_name( rs.getString( "user_name" ) );
				t.setCh_name( rs.getString( "ch_name" ) );
				t.setPassword( rs.getString( "password" ) );
				t.setMobile( rs.getString( "mobile" ) );
				t.setSex( rs.getString( "sex" ) );
				t.setType( rs.getInt( "type" ) );
				t.setAddress( rs.getString( "address" ) );
				t.setEmail( rs.getString( "email" ) );
				list.add( t );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询所有普通用户
	 * @return
	 */
	public List<Tuser> getCommon() {
		List<Tuser> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Tuser where type=1 order by user_id";
			ps = conn.prepareStatement( sql );
			rs = ps.executeQuery();
			while( rs.next() ) {
				Tuser t = new Tuser();
				t.setUser_id( rs.getInt( "user_id" ) );
				t.setUser_name( rs.getString( "user_name" ) );
				t.setCh_name( rs.getString( "ch_name" ) );
				t.setPassword( rs.getString( "password" ) );
				t.setMobile( rs.getString( "mobile" ) );
				t.setSex( rs.getString( "sex" ) );
				t.setType( rs.getInt( "type" ) );
				t.setAddress( rs.getString( "address" ) );
				t.setEmail( rs.getString( "email" ) );
				list.add( t );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 获得所有管理员
	 * @return
	 */
	public List<Tuser> getManage() {
		List<Tuser> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Tuser where type=2 order by user_id";
			ps = conn.prepareStatement( sql );
			rs = ps.executeQuery();
			while( rs.next() ) {
				Tuser t = new Tuser();
				t.setUser_id( rs.getInt( "user_id" ) );
				t.setUser_name( rs.getString( "user_name" ) );
				t.setCh_name( rs.getString( "ch_name" ) );
				t.setPassword( rs.getString( "password" ) );
				t.setMobile( rs.getString( "mobile" ) );
				t.setSex( rs.getString( "sex" ) );
				t.setType( rs.getInt( "type" ) );
				t.setAddress( rs.getString( "address" ) );
				t.setEmail( rs.getString( "email" ) );
				list.add( t );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 通过输入的用户名密码来确认用户
	 * @param loginName
	 * @param loginPass
	 * @return
	 */
	public Tuser getOne( String loginName, String loginPass ) {
		Tuser t = new Tuser();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Tuser where user_name=? and password=?";
			ps = conn.prepareStatement( sql );
			ps.setString( 1, loginName );
			ps.setString( 2, loginPass );
			rs = ps.executeQuery();
			if( rs.next() ) {
				t.setUser_id( rs.getInt( "user_id" ) );
				t.setUser_name( rs.getString( "user_name" ) );
				t.setCh_name( rs.getString( "ch_name" ) );
				t.setPassword( rs.getString( "password" ) );
				t.setMobile( rs.getString( "mobile" ) );
				t.setSex( rs.getString( "sex" ) );
				t.setType( rs.getInt( "type" ) );
				t.setAddress( rs.getString( "address" ) );
				t.setEmail( rs.getString( "email" ) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 通过user_id来获得用户对象
	 * @param user_id
	 * @return
	 */
	public Tuser selectOne( int user_id ) {
		Tuser t = new Tuser();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Tuser where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, user_id );
			rs = ps.executeQuery();
			while( rs.next() ) {
				t.setUser_id( rs.getInt( 1 ) );
				t.setUser_name( rs.getString( 2 ) );
				t.setCh_name( rs.getString( 3 ) );
				t.setPassword( rs.getString( 4 ) );
				t.setMobile( rs.getString( 5 ) );
				t.setSex( rs.getString( 6 ) );
				t.setType( rs.getInt( 7 ) );
				t.setAddress( rs.getString( 8 ) );
				t.setEmail( rs.getString( 9 ) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 更改用户权限
	 * @param type
	 * @param user_id
	 * @return
	 */
	public boolean upUser( int type, int user_id ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update Tuser set type=? where user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, type );
			ps.setInt( 2, user_id );
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
	 * 添加普通用户
	 * @param user
	 * @return
	 */
	public boolean addOne( Tuser user ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into Tuser values( Tuser_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ? )";
			ps = conn.prepareStatement( sql );
			ps.setString( 1, user.getUser_name() );
			ps.setString( 2, user.getCh_name() );
			ps.setString( 3, user.getPassword() );
			ps.setString( 4, user.getMobile() );
			ps.setString( 5, user.getSex() );
			ps.setInt( 6, user.getType() );
			ps.setString( 7, user.getAddress() );
			ps.setString( 8, user.getEmail() );
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
	 * 更改用户密码
	 * @param user
	 * @return
	 */
	public boolean updatePWD( int user_id, String password ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update Tuser set  password=? where user_id=?";
			ps = conn.prepareStatement( sql );
			ps.setString( 1, password );
			ps.setInt( 2, user_id );
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
