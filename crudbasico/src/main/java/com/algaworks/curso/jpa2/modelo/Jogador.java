package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jogador")
public class Jogador {
	
	private Long codigo;
	private String nome;
	private Integer camisa;
	private Selecao selecao;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@Column(name="camisa", nullable=false, length=100)
	public Integer getCamisa() {
		return camisa;
	}
	public void setCamisa(Integer camisa) {
		this.camisa = camisa;
	}
	
	@ManyToOne	
	public Selecao getSelecao() {
		return selecao;
	}
	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
