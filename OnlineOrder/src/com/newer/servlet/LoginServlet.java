package com.newer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.dao.ShoppingCarDao;
import com.newer.dao.TuserDao;
import com.newer.model.ShoppingCar;
import com.newer.model.Tuser;

@WebServlet( name="loginServlet", urlPatterns="/login" )
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginName = req.getParameter( "loginName" );
		String loginPass = req.getParameter( "loginPass" );
		
		TuserDao dao = new TuserDao();
		Tuser t = dao.getOne(loginName, loginPass);
		
		HttpSession session = req.getSession();
		
		//登录状态判定
		int a = 1;
		
		if( t.getType() == 0 ) {
			req.getRequestDispatcher( "fail.jsp" );
		}else if( t.getType() == 1 ) {
			//普通用户进入
			ShoppingCarDao dao2 = new ShoppingCarDao();
			List<ShoppingCar> list = dao2.getAll( t.getUser_id() );
			//购物车商品数量
			int listNum = 0;
			//购物车商品总价
			double total = 0.00;
			for( ShoppingCar sc : list ) {
				listNum = listNum + sc.getAmount();
				total = total + sc.getAmount() * sc.getPrice();
			}
			session.setAttribute( "listNum", listNum );
			session.setAttribute( "total", total );
			
			//判断男女
			if( t.getSex().equals( "男" ) )  {
				session.setAttribute( "sexDemo", "先生" );
			}else if( t.getSex().equals( "女" ) ) {
				session.setAttribute( "sexDemo", "小姐" );
			}
			
			session.setAttribute( "a", a );
			session.setAttribute( "loginer", t );
			resp.sendRedirect( "index" );
		} else if( t.getType() == 2 ) {
			//进入管理员后台界面
			a = 2;
			
			ShoppingCarDao dao2 = new ShoppingCarDao();
			List<ShoppingCar> list = dao2.getAll( t.getUser_id() );
			//购物车商品数量
			int listNum = 0;
			//购物车商品总价
			double total = 0.00;
			for( ShoppingCar sc : list ) {
				listNum = listNum + sc.getAmount();
				total = total + sc.getAmount() * sc.getPrice();
			}
			session.setAttribute( "listNum", listNum );
			session.setAttribute( "total", total );
			
			//判断男女
			if( t.getSex().equals( "男" ) )  {
				session.setAttribute( "sexDemo", "先生" );
			}else if( t.getSex().equals( "女" ) ) {
				session.setAttribute( "sexDemo", "小姐" );
			}
			
			session.setAttribute( "a", a );
			session.setAttribute( "loginer", t );
			req.getRequestDispatcher( "backdemo" ).forward( req, resp );
		}
		
	}
	
}
