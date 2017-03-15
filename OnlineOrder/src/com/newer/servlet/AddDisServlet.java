package com.newer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.dao.DiscussDao;
import com.newer.dao.OrderNumDao;
import com.newer.model.Discuss;

@WebServlet( name="adddisServlet", urlPatterns="/addDis" )
public class AddDisServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute( "disDemoid" );
		
		int did = Integer.parseInt( req.getParameter( "did" ) );
		int cate_id = Integer.parseInt( req.getParameter( "cate_id" ) );
		int size = Integer.parseInt( req.getParameter( "size" ) );
		String picture = req.getParameter( "picture" );
		
		Discuss dis = new Discuss();
		DiscussDao dao = new DiscussDao();
		OrderNumDao dao2 = new OrderNumDao();
		boolean flag = dao.addDiscuss(dis);
		if( flag ) {
			if( size==1 ) {
				boolean flag2 = dao2.changeType( 2, id);
				if( flag2 ) {
					req.getRequestDispatcher( "succedDis.jsp" ).forward( req, resp );
				}
			}else if( size > 1 ) {
				boolean flag2 = dao2.changeType(2, cate_id);
				if( flag2 ) {
					size = size-1;
					req.setAttribute( "size", size );
				}
			}
		}
		
	}

}