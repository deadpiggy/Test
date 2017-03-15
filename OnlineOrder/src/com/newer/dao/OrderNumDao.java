package com.newer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newer.model.OrderNum;
import com.newer.model.OrderNumPojo;
import com.newer.util.DBUtil;
import com.newer.util.StringUtil;

public class OrderNumDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/**
	 * 添加orderNum对象
	 * @param on
	 * @return
	 */
	public boolean addOrder( OrderNum on ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into order_num values( order_num_seq.nextval, ?, sysdate, ?, ? ,? ,?, ? )";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, on.getUser_id() );
			ps.setInt( 2, on.getType() );
			ps.setString( 3, on.getAddress() );
			ps.setString( 4, on.getWords() );
			ps.setString( 5, on.getStatus() );
			ps.setString( 6, on.getPhone() );
			int rows = ps.executeUpdate();
			if( rows > 0 ) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		return flag;
	}
	
	
	/**
	 * 得到订单id
	 * @param on
	 * @return
	 */
	public int getOrderId( OrderNum on ) {
		int id = 0;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select id from order_num where user_id=? and type=? and address=? and words=? and status=? and phone=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, on.getUser_id() );
			ps.setInt( 2, on.getType() );
			ps.setString( 3, on.getAddress() );
			ps.setString( 4, on.getWords() );
			ps.setString( 5, on.getStatus() );
			ps.setString( 6, on.getPhone() );
			rs = ps.executeQuery();
			if( rs.next() ) {
				id = rs.getInt( 1 );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  id;
	}
	
	
	/**
	 * 获得所有订单, 分页
	 * @return
	 */
	public List<OrderNum> getAll( int pageNo,int pageSize ) {
		List<OrderNum> list = new ArrayList<>();
		int startNo=(pageNo-1)*pageSize+1;//起始记录数
		int endNo=pageNo*pageSize;//结束记录数
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from(select row_number() over(order by id ) rn ,p.* from order_num p) "
					+ "where rn between ? and ?";

			ps = conn.prepareStatement( sql );
			ps.setInt( 1, startNo );
			ps.setInt( 2, endNo );
			rs = ps.executeQuery();
			while( rs.next() ) {
				OrderNum on = new OrderNum();
				on.setId( rs.getInt( 2 ) );
				on.setUser_id( rs.getInt( 3 ) );
				on.setOrder_date( rs.getDate( 4 ) );
				on.setType( rs.getInt( 5 ) );
				on.setAddress( rs.getString( 6 ) );
				on.setWords( rs.getString( 7 ) );
				on.setStatus( rs.getString( 8 ) );
				on.setPhone( rs.getString( 9 ) );
				list.add( on );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 模糊查询
	 * @param pojo
	 * @return
	 */
	public List<OrderNum> selectMoHu( OrderNumPojo pojo ) {
		List<OrderNum> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from order_num where 1=1";
			//模糊查询
			if(pojo.getUser_id()>0){
				sql+=" and user_id="+pojo.getUser_id();
			}
			if(pojo.getId1()>0&&pojo.getId2()==0){
				sql+=" and id="+pojo.getId1();
			}
			if(pojo.getId1()==0&&pojo.getId2()>0){
				sql+=" and id="+pojo.getId2();
			}
			if(pojo.getId1()>0&&pojo.getId2()>0&&pojo.getId1()>=pojo.getId2()){
				sql+=" and id between "+pojo.getId2()+" and "+pojo.getId1();
			}
			if(pojo.getId1()>0&&pojo.getId2()>0&&pojo.getId1()<=pojo.getId2()){
				sql+=" and id between "+pojo.getId1()+" and "+pojo.getId2();
			}
			if(StringUtil.isFems(pojo.getStatus())){
				sql+=" and status like '%"+pojo.getStatus()+"%'";
			}
			if(StringUtil.isFems(pojo.getOrder_date())){
				sql+=" and order_date like '%"+pojo.getOrder_date()+"%'";
			}
			ps = conn.prepareStatement( sql );
			rs = ps.executeQuery();
			while( rs.next() ) {
				OrderNum on = new OrderNum();
				on.setId( rs.getInt( 1 ) );
				on.setUser_id( rs.getInt( 2 ) );
				on.setOrder_date( rs.getDate( 3 ) );
				on.setType( rs.getInt( 4 ) );
				on.setAddress( rs.getString( 5 ) );
				on.setWords( rs.getString( 6 ) );
				on.setStatus( rs.getString( 7 ) );
				on.setPhone( rs.getString( 8 ) );
				list.add( on );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 获得订单分页的所有条数
	 * @param list
	 * @return
	 */
	public int selectAllRows(){
		int count=0;
		String sql="select count(id) from order_num";
		
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(conn, ps, rs);
		}
		return count;
	}
	
	
	/**
	 * 更改订单状态
	 * @param papi
	 * @param id
	 * @return
	 */
	public boolean takeOrder( int papi, int id ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update order_num set status=? where id=?";
			ps = conn.prepareStatement( sql );
			if( papi == 2 ) {
				ps.setString( 1, "已收货" );
				ps.setInt( 2, id );
				int rows = ps.executeUpdate();
				if( rows > 0 ) {
					flag = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 更改订单的 type
	 * @param type
	 * @param id
	 * @return
	 */
	public boolean changeType( int type, int id ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update order_num set type=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt( 1, type );
			ps.setInt( 2, id );
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
