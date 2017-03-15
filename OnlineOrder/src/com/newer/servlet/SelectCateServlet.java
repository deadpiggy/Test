package com.newer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newer.dao.CateDao;
import com.newer.dao.DiscussDao;
import com.newer.model.Cate;
import com.newer.model.Discuss;

@WebServlet(name = "selectcateServlet", urlPatterns = "/selectcate")
public class SelectCateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String type = req.getParameter("type");

		CateDao dao = new CateDao();
		DiscussDao dao2 = new DiscussDao();
		List<Cate> listType = dao.selectCate(type);

		// 三个带评论的菜品样式
		Random random = new Random();
		int num = random.nextInt(dao2.getNum() - 7) + 1;
		List<Discuss> listDis = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Discuss dis = dao2.getOneDiscuss(num);
			listDis.add(dis);
			num = num + 2;
		}
		req.setAttribute("listDis", listDis);

		req.setAttribute("type", type);
		req.setAttribute("listType", listType);
		req.getRequestDispatcher("selectCate.jsp").forward(req, resp);

	}

}
