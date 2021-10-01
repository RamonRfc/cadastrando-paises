package br.com.paisx.geral.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.paisx.geral.modelo.Banco;
import br.com.paisx.geral.modelo.Pais;

public class ListaPaises implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando Paises");
		
		/*
		 * HttpSession sessao = request.getSession();
		 * 
		 * if (sessao.getAttribute("usuarioLogado") == null) { return
		 * "OpDois:entrada?acao=LoginForm"; }
		 */
		
		Banco banco = new Banco();

		List<Pais> lista = banco.getPais();
		request.setAttribute("pais", lista);

		return "OpUm:/lista.jsp";
		//RequestDispatcher rd = request.getRequestDispatcher("/lista.jsp");
		//rd.forward(request, response);

	}

}
