package br.com.paisx.geral.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.modelo.Banco;
import br.com.paisx.geral.modelo.Pais;


//@WebServlet("/listaServlet")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Banco banco = new Banco();
		
		List<Pais> lista = banco.getPais();
		request.setAttribute("pais", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista.jsp");
		rd.forward(request, response);
		
	}

}
