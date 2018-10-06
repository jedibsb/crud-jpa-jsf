package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Selecao;
import com.algaworks.curso.jpa2.service.CadastroSelecaoService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
@ManagedBean(name="cadastroSelecaoBean")
public class CadastroSelecaoBean implements Serializable {

	@Inject
	private CadastroSelecaoService cadastroSelecaoService;
	
	private Selecao selecao;
	
	public void salvar() {
		try {
			this.cadastroSelecaoService.salvar(selecao);
			FacesUtil.addSuccessMessage("Selecao salvo com sucesso!");
			
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar() {
		this.selecao = new Selecao();
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}	
	
	
}