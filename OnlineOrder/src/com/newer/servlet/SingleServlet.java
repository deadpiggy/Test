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
import javax.servlet.http.HttpSession;

import com.newer.dao.CateDao;
import com.newer.dao.DiscussDao;
import com.newer.dao.ShoppingCarDao;
import com.newer.model.Cate;
import com.newer.model.Discuss;
import com.newer.model.ShoppingCar;
import com.newer.model.Tuser;

@WebServlet(name = "singleServlet", urlPatterns = "/single")
public class SingleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int cate_id = Integer.parseInt(req.getParameter("cate_id"));

		CateDao dao = new CateDao();
		Cate cate = dao.getOne(cate_id);

		// 获得菜品的评论
		DiscussDao dao2 = new DiscussDao();
		List<Discuss> listContent = dao2.getCate(cate_id);

		// 随机拿到三个菜品
		Random random = new Random();
		int randomNum = random.nextInt(15) + 1;
		List<Cate> listThreeCate = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Cate cateDemo = dao.getRandom(randomNum);
			listThreeCate.add(cateDemo);
			randomNum = randomNum + 5;
		}

		// 三个带评论的菜品样式
		Random randomDis = new Random();
		int num = randomDis.nextInt(dao2.getNum() - 7) + 1;
		List<Discuss> listDis = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Discuss dis = dao2.getOneDiscuss(num);
			listDis.add(dis);
			num = num + 2;
		}
		req.setAttribute("listDis", listDis);

		req.setAttribute("listThreeCate", listThreeCate);
		req.setAttribute("listContent", listContent);
		req.setAttribute("cate", cate);
		req.getRequestDispatcher("single.jsp").forward(req, resp);

	}
}