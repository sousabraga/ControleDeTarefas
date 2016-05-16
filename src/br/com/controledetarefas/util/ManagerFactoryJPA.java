package br.com.controledetarefas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManagerFactoryJPA {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("db_tarefas");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
