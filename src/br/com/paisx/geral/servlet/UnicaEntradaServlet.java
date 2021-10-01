package br.com.paisx.geral.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.paisx.geral.acao.Acao;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		System.out.println("Unica servlet pais");
		HttpSession sessao = request.getSession();
		boolean UsuarioNaoLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean PaginaLiberada = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm")); 
		
		
		System.out.println("paramAcao " + paramAcao);
		System.out.println("UsuarioNaoLogado " + UsuarioNaoLogado);
		System.out.println("paramAcao " + PaginaLiberada);
		
		if (UsuarioNaoLogado && PaginaLiberada) {
			response.sendRedirect("entrada?acao=LoginForm"); 
			return;
		}

		String nomeDaClasse = "br.com.paisx.geral.acao." + paramAcao;

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao objAcao = (Acao) classe.newInstance();
			nome = objAcao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
			String[] Endereco = nome.split(":");
			if (Endereco[0].equals("OpUm")) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view" + Endereco[1]);
				rd.forward(request, response);
			} else {
				response.sendRedirect(Endereco[1]);
			}

			/*
			 * String nome = null; if (paramAcao.equals("ListaPaises")) { ListaPaises acao =
			 * new ListaPaises(); nome = acao.executa(request, response); } else if
			 * (paramAcao.equals("RemoverPaises")) { RemoverPaises acao = new
			 * RemoverPaises(); nome = acao.executa(request, response); } else if
			 * (paramAcao.equals("MostraPaises")) { MostraPaises acao = new MostraPaises();
			 * nome = acao.executa(request, response); } else if
			 * (paramAcao.equals("CadastroPaises")) { CadastroPaises acao = new
			 * CadastroPaises(); nome = acao.executa(request, response); } else if
			 * (paramAcao.equals("CadastroDePaisesForm")) { CadastroDePaisesForm acao = new
			 * CadastroDePaisesForm(); nome = acao.executa(request, response); } else if
			 * (paramAcao.equals("AlteraPaises")) { AlteraPaises acao = new AlteraPaises();
			 * nome = acao.executa(request, response); }
			 */

		}
	}

