package br.com.paisx.geral.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.modelo.Banco;
import br.com.paisx.geral.modelo.Pais;


//@WebServlet("/mostraPaises")
public class MostraPaisesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);
		
		
		Banco banco = new Banco();
		Pais pais = banco.buscaPaisId(id);
		request.setAttribute("copia", pais);

		RequestDispatcher rd = request.getRequestDispatcher("/alterapais.jsp");
		rd.forward(request, response);
		
	}

}
