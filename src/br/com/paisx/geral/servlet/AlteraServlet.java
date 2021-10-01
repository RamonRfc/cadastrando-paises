package br.com.paisx.geral.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.modelo.Banco;
import br.com.paisx.geral.modelo.Pais;

/**
 * Servlet implementation class AlteraServlet
 */
//@WebServlet("/alteraServlet")
public class AlteraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Pronto pra mudar");
		
		String nomeDoParametro = request.getParameter("nome");
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		

		Banco banco = new Banco();
		
		Pais pais = banco.buscaPaisId(id);
		pais.setNomePais(nomeDoParametro);

		
		

		response.sendRedirect("listaServlet");
	}

}
