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
import com.newer.model.Cate;
import com.newer.model.Discuss;
import com.newer.model.PageBean;

@WebServlet( name="indexServlet", urlPatterns="/index" )
public class IndexServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost( req, resp );
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		CateDao dao = new CateDao();
		DiscussDao dao2 = new DiscussDao();

		//分页
		int pageNo = 1;
		int pageSize = 12;
		
		String pno = req.getParameter("pageNo");
		String pSize = req.getParameter("pageSize");
		if (pno != null && !"".equals(pno)) {
			pageNo = Integer.parseInt(pno);
		}
		if (pSize != null && !"".equals(pSize)) {
			pageSize = Integer.parseInt(pSize);
		}
		
		List<Cate> list = dao.selectByPage(pageNo, pageSize);
		PageBean<Cate> ph = new PageBean<>();
		ph.setData(list);
		ph.setPageNo(pageNo);
		ph.setPageSize(pageSize);
		ph.setTotalRows(dao.selectAllRows());
		
		//每日三个推荐菜
		Cate cate1 = dao.getOne( 35 );
		Cate cate2 = dao.getOne( 51 );
		Cate cate3 = dao.getOne( 44 );
		
		//三个带评论的菜品样式
		Random random = new Random();
		int num = random.nextInt( dao2.getNum()-7 )+1;
		List<Discuss> listDis = new ArrayList<>();
		for( int i = 0; i < 3; i++ ) {
			Discuss dis = dao2.getOneDiscuss(num);
			listDis.add( dis );
			num = num+2;
		}
		req.setAttribute( "listDis", listDis );
		
		session.setAttribute( "cate1", cate1 );
		session.setAttribute( "cate2", cate2 );
		session.setAttribute( "cate3", cate3 );
		req.setAttribute( "pb", ph );
		req.getRequestDispatcher( "index.jsp" ).forward( req, resp );
	}
	
}
