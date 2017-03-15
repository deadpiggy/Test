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
import com.newer.model.PageBean;
import com.newer.model.OrderNumPojo;
import com.newer.util.StringUtil;

@WebServlet( name="backdemoServlet", urlPatterns="/backdemo" )
public class BackDemoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			OrderNumDao dao=new OrderNumDao();
		 	int pageNo=1;
			int pageSize=8;
			
			String pno=req.getParameter("pageNo");
			String pSize=req.getParameter("pageSize");
			if(pno!=null&&!"".equals(pno)){
				pageNo=Integer.parseInt(pno);
			}
			
			if(pSize!=null&&!"".equals(pSize)){
				pageSize=Integer.parseInt(pSize);
			}
		     
		    List<OrderNum> list=dao.getAll(pageNo, pageSize);
		    PageBean<OrderNum> ph=new PageBean<OrderNum>();
		    ph.setData(list);
		    ph.setPageNo(pageNo);
		    ph.setPageSize(pageSize);
		    ph.setTotalRows(dao.selectAllRows());
			
		    req.setAttribute("pb", ph);
			req.getRequestDispatcher( "backDemo.jsp" ).forward( req, resp );
			
	}
	
}
