package br.com.alura.gerenciador.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.alura.gerenciador.Empresa;

public class EmpresaDAO {

	private final static Map<Long, Empresa> EMPRESAS = new HashMap<>();
	static {
		geraIdEAdiciona(new Empresa("Doceria Bela Vista"));
		geraIdEAdiciona(new Empresa("Ferragens Docel"));
		geraIdEAdiciona(new Empresa("Alura"));
		geraIdEAdiciona(new Empresa("Google"));
		geraIdEAdiciona(new Empresa("Caelum"));
		geraIdEAdiciona(new Empresa("Casa do Código"));
	}

	public Collection<Empresa> buscaPorSimilaridade(String nome) {
		if (nome == null)
			return EMPRESAS.values();
		
		List<Empresa> similares = new ArrayList<>();
		for (Empresa empresa : EMPRESAS.values()) {
			if (empresa.getNome().toLowerCase().contains(nome.toLowerCase()))
				similares.add(empresa);
		}
		return similares;
	}

	public void adiciona(Empresa empresa) {
		geraIdEAdiciona(empresa);
	}

	private static void geraIdEAdiciona(Empresa empresa) {
		long id = EMPRESAS.size()+1l;
		empresa.setId(id);
		EMPRESAS.put(id, empresa);
	}
}
