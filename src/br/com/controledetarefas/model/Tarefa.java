package br.com.controledetarefas.model;

import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tarefa {

	@Id @GeneratedValue
	private Long id;
	
	private String titulo;
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataPrazo;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataFinalizacao;
	
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
	
	public Calendar getDataInicio() {
		return this.dataInicio;
	}
	
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Calendar getDataPrazo() {
		return this.dataPrazo;
	}
	
	public void setDataPrazo(Calendar dataPrazo) {
		this.dataPrazo = dataPrazo;
	}
	
	public Calendar getDataFinalizacao() {
		return this.dataFinalizacao;
	}
	
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}







