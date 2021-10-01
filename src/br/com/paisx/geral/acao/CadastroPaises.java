package br.com.paisx.geral.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.modelo.Banco;
import br.com.paisx.geral.modelo.Pais;

public class CadastroPaises implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando Paises");
		String nomeDoParametro = request.getParameter("nome");

		Pais pais = new Pais();
		pais.setNomePais(nomeDoParametro);
		
		Banco banco = new Banco();
		banco.adicionaPais(pais);
		
		return "OpDois:entrada?acao=ListaPaises";
		
		//response.sendRedirect("entrada?acao=ListaPaises");
	}
}
