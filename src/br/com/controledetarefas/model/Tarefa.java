package br.com.controledetarefas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sun.istack.internal.NotNull;

@Entity
public class Tarefa {

	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	private String titulo;

	@NotNull
	private String descricao;
	
	@NotNull
	private Date dataInicio;
	
	@NotNull
	private Date dataPrazo;
	
	private Date dataFinalizacao;
	
	@ManyToOne
	private Usuario usuario;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getDataInicio() {
		return this.dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataPrazo() {
		return this.dataPrazo;
	}
	
	public void setDataPrazo(Date dataPrazo) {
		this.dataPrazo = dataPrazo;
	}
	
	public Date getDataFinalizacao() {
		return this.dataFinalizacao;
	}
	
	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}







