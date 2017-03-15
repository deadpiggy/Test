package com.newer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.dao.CateDao;

@WebServlet( name="changecatestatusServlet", urlPatterns="/changecatestatus" )
public class ChangeCateStatusServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int cate_id = Integer.parseInt( req.getParameter( "cate_id" ) );
		int status = Integer.parseInt( req.getParameter( "status" ) );
		
		CateDao dao = new CateDao();
		boolean flag = dao.ChangeStatus(cate_id, status);
		if( flag ) {
			req.getRequestDispatcher( "productform" ).forward( req, resp );
		}
		
	}
}