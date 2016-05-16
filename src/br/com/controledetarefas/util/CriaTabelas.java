package br.com.controledetarefas.util;

import javax.persistence.EntityManager;

public class CriaTabelas {

	public static void main(String[] args) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.close();
	}
	
}
