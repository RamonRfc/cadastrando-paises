package br.com.paisx.geral.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.modelo.Banco;

public class RemoverPaises implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando Paises");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Banco banco = new Banco();
		banco.removePais(id);
		
		return "OpDois:entrada?acao=ListaPaises";
		//response.sendRedirect("entrada?acao=ListaPaises");
	}
}
