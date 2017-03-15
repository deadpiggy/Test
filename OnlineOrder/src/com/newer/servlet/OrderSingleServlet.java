package com.newer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.dao.CateDao;
import com.newer.model.Cate;

@WebServlet( name="ordersingleServlet", urlPatterns="/ordersingle" )
public class OrderSingleServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int cate_id = Integer.parseInt( req.getParameter( "cate_id" ) );
		
		CateDao dao = new CateDao();
		Cate cate = dao.getOne( cate_id );
		
		HttpSession session = req.getSession();
		session.setAttribute( "singleCate", cate );
		
		resp.sendRedirect( "orderSingleForm.jsp" );
	}
	
}
