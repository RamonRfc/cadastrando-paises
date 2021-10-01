package br.com.paisx.geral.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroDePaisesForm implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastro De Paises Form ");
		
		
		return "OpUm:/cadastrodepaises.jsp";
		
		//RequestDispatcher rd = request.getRequestDispatcher("/cadastrodepaises.jsp");
		//rd.forward(request, response);
	}
}
