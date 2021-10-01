package br.com.paisx.geral.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.paisx.geral.modelo.Banco;
import br.com.paisx.geral.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Servlet de login pais!");
		String paramSenha = request.getParameter("senha");
		String paramLogin = request.getParameter("login");
		
		Banco banco = new Banco();
		Usuario usuario = banco.exitePais(paramLogin , paramSenha);
		
		if (usuario != null) {
			System.out.println("Bem vindo!");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "OpDois:entrada?acao=CadastroDePaisesForm";
		}
		return "OpDois:entrada?acao=LoginForm";
	}

}
