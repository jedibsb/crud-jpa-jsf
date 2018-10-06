package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.modelo.Selecao;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class SelecaoDAO implements Serializable {

	@Inject
	private EntityManager em;
	
	public void salvar(Selecao selecao) {
		em.merge(selecao);
	}

	@SuppressWarnings("unchecked")
	public List<Selecao> buscarTodos() {
		return em.createQuery("from Selecao").getResultList();
	}

	@Transactional
	public void excluir(Selecao selecao) throws NegocioException {
		Selecao selecaoTemp = em.find(Selecao.class, selecao.getCodigo());
		
		em.remove(selecaoTemp);
		em.flush();
	}

	public Selecao buscarPeloCodigo(Long codigo) {
		return em.find(Selecao.class, codigo);
	}
}