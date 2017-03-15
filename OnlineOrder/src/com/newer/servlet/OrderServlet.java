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

import com.newer.dao.DiscussDao;
import com.newer.dao.OrderDao;
import com.newer.model.Discuss;
import com.newer.model.Order;
import com.newer.model.Tuser;

@WebServlet(name = "orderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Tuser user = (Tuser) session.getAttribute("loginer");

		OrderDao dao = new OrderDao();
		DiscussDao dao2 = new DiscussDao();

		List<Integer> idList = dao.getOrderID(user.getUser_id());
		List<List<Order>> listDemo = new ArrayList<>();

		for (int i : idList) {
			List<Order> list = dao.getSingleOrder(user.getUser_id(), i);
			listDemo.add(list);
		}

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

		req.setAttribute("listDemo", listDemo);
		req.getRequestDispatcher("personal.jsp").forward(req, resp);

	}
}