package br.com.paisx.geral.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.modelo.Banco;
import br.com.paisx.geral.modelo.Pais;

public class AlteraPaises implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Pronto pra mudar");
	
	String nomeDoParametro = request.getParameter("nome");
	String idParam = request.getParameter("id");
	Integer id = Integer.valueOf(idParam);
	

	Banco banco = new Banco();
	
	Pais pais = banco.buscaPaisId(id);
	pais.setNomePais(nomeDoParametro);

	
	return "OpDois:entrada?acao=ListaPaises";

	//response.sendRedirect("entrada?acao=ListaPaises");
	
}}
