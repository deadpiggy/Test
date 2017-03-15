package com.newer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.dao.CateDao;
import com.newer.dao.ShoppingCarDao;
import com.newer.model.Cate;
import com.newer.model.ShoppingCar;
import com.newer.model.Tuser;

@WebServlet( name="addscservlet", urlPatterns="/addsc" )
public class AddSCServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//通过url 传一个商品id，一个添加数量num
		int cate_id = Integer.parseInt( req.getParameter( "cate_id" ) );
		int num = Integer.parseInt( req.getParameter( "num" ) );

		//拿到登录用户
		HttpSession session = req.getSession();
		Tuser user = (Tuser)session.getAttribute( "loginer" );
		
		//通过商品id, 获得商品对象
		CateDao dao1 = new CateDao();
		Cate cate = dao1.getOne( cate_id );
		
		//新建一个购物车对象，用来作为参数传给dao方法
		ShoppingCar sc = new ShoppingCar();
		sc.setCate_id( cate.getCate_id() );
		sc.setCate_name( cate.getCate_name() );
		sc.setPrice( cate.getPrice() );
		sc.setUser_id( user.getUser_id() );
		sc.setPicture( cate.getImg_path() );
		
		//通过用户id, 商品id 来确认购物车中是否存在该商品
		ShoppingCarDao dao2 = new ShoppingCarDao();
		ShoppingCar scDemo = dao2.getOne( user.getUser_id(), cate_id );
		
		if( scDemo.getCate_id() == 0 ) {
			sc.setAmount( num );
			boolean flag = dao2.addSC( sc );
			if( flag ) {
				List<ShoppingCar> list = dao2.getAll( user.getUser_id() );
				//购物车商品数量
				int listNum = 0;
				//购物车商品总价
				double total = 0;
				for( ShoppingCar sc1 : list ) {
					listNum = listNum + sc1.getAmount();
					total = total + sc1.getAmount() * sc1.getPrice();
				}
				session.setAttribute( "listNum", listNum );
				session.setAttribute( "total", total );
				req.getRequestDispatcher( "succed.jsp" ).forward( req, resp );
			}
		}else {
			int numOld = scDemo.getAmount();
			int numNew = numOld + num;
//			int sid = scDemo.getSid();
			boolean flag = dao2.updateSC(numNew, cate_id);
			if( flag ) {
				List<ShoppingCar> list = dao2.getAll( user.getUser_id() );
				//购物车商品数量
				int listNum = 0;
				//购物车商品总价
				double total = 0;
				for( ShoppingCar sc1 : list ) {
					listNum = listNum + sc1.getAmount();
					total = total + sc1.getAmount() * sc1.getPrice();
				}
				session.setAttribute( "listNum", listNum );
				session.setAttribute( "total", total );
				req.getRequestDispatcher( "succed.jsp" ).forward( req, resp );
			}
		}
		
	}
	
}