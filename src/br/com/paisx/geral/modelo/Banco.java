package br.com.paisx.geral.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Pais> listaPais = new ArrayList<>();
	private static List<Usuario> listaUsuario = new ArrayList<>();
	private static Integer chaveprimaria = 1;
	
	static {
		Pais p1 = new Pais();
		p1.setId(chaveprimaria++);
		p1.setNomePais("Brasil");
		
		listaPais.add(p1);
		
		Usuario u1 = new Usuario();
		u1.setLogin("admin");
		u1.setSenha("123");
		
		listaUsuario.add(u1);
	}
	
	public List<Pais> getPais() {
		return Banco.listaPais;
	}

	public void adicionaPais(Pais pais) {
		pais.setId(chaveprimaria++);
		listaPais.add(pais);

	}

	public void removePais(Integer id) {
		Iterator<Pais> it = listaPais.iterator();
		
		while (it.hasNext()) {
			Pais pais = it.next();
			if (pais.getId() == id) {
				it.remove();
				
			}
			
		}
		
	
	}

	public Pais buscaPaisId(Integer id) {
		for (Pais pais : listaPais) {
			if (pais.getId() == id) {
				return pais;
			}
		}
		return null;
	}

	public Usuario exitePais(String paramLogin, String paramSenha) {
		for (Usuario usuario : listaUsuario) {
			if(usuario.ehIgual(paramLogin, paramSenha)) {
				return usuario;
			}
		}
		return null;
	}
}
