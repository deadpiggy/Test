package com.newer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.dao.TuserDao;
import com.newer.model.Tuser;

@WebServlet( name="updatepwdServlet", urlPatterns="/updatepwd" )
public class UpdatePWDServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Tuser user = (Tuser)session.getAttribute( "loginer" );
		
		int user_id = user.getUser_id();
		String password = req.getParameter( "paw" );
		
		TuserDao dao = new TuserDao();
		boolean flag = dao.updatePWD(user_id, password);
		
		if( flag ) {
			req.getRequestDispatcher( "succedPWD.jsp" ).forward( req, resp );
		}
	}

}