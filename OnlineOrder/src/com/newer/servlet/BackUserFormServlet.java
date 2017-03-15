package com.newer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.dao.TuserDao;
import com.newer.model.Tuser;

@WebServlet( name="backuserformServlet", urlPatterns="/backuserform" )
public class BackUserFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TuserDao dao = new TuserDao();
		
		String str = req.getParameter( "str" );
		
		if( str.equals( "all" ) ) {
			List<Tuser> list = dao.getCommon();
			
			req.setAttribute( "list", list );
			req.getRequestDispatcher( "backUserForm.jsp" ).forward( req, resp );
		}else if( str.equals( "detail" ) ) {
			int user_id = Integer.parseInt( req.getParameter( "user_id" ) );
			Tuser user = dao.selectOne(user_id);
			
			req.setAttribute( "user", user );
			req.getRequestDispatcher( "backUserDetail.jsp" ).forward( req, resp );
		}else if( str.equals( "up" ) ) {
			int user_id = Integer.parseInt( req.getParameter( "user_id" ) );
			int type = 2;
			boolean flag = dao.upUser(type, user_id);
			if( flag ) {
				req.setAttribute( "str", "权限更改成功！" );
				req.getRequestDispatcher( "succedUser.jsp" ).forward( req, resp );
			}
		}else if( str.equals( "manage" ) ) {
			List<Tuser> list = dao.getManage();
			req.setAttribute( "list", list );
			req.getRequestDispatcher( "backManage.jsp" ).forward( req, resp );
		}
		
	}
}