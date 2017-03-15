package com.newer.servlet;

import java.io.IOException;

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
import com.newer.model.Tuser;

@WebServlet( name="ordersingleformServlet", urlPatterns="/ordersingleform" )
public class OrderSingleFormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String address = req.getParameter("address");
		String words = req.getParameter("words");
		String phone = req.getParameter("phone");
		
		HttpSession session = req.getSession();
		Tuser user = (Tuser) session.getAttribute("loginer");
		Cate cate = (Cate)session.getAttribute( "singleCate" );
		
		// dao
		CateDao dao1 = new CateDao();
		ShoppingCarDao dao2 = new ShoppingCarDao();
		OrderNumDao dao3 = new OrderNumDao();
		DetailDao dao4 = new DetailDao();

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

		Detail detail = new Detail();
		detail.setCate_id(cate.getCate_id());
		detail.setId(id);
		detail.setAmount(1);
		detail.setCate_name(cate.getCate_name());
		detail.setPrice(cate.getPrice());
		detail.setPicture(cate.getImg_path());
		detail.setDescribe(cate.getDescribe());
		boolean flag2 = dao4.addDetail(detail);
		
		if( flag2 ) {
			req.getRequestDispatcher( "succedOrder.jsp" ).forward( req, resp );
		}
		
		
	}
}