package com.newer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.dao.OrderDao;
import com.newer.model.Order;

@WebServlet( name="orderdetailServlet", urlPatterns="/orderdetail" )
public class OrderDetailServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt( req.getParameter( "id" ) );
		int user_id = Integer.parseInt( req.getParameter( "user_id" ) );
		
		OrderDao dao = new OrderDao();
		List<Order> list = dao.getSingleOrder(user_id, id);
		
		req.setAttribute( "id", id );
		req.setAttribute( "list", list );
		req.getRequestDispatcher( "orderDetail.jsp" ).forward( req, resp );
		
	}
	
}
