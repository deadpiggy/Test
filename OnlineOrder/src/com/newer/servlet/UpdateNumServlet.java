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
import com.newer.model.ShoppingCar;
import com.newer.model.Tuser;

@WebServlet( name="updatenumServlet", urlPatterns="/updatenum" )
public class UpdateNumServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int cate_id = Integer.parseInt( req.getParameter( "cate_id" ) );
		int num = Integer.parseInt( req.getParameter( "num" ) );
		
		HttpSession session = req.getSession();
		Tuser user = (Tuser)session.getAttribute( "loginer" );
		
		ShoppingCarDao dao = new ShoppingCarDao();
		boolean flag = dao.updateSC(num, cate_id);
		if( flag ) {
			List<ShoppingCar> list = dao.getAll( user.getUser_id() );
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
			req.getRequestDispatcher( "shoppingcar" ).forward( req, resp );
		}else {
			req.getRequestDispatcher( "fail.jsp" ).forward( req, resp );
		}
		
	}
	
}