package br.com.controledetarefas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controledetarefas.model.Usuario;
import br.com.controledetarefas.util.ManagerFactoryJPA;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public String adiciona(Usuario usuario) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
		return "listaUsuarios";
	}
	
	public List<Usuario> getUsuarios() {
		if (this.usuarios == null) {
			EntityManager manager = ManagerFactoryJPA.getEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("SELECT a FROM Usuario a", Usuario.class);
			this.usuarios = query.getResultList();
			manager.close();
		}
		
		return this.usuarios;
	}
	
	public String delete(Usuario usuario) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		usuario = manager.merge(usuario);
		manager.remove(usuario);
		manager.getTransaction().commit();
		manager.close();
		return "listaUsuarios";
	}
	
}
