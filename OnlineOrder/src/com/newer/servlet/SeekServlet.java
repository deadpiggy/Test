package com.newer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.dao.CateDao;
import com.newer.model.Cate;


public class SeekServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cate_name = req.getParameter("seek");
		if("输入菜品".equals(cate_name)){
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else{
			CateDao dao = new CateDao();
			List<Cate> list = dao.seekCate(cate_name);
			req.setAttribute("list",list);
		    req.getRequestDispatcher("seekCate.jsp").forward(req, resp);
		}
	}
	
	
}









