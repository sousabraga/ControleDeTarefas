package br.com.controledetarefas.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controledetarefas.dao.TarefaDAO;
import br.com.controledetarefas.model.Tarefa;
import br.com.controledetarefas.util.ManagerFactoryJPA;

@ManagedBean
public class TarefaBean {

	private Tarefa tarefa = new Tarefa();
	private TarefaDAO dao = new TarefaDAO();
	private DataModel<Tarefa> tarefas;
	
	public Tarefa getTarefa() {
		return this.tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public String adiciona(Tarefa tarefa) {
		dao.adiciona(tarefa);
		return "listaTarefas?faces-redirect=true";
	}
	
	public DataModel<Tarefa> getTarefas() {
		if (this.tarefas == null) 
			this.tarefas = dao.getTarefas();

		return this.tarefas;
	}
	
	public void selecionarRegistro() {
		this.tarefa = this.tarefas.getRowData();
	}
	
	public String altera(Tarefa tarefa) {
		dao.altera(tarefa);
		return "listaTarefas?faces-redirect=true";
	}
	
	public String delete(Tarefa tarefa) {
		dao.delete(tarefa);
		return "listaTarefas?faces-redirect=true";
	}
}
