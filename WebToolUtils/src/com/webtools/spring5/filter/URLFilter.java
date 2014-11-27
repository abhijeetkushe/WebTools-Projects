package com.webtools.spring5.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class URLFilter implements Filter{

	private FilterConfig filterConfig;
	
	public void init(FilterConfig filterConfig)
	{
		this.filterConfig=filterConfig;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method sb
		HttpServletRequest request=(HttpServletRequest)arg0;
		String servletPath=request.getServletPath();
		String[] urlParams=servletPath.split("/");
		HttpSession session=request.getSession(true);
		for(int i=0;urlParams!=null && i< urlParams.length;i++)
		{
			if(urlParams!=null && (urlParams.length>0 && urlParams[i].length()==2))
			{		
				session.setAttribute("lang", urlParams[i]);
			}	
		}		
		arg2.doFilter(arg0, arg1);
	}
	
	
	
}
