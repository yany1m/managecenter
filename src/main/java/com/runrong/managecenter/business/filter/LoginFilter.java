package com.runrong.managecenter.business.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.runrong.managecenter.config.SecurityConfig;

@Component
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		
		String url=req.getRequestURI().toString();
		
		HttpSession session=req.getSession();
		Integer id=(Integer) session.getAttribute("admin_id");
		Set<String> set=SecurityConfig.getAllowUrl();
					
		if(id!=null || set.contains(url)){
			chain.doFilter(request, response);	
		}else{
			resp.sendRedirect("/managecenter/login.html");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}