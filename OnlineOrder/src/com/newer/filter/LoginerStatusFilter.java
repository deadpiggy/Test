package com.newer.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginerStatusFilter implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		//将请求和响应转换成http协议类型
//		HttpServletRequest req = (HttpServletRequest)arg0;
//		HttpServletResponse resp = (HttpServletResponse)arg1;
		
		//获得会话
//		HttpSession session = req.getSession();
		
		arg0.setAttribute( "a", 0 );
		
		//控制请求的传递
		arg2.doFilter(arg0, arg1);
		System.out.println( "servlet处理完了..........." );
	}

	
	
}
