package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Jogador;
import com.algaworks.curso.jpa2.service.CadastroJogadorService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

import com.algaworks.curso.jpa2.dao.SelecaoDAO;
import com.algaworks.curso.jpa2.modelo.Selecao;


@Named
@ViewScoped
@ManagedBean(name="cadastroJogadorBean")
public class CadastroJogadorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Jogador jogador;
	
	private List<Selecao> selecoes;
	
	@Inject
	private CadastroJogadorService cadastroJogadorService;
	
	@Inject
	private SelecaoDAO selecaoDAO;
	
	public void salvar() {
		try {
			
			this.cadastroJogadorService.salvar(jogador);
			FacesUtil.addSuccessMessage("Jogador salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
		this.selecoes = selecaoDAO.buscarTodos();
	}
	
	public void limpar() {
		this.jogador = new Jogador();
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public List<Selecao> getSelecoes() {
		return selecoes;
	}	
	
}

