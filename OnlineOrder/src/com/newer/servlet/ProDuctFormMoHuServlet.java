package com.newer.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.dao.CateDao;
import com.newer.model.Cate;
import com.newer.model.CatePojo;
import com.newer.util.StringUtil;

@WebServlet(name = "productformmohu", urlPatterns = "/productformmohu")
public class ProDuctFormMoHuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 模糊查询
		CatePojo pojo = new CatePojo();
		int cate_id1 = 0;
		int cate_id2 = 0;
		double price = 0;

		String in1 = req.getParameter("in1");
		if (StringUtil.isFems(in1)) {
			cate_id1 = Integer.parseInt(in1);
		}
		String in2 = req.getParameter("in2");
		if (StringUtil.isFems(in2)) {
			cate_id2 = Integer.parseInt(in2);
		}
		String in4 = req.getParameter("in4");
		if (StringUtil.isFems(in4)) {
			price = Double.parseDouble(req.getParameter(in4));
		}
		pojo.setCate_id1(cate_id1);
		pojo.setCate_id2(cate_id2);
		pojo.setCate_name(req.getParameter("in3"));
		pojo.setPrice(price);

		CateDao dao = new CateDao();
		List<Cate> list = dao.getSelectAll(pojo);
		
		req.setAttribute( "list", list );
		req.setAttribute( "pojo", pojo );
		req.getRequestDispatcher( "productFormMoHu.jsp" ).forward( req, resp );
	}

}