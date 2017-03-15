package com.newer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.dao.DetailDao;
import com.newer.model.Detail;
import com.newer.model.Tuser;

@WebServlet( name="discussorderServlet", urlPatterns="/discussorder" )
public class DiscussOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		int id = Integer.parseInt( req.getParameter( "id" ) );
		session.setAttribute( "disDemoid", id );
		
		DetailDao dao = new DetailDao();
		List<Detail> list = dao.getNum(id);
		int size = list.size();
		
		req.setAttribute( "size", size );
		req.setAttribute( "list", list );
		req.getRequestDispatcher( "discussOrder.jsp" ).forward( req, resp );
	}
}