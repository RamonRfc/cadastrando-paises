package br.com.paisx.geral.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
    	HttpServletResponse response = (HttpServletResponse) servletResponse;
		System.out.println("AutorizacaoFilter");
		
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean UsuarioNaoLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean PaginaLiberada = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm")); 
		
		
		if (UsuarioNaoLogado && PaginaLiberada) {
			response.sendRedirect("entrada?acao=LoginForm"); 
			return;
		}
		
		chain.doFilter(request, response);
	}
}
