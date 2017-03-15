package com.newer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.dao.TuserDao;
import com.newer.model.Tuser;

@WebServlet( name="registerServlet", urlPatterns="/register" )
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String user_name = req.getParameter( "username" );
		String ch_name = req.getParameter( "name" );
		String email = req.getParameter( "email" );
		String mobile = req.getParameter( "mobile" );
		String address = req.getParameter( "address" );
		String sex = req.getParameter( "sex" );
		String password = req.getParameter( "paw" );
		
		Tuser user = new Tuser();
		user.setUser_name(user_name);
		user.setCh_name(ch_name);
		user.setPassword(password);
		user.setMobile(mobile);
		user.setSex(sex);
		user.setType( 1 );
		user.setAddress(address);
		user.setEmail(email);
		
		TuserDao dao = new TuserDao();
		boolean flag = dao.addOne( user );
		
		if( flag ) {
			req.getRequestDispatcher( "succedRegister.jsp" ).forward( req, resp );
		}
	}
}