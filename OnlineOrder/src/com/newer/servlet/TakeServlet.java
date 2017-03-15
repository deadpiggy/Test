package com.newer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.dao.OrderNumDao;

@WebServlet( name="takeServlet", urlPatterns="/take" )
public class TakeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int papi = Integer.parseInt( req.getParameter( "papi" ) );
		int id = Integer.parseInt( req.getParameter( "id" ) );
		
		OrderNumDao dao = new OrderNumDao();
		boolean flag = dao.takeOrder(papi, id);
		if( flag ) {
			req.getRequestDispatcher( "succedTake.jsp" ).forward( req, resp );
		}	
	}
}