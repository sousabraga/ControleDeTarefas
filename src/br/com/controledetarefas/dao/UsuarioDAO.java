package br.com.controledetarefas.dao;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.controledetarefas.model.Usuario;
import br.com.controledetarefas.util.ManagerFactoryJPA;

public class UsuarioDAO {
	
	public Usuario autenticarUsuario(Usuario usuario) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("SELECT a FROM Usuario a WHERE a.login = :loginUsuario AND a.senha = :senhaUsuario", Usuario.class);
		query.setParameter("loginUsuario", usuario.getLogin());
		query.setParameter("senhaUsuario", usuario.getSenha());
		
		Usuario usuarioLogado = (Usuario) query.getSingleResult();;
		
		manager.close();
		
		return usuarioLogado;
	}
	
	public void adiciona(Usuario usuario) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public DataModel<Usuario> getUsuarios() {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		DataModel<Usuario> usuarios = new ListDataModel<>(manager.createQuery("SELECT a FROM Usuario a", Usuario.class).getResultList());
		manager.close();
			
		return usuarios;
	}
	
	public void altera(Usuario usuario) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		usuario = manager.merge(usuario);
		manager.persist(usuario);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void delete(Usuario usuario) {
		EntityManager manager = ManagerFactoryJPA.getEntityManager();
		manager.getTransaction().begin();
		usuario = manager.merge(usuario);
		manager.remove(usuario);
		manager.getTransaction().commit();
		manager.close();
	}
	
}
