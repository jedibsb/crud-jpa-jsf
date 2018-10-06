package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.JogadorDAO;
import com.algaworks.curso.jpa2.modelo.Jogador;

public class CadastroJogadorService implements Serializable {

	@Inject
	private JogadorDAO jogadorDAO;
	
	public void salvar(Jogador jogador) throws NegocioException {
		
		if (jogador.getNome() == null || jogador.getNome().trim() == "") {
			throw new NegocioException("Selecao e obrigatório");
		}
		
		if (jogador.getCamisa() == null) {
			throw new NegocioException("Camisa é obrigatório.");
		}
		
		if (jogador.getSelecao() == null) {
			throw new NegocioException("Selecao e obrigatório");
		}		
		
		this.jogadorDAO.salvar(jogador);
			
	}
}
