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

@WebServlet( name="shoppingcarServlet", urlPatterns="/shoppingcar" )
public class ShoppingCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Tuser loginer = (Tuser)session.getAttribute( "loginer" );
		
		ShoppingCarDao dao = new ShoppingCarDao();
		List<ShoppingCar> list = dao.getAll( loginer.getUser_id() );
		double total = 0;
		for( ShoppingCar sc : list ) {
			total = total + sc.getAmount() * sc.getPrice();
		}
		
		req.setAttribute( "total", total );
		req.setAttribute( "list", list );
		req.getRequestDispatcher( "shoppingcar.jsp" ).forward( req, resp );
		
	}

}
