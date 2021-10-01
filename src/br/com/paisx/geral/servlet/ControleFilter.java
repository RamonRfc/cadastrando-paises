package br.com.paisx.geral.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.acao.Acao;

/**
 * Servlet Filter implementation class ControleFilter
 */
@WebFilter("/entrada")
public class ControleFilter implements Filter {

    @Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
    	HttpServletResponse response = (HttpServletResponse) servletResponse;
    	System.out.println("ControleFilter");
    	String paramAcao = request.getParameter("acao");
    	
    	String nomeDaClasse = "br.com.paisx.geral.acao." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao objAcao = (Acao) classe.newInstance();
			nome = objAcao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
			String[] Endereco = nome.split(":");
			if (Endereco[0].equals("OpUm")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view" + Endereco[1]);
				rd.forward(request, response);
			} else {
				response.sendRedirect(Endereco[1]);
			}
    	
	}
}
