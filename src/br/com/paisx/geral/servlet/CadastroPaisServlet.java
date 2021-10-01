package br.com.paisx.geral.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.modelo.Banco;
import br.com.paisx.geral.modelo.Pais;


//@WebServlet("/cadastroPaisServlet")
public class CadastroPaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeDoParametro = request.getParameter("nome");
		
		Pais pais = new Pais();
		pais.setNomePais(nomeDoParametro);
		
		Banco banco = new Banco();
		banco.adicionaPais(pais);
		
		response.sendRedirect("listaServlet");
		
	}

}
