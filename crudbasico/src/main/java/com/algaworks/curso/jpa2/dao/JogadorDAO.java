package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Jogador;

public class JogadorDAO implements Serializable {

	@Inject
	EntityManager em;
	
	public void salvar(Jogador jogador) {
		
		em.merge(jogador);
	}
}
