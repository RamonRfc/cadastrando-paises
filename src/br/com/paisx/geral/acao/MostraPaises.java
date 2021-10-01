package br.com.paisx.geral.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.modelo.Banco;
import br.com.paisx.geral.modelo.Pais;

public class MostraPaises implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando Paises");
		String idParam = request.getParameter("id");
		Integer id = Integer.valueOf(idParam);

		Banco banco = new Banco();
		Pais pais = banco.buscaPaisId(id);
		request.setAttribute("copia", pais);
		
		
		return "OpUm:/alterapais.jsp";
		//RequestDispatcher rd = request.getRequestDispatcher("/alterapais.jsp");
		//rd.forward(request, response);
	}
}
