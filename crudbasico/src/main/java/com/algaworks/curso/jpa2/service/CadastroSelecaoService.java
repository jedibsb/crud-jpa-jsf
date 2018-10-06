package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.SelecaoDAO;
import com.algaworks.curso.jpa2.modelo.Selecao;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroSelecaoService implements Serializable {

	@Inject
	private SelecaoDAO selecaoDAO;
	
	@Transactional
	public void salvar(Selecao selecao) throws NegocioException {
		if (selecao.getPais() == null || selecao.getPais().trim().equals("")) { 
			throw new NegocioException("O nome do país é obrigatório");
		}
		
		this.selecaoDAO.salvar(selecao);
	}
	
}