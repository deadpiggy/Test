package com.newer.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter{

	private String reqCoding;
	private String respCoding;
	
	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		reqCoding = fc.getInitParameter( "request" );
		respCoding = fc.getInitParameter( "response" );

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//将请求和响应转换成Http协议类型
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse)arg1;
		
		//设置字符编码
		req.setCharacterEncoding( reqCoding );
		 
		//执行控制器
		arg2.doFilter( req, resp );
		
		resp.setContentType( respCoding );
	}

}
