package br.com.controledetarefas.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controledetarefas.model.Tarefa;
import br.com.controledetarefas.util.ManagerFactoryJPA;

@ManagedBean
public class TarefaBean {

	private Tarefa tarefa = new Tarefa();
	private DataModel<Tarefa> tarefas;
	
	public Tarefa getTarefa() {
		return this.tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public String adiciona(Tarefa tarefa) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		manager.close();
		return "listaTarefas?faces-redirect=true";
	}
	
	public DataModel<Tarefa> getTarefas() {
		if (this.tarefas == null) {
			EntityManager manager = ManagerFactoryJPA.getEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("SELECT a FROM Tarefa a", Tarefa.class);
			this.tarefas = new ListDataModel<Tarefa>(query.getResultList());
			manager.close();
		}
		
		return this.tarefas;
	}
	
	public void selecionarRegistro() {
		this.tarefa = this.tarefas.getRowData();
	}
	
	public String altera(Tarefa tarefa) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		tarefa = manager.merge(tarefa);
		manager.persist(tarefa);
		manager.getTransaction().commit();
		manager.close();
		return "listaTarefas?faces-redirect=true";
	}
	
	public String delete(Tarefa tarefa) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		tarefa = manager.merge(tarefa);
		manager.remove(tarefa);
		manager.getTransaction().commit();
		manager.close();
		return "listaTarefas?faces-redirect=true";
	}
}
