package br.com.controledetarefas.filter;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*")
public class AutenticacaoFilter implements Filter {

	@Override
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		if (session.getAttribute("usuarioLogado") != null || req.getRequestURI().endsWith("login.xhtml") 
				|| req.getRequestURI().endsWith("index.xhtml") || req.getRequestURI().endsWith("resources")) {
			
			chain.doFilter(request, response);
		} else {
			FacesContext.getCurrentInstance().addMessage("Autenticação", new FacesMessage("Você deve efetuar o login."));
			res.sendRedirect("/ControleDeTarefas/login.xhtml");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
