package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.dao.SelecaoDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.modelo.Selecao;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
@ManagedBean(name="pesquisaSelecaoBean")
public class PesquisaSelecaoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	SelecaoDAO selecaoDAO;
	
	private List<Selecao> selecoes = new ArrayList<>();
	
	private Selecao selecaoSelecionado;
	
	public List<Selecao> getSelecoes() {
		return selecoes;
	}
	
	public void excluir() {
		try {
			selecaoDAO.excluir(selecaoSelecionado);
			this.selecoes.remove(selecaoSelecionado);
			FacesUtil.addSuccessMessage("Selecao " + selecaoSelecionado.getPais() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Selecao getSelecaoSelecionado() {
		return selecaoSelecionado;
	}
	public void setSelecaoSelecionado(Selecao selecaoSelecionado) {
		this.selecaoSelecionado = selecaoSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		selecoes = selecaoDAO.buscarTodos();
	}
}
