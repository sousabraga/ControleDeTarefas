package br.com.controledetarefas.dao;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;

import br.com.controledetarefas.model.Tarefa;
import br.com.controledetarefas.util.ManagerFactoryJPA;

public class TarefaDAO {

	public void adiciona(Tarefa tarefa) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(tarefa);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public DataModel<Tarefa> getTarefas() {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		DataModel<Tarefa> tarefas = new ListDataModel<>(manager.createQuery("SELECT a FROM Tarefa a", Tarefa.class).getResultList());
		manager.close();
		
		return tarefas;
	}
	
	public void altera(Tarefa tarefa) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		tarefa = manager.merge(tarefa);
		manager.persist(tarefa);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void delete(Tarefa tarefa) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		tarefa = manager.merge(tarefa);
		manager.remove(tarefa);
		manager.getTransaction().commit();
		manager.close();
	}
}
