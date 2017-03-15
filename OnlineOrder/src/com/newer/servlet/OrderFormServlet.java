package com.newer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newer.dao.CateDao;
import com.newer.dao.DetailDao;
import com.newer.dao.OrderNumDao;
import com.newer.dao.ShoppingCarDao;
import com.newer.model.Cate;
import com.newer.model.Detail;
import com.newer.model.OrderNum;
import com.newer.model.ShoppingCar;
import com.newer.model.Tuser;

@WebServlet(name = "orderformServlet", urlPatterns = "/orderform")
public class OrderFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String address = req.getParameter("address");
		String words = req.getParameter("words");
		String phone = req.getParameter("phone");

		// dao
		CateDao dao1 = new CateDao();
		ShoppingCarDao dao2 = new ShoppingCarDao();
		OrderNumDao dao3 = new OrderNumDao();
		DetailDao dao4 = new DetailDao();

		HttpSession session = req.getSession();
		Tuser user = (Tuser) session.getAttribute("loginer");

		// 通过用户填写的信息拿到OrderNum对象
		OrderNum on = new OrderNum();
		on.setUser_id(user.getUser_id());
		on.setType(1);
		on.setAddress(address);
		on.setWords(words);
		on.setStatus("配送中");
		on.setPhone(phone);
		boolean flag1 = dao3.addOrder(on);
		int id = dao3.getOrderId(on); // 拿到订单编号

		// 通过购物车对象拿值赋给Detail对象, 然后将Detail对象添加进数据库
		List<ShoppingCar> list = dao2.getAll(user.getUser_id());
		for (ShoppingCar sc : list) {
			Detail detail = new Detail();
			detail.setCate_id(sc.getCate_id());
			detail.setId(id);
			detail.setAmount(sc.getAmount());
			detail.setCate_name(sc.getCate_name());
			detail.setPrice(sc.getPrice());
			detail.setPicture(sc.getPicture());
			Cate cate = dao1.getOne(sc.getCate_id());
			detail.setDescribe(cate.getDescribe());
			boolean flag2 = dao4.addDetail(detail);
		}

		boolean flag3 = dao2.dropSC( user.getUser_id() );
		if( flag3 ) {
			List<ShoppingCar> listDrop = dao2.getAll(user.getUser_id());
			// 购物车商品数量
			int listNum = 0;
			// 购物车商品总价
			double total = 0;
			for (ShoppingCar sc1 : listDrop) {
				listNum = listNum + sc1.getAmount();
				total = total + sc1.getAmount() * sc1.getPrice();
			}
			session.setAttribute("listNum", listNum);
			session.setAttribute("total", total);
			req.getRequestDispatcher("succedOrder.jsp").forward(req, resp);
		}
		
	}
}