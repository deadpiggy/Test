package com.newer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.dao.OrderNumDao;
import com.newer.model.OrderNum;
import com.newer.model.OrderNumPojo;
import com.newer.util.StringUtil;

@WebServlet( name="backdemomohuServlet", urlPatterns="/backdemomohu" )
public class BackDemoMoHuServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OrderNumPojo pojo = new OrderNumPojo();
		int user_id=0; int id1=0; int id2=0;
		
		String in1 = req.getParameter( "in1" );
		if( StringUtil.isFems( in1 ) ) {
			user_id = Integer.parseInt( in1 );
		}
		String in2 = req.getParameter( "in2" );
		if( StringUtil.isFems( in2 ) ) {
			user_id = Integer.parseInt( in2 );
		}
		String in3 = req.getParameter( "in3" );
		if( StringUtil.isFems( in3 ) ) {
			user_id = Integer.parseInt( in3 );
		}
		pojo.setUser_id(user_id);
		pojo.setId1(id1);
		pojo.setId2(id2);
		pojo.setStatus( req.getParameter( "in4" ) );
		pojo.setOrder_date( req.getParameter( "in5" ) );
		
		OrderNumDao dao = new OrderNumDao();
		List<OrderNum> list = dao.selectMoHu(pojo);
		
		req.setAttribute( "list", list );
		req.setAttribute( "pojo", pojo );
		req.getRequestDispatcher( "backDemoMoHu.jsp" ).forward( req, resp );		
	}

}