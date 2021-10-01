package br.com.paisx.geral.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
    	HttpServletResponse response = (HttpServletResponse) servletResponse;
    	System.out.println("MonitoramentoFilter");
    	long inicial = System.currentTimeMillis();
    	
    	chain.doFilter(request, response);
    	
    	long Final = System.currentTimeMillis();
    	
	}

}
