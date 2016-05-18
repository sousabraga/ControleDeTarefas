package br.com.controledetarefas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controledetarefas.model.Tarefa;
import br.com.controledetarefas.util.ManagerFactoryJPA;

@ManagedBean
public class TarefaBean {

	private Tarefa tarefa = new Tarefa();
	private List<Tarefa> tarefas;
	
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
	
	public List<Tarefa> getTarefas() {
		if (this.tarefas == null) {
			EntityManager manager = ManagerFactoryJPA.getEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("SELECT a FROM Tarefa a", Tarefa.class);
			this.tarefas = query.getResultList();
			manager.close();
		}
		
		return this.tarefas;
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
