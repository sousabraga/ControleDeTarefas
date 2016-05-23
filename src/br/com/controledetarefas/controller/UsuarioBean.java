package br.com.controledetarefas.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controledetarefas.model.Usuario;
import br.com.controledetarefas.util.ManagerFactoryJPA;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private DataModel<Usuario> usuarios;
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String adiciona(Usuario usuario) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
		return "listaUsuarios?faces-redirect=true";
	}
	
	public DataModel<Usuario> getUsuarios() {
		if (this.usuarios == null) {
			EntityManager manager = ManagerFactoryJPA.getEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("SELECT a FROM Usuario a", Usuario.class);
			this.usuarios = new ListDataModel<Usuario>(query.getResultList());
			manager.close();
		}
			
		return this.usuarios;
	}
	
	public void selecionarRegistro() {
		this.usuario = this.usuarios.getRowData();
	}
	
	public String altera(Usuario usuario) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		usuario = manager.merge(usuario);
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
		return "listaUsuarios?faces-redirect=true";
	}
	
	public String delete(Usuario usuario) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		usuario = manager.merge(usuario);
		manager.remove(usuario);
		manager.getTransaction().commit();
		manager.close();
		return "listaUsuarios?faces-redirect=true";
	}
	
}
