package br.com.controledetarefas.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import br.com.controledetarefas.dao.UsuarioDAO;
import br.com.controledetarefas.model.Usuario;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private UsuarioDAO dao = new UsuarioDAO();
	private DataModel<Usuario> usuarios;
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String adiciona(Usuario usuario) {
		dao.adiciona(usuario);
		return "listaUsuarios?faces-redirect=true";
	}
	
	public DataModel<Usuario> getUsuarios() {
		if (this.usuarios == null) 
			this.usuarios = dao.getUsuarios();
			
		return this.usuarios;
	}
	
	public void selecionarRegistro() {
		this.usuario = this.usuarios.getRowData();
	}
	
	public String altera(Usuario usuario) {
		dao.altera(usuario);
		return "listaUsuarios?faces-redirect=true";
	}
	
	public String delete(Usuario usuario) {
		dao.delete(usuario);
		return "listaUsuarios?faces-redirect=true";
	}
	
	public String autenticarUsuario(Usuario usuario) {
		Usuario usuarioLogado = dao.autenticarUsuario(usuario);
		
		if (usuarioLogado != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuarioLogado);
			return "listaTarefas?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage("Error", new FacesMessage("Usuário e/ou senha incorretos!"));
			return "login";
		}
	}
	
}
