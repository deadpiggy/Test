package com.newer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.newer.model.Cate;
import com.newer.model.CatePojo;
import com.newer.util.DBUtil;
import com.newer.util.StringUtil;

public class CateDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	/**
	 * 查询数据条数
	 * 
	 * @return
	 */
	public int selectPageRows() {
		int count = 0;

		try {
			conn = DBUtil.getConnection();
			String sql = "select count( cate_id ) from Cate";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 首页
	 * 分页，所有商品查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Cate> selectByPage(int pageNo, int pageSize) {
		List<Cate> list = new ArrayList<>();
		int pageStart = (pageNo - 1) * pageSize + 1; // 页面开始位置
		int pageLast = pageNo * pageSize; // 结束位置

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from ( select row_number() over( order by cate_id ) rn, c.* from Cate c ) "
					+ "where rn between ? and ? and status=1";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pageStart);
			ps.setInt(2, pageLast);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cate cate = new Cate();
				cate.setCate_id(rs.getInt("cate_id"));
				cate.setCate_name(rs.getString("cate_name"));
				cate.setPrice(rs.getDouble("price"));
				cate.setImg_path(rs.getString("img_path"));
				cate.setDescribe(rs.getString("describe"));
				cate.setType( rs.getString( "type" ) );
				cate.setSpeces( rs.getString( "speces" ) );
				cate.setStatus( rs.getInt( "status" ) );
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * 后台
	 * 分页，所有商品查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Cate> selectByPage1(int pageNo, int pageSize) {
		List<Cate> list = new ArrayList<>();
		int pageStart = (pageNo - 1) * pageSize + 1; // 页面开始位置
		int pageLast = pageNo * pageSize; // 结束位置

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from ( select row_number() over( order by cate_id ) rn, c.* from Cate c ) "
					+ "where rn between ? and ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pageStart);
			ps.setInt(2, pageLast);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cate cate = new Cate();
				cate.setCate_id(rs.getInt("cate_id"));
				cate.setCate_name(rs.getString("cate_name"));
				cate.setPrice(rs.getDouble("price"));
				cate.setImg_path(rs.getString("img_path"));
				cate.setDescribe(rs.getString("describe"));
				cate.setType( rs.getString( "type" ) );
				cate.setSpeces( rs.getString( "speces" ) );
				cate.setStatus( rs.getInt( "status" ) );
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	/**
	 * 商品的模糊查询
	 * @param pojo
	 * @return
	 */
	public List<Cate> getSelectAll( CatePojo pojo ) {
		List<Cate> list = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Cate where 1=1 and status=1";
			
			//模糊查询
			if(pojo.getCate_id1()>0&&pojo.getCate_id2()==0){
				sql+=" and cate_id="+pojo.getCate_id1();
			}
			if(pojo.getCate_id1()==0&&pojo.getCate_id2()>0){
				sql+=" and cate_id="+pojo.getCate_id2();
			}
			if(pojo.getCate_id1()>0&&pojo.getCate_id2()>0&&pojo.getCate_id1()>=pojo.getCate_id2()){
				sql+=" and cate_id between "+pojo.getCate_id2()+" and "+pojo.getCate_id1();
			}
			if(pojo.getCate_id1()>0&&pojo.getCate_id2()>0&&pojo.getCate_id1()<=pojo.getCate_id2()){
				sql+=" and cate_id between "+pojo.getCate_id1()+" and "+pojo.getCate_id2();
			}
			if(StringUtil.isFems(pojo.getCate_name())){
				sql+=" and cate_name like '%"+pojo.getCate_name()+"%'";
			}
			if( pojo.getPrice()>0 ){
				sql+=" and price like '%"+pojo.getPrice()+"%'";
			}
			ps = conn.prepareStatement( sql );
			rs = ps.executeQuery();
			while( rs.next() ) {
				Cate cate = new Cate();
				cate.setCate_id(rs.getInt("cate_id"));
				cate.setCate_name(rs.getString("cate_name"));
				cate.setPrice(rs.getDouble("price"));
				cate.setImg_path(rs.getString("img_path"));
				cate.setDescribe(rs.getString("describe"));
				cate.setType( rs.getString( "type" ) );
				cate.setSpeces( rs.getString( "speces" ) );
				cate.setStatus( rs.getInt( "status" ) );
				list.add(cate);
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
		String sql="select count(cate_id) from Cate";
		
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
	 * 查询所有商品
	 * 
	 * @return
	 */
	public List<Cate> getAll() {
		List<Cate> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Cate order by cate_id";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cate cate = new Cate();
				cate.setCate_id(rs.getInt("cate_id"));
				cate.setCate_name(rs.getString("cate_name"));
				cate.setPrice(rs.getDouble("price"));
				cate.setImg_path(rs.getString("img_path"));
				cate.setDescribe(rs.getString("describe"));
				cate.setType(rs.getString("type"));
				cate.setSpeces(rs.getString("speces"));
				cate.setStatus(rs.getInt("status"));
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * 上下架商品
	 * @param cate_id
	 * @return
	 */
	public boolean ChangeStatus( int cate_id, int status ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update Cate set status=? where cate_id=?";
			ps = conn.prepareStatement( sql );
			ps.setInt( 1, status );
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
	 * 修改商品内容
	 * @param cate
	 * @return
	 */
	public boolean updateCate( Cate cate ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "update Cate set cate_name=?, price=?, img_path=?, describe=?, type=?, speces=? where cate_id=?";
			ps = conn.prepareStatement( sql );
			ps.setString( 1, cate.getCate_name() );
			ps.setDouble( 2, cate.getPrice() );
			ps.setString( 3, cate.getImg_path() );
			ps.setString( 4, cate.getDescribe() );
			ps.setString( 5, cate.getType() );
			ps.setString( 6, cate.getSpeces() );
			ps.setInt( 7, cate.getCate_id() );
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
	 * 添加商品
	 * @param cate
	 * @return
	 */
	public boolean addCate( Cate cate ) {
		boolean flag = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into Cate values( Cate_seq.nextval,?, ?, ?, ?, ?, ?, 1 )";
			ps = conn.prepareStatement( sql );
			ps.setString( 1, cate.getCate_name() );
			ps.setDouble( 2, cate.getPrice() );
			ps.setString( 3, cate.getImg_path() );
			ps.setString( 4, cate.getDescribe() );
			ps.setString( 5, cate.getType() );
			ps.setString( 6, cate.getSpeces() );
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
	
	/*
	 * 带文件上传的添加商品
	 */
	public int addCateDemo( Cate cate ) {
		int cate_id = 0;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into Cate values( Cate_seq.nextval,?, ?, ?, ?, ?, ?, 1 )";
			ps = conn.prepareStatement( sql );
			ps.setString( 1, cate.getCate_name() );
			ps.setDouble( 2, cate.getPrice() );
			ps.setString( 3, cate.getImg_path() );
			ps.setString( 4, cate.getDescribe() );
			ps.setString( 5, cate.getType() );
			ps.setString( 6, cate.getSpeces() );
			int rows = ps.executeUpdate();
			if( rows > 0 ) {
				sql = "select Cate_seq.currval from dual";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				if( rs.next() ) {
					cate_id = rs.getInt( 1 );
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cate_id;
	}
	
	/*
	 * 按id更改图片路径
	 */
	public boolean updatePicture(Cate cate){
		boolean flag = false;
		String sql = "update Cate set img_path=? where cate_id=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cate.getImg_path());
			ps.setInt(2, cate.getCate_id());
			
			int rows = ps.executeUpdate();
			if(rows>0){
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		return flag;
	}
	
	/**
	 * 根据id查看商品详情
	 * 
	 * @param id
	 * @return
	 */
	public Cate getOne(int id) {
		Cate cate = new Cate();

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Cate where cate_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				cate.setCate_id(rs.getInt("cate_id"));
				cate.setCate_name(rs.getString("cate_name"));
				cate.setPrice(rs.getDouble("price"));
				cate.setImg_path(rs.getString("img_path"));
				cate.setDescribe(rs.getString("describe"));
				cate.setType(rs.getString("type"));
				cate.setSpeces(rs.getString("speces"));
				cate.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cate;
	}

	/**
	 * 通过菜系查找菜品
	 * 
	 * @param type
	 * @return
	 */
	public List<Cate> selectCate(String type) {
		List<Cate> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from Cate where type=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cate cate = new Cate();
				cate.setCate_id(rs.getInt(1));
				cate.setCate_name(rs.getString(2));
				cate.setPrice(rs.getDouble(3));
				cate.setImg_path(rs.getString(4));
				cate.setDescribe(rs.getString(5));
				cate.setType(rs.getString(6));
				cate.setSpeces(rs.getString(7));
				cate.setStatus(rs.getInt(8));
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * 随机生成三个推荐菜
	 * 
	 * @return
	 */
	public List<Cate> getThreeCate() {
		Random random = new Random();
		int num = random.nextInt(20) + 1;
		List<Cate> list = new ArrayList<>();
		conn = DBUtil.getConnection();

		try {
			String sql = "select * from ( select c.*, rownum rn from "
					+ "( select * from Cate ) c order by rn ) demo where demo.rn=? or demo.rn=? or demo.rn=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num );
			ps.setInt( 2, num+3 );
			ps.setInt( 3, num+6 );
			rs = ps.executeQuery();
			while(rs.next()) {
				Cate cate = new Cate();
				cate.setCate_id(rs.getInt(1));
				cate.setCate_name(rs.getString(2));
				cate.setPrice(rs.getDouble(3));
				cate.setImg_path(rs.getString(4));
				cate.setDescribe(rs.getString(5));
				cate.setType(rs.getString(6));
				cate.setSpeces(rs.getString(7));
				cate.setStatus(rs.getInt(8));
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 随机生成一个菜
	 * 
	 * @return
	 */
	public Cate getRandom( int randomNum ) {
		Cate cate = new Cate();
		conn = DBUtil.getConnection();

		try {
			String sql = "select * from ( select c.*, rownum rn from "
					+ "( select * from Cate ) c order by rn ) demo where demo.rn=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, randomNum );
			rs = ps.executeQuery();
			if(rs.next()) {
				cate.setCate_id(rs.getInt(1));
				cate.setCate_name(rs.getString(2));
				cate.setPrice(rs.getDouble(3));
				cate.setImg_path(rs.getString(4));
				cate.setDescribe(rs.getString(5));
				cate.setType(rs.getString(6));
				cate.setSpeces(rs.getString(7));
				cate.setStatus(rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cate;
	}
	
	/**
	 * 通过Cate对象，获得cate_id
	 * @param cate
	 * @return
	 */
	public int getCateID( Cate cate ) {
		int cate_id = 0;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select cate_id from Cate where cate_name=? and price=? "
					+ "and img_path=? and describe=? and type=? and speces=? and status=? ";
			ps = conn.prepareStatement( sql );
			ps.setString( 1, cate.getCate_name() );
			ps.setDouble( 2, cate.getPrice() );
			ps.setString( 3, cate.getImg_path() );
			ps.setString( 4, cate.getDescribe() );
			ps.setString( 5, cate.getType() );
			ps.setString( 6, cate.getSpeces() );
			ps.setInt( 7, cate.getStatus() );
			rs = ps.executeQuery();
			while( rs.next() ) {
				cate_id = rs.getInt( 1 );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cate_id;
	}
	

	/*
	 * 按菜品名模糊查询
	 */
	public List<Cate> seekCate(String cate_name){
		List<Cate> list = new ArrayList<Cate>();
		String sql = "select * from Cate where status=1 and cate_name like '%"+cate_name+"%'";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Cate cate = new Cate();
				cate.setCate_id(rs.getInt(1));
				cate.setCate_name(rs.getString(2));
				cate.setPrice(rs.getDouble(3));
				cate.setImg_path(rs.getString(4));
				cate.setDescribe(rs.getString(5));
				cate.setType(rs.getString(6));
				cate.setSpeces(rs.getString(7));
				cate.setStatus(rs.getInt(8));
				
				list.add(cate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		return list;
	}
	
	
	
	
	
}
