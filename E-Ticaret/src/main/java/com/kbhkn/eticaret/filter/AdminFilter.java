package com.kbhkn.eticaret.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(dispatcherTypes = { 
		DispatcherType.REQUEST, 
		DispatcherType.FORWARD, 
		DispatcherType.INCLUDE,
		DispatcherType.ERROR },
		urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {
	protected FilterConfig config;
	protected String filterName;
	protected ServletContext context;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		if(req.getServletPath().equals("/admin/login"))
			chain.doFilter(request, response);
		else if(req.getSession().getAttribute("admin") != null)
			chain.doFilter(request, response);
		else{
			req.setAttribute("hata", "Erişim hakkınız bulunmamaktadır! Lütfen giriş yapınız!");
			req.getRequestDispatcher("/admin/login").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
		this.context = config.getServletContext();
		this.filterName = config.getFilterName();
	}

}
