package bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dao.UsuarioDao;
import modelo.Usuario;

@SuppressWarnings("deprecation")
@ManagedBean(name = "usuarioBean")
@ApplicationScoped
public class UsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuarioEdicao;
	private Usuario usuarioSelecao;	
	private UsuarioDao usuarioDao;
	private List<Usuario> todosUsuario;
	private Integer contaUsuario;
	
	
	@PostConstruct
	public void construct(){
		usuarioEdicao = new Usuario();
		usuarioSelecao = new Usuario();		
		usuarioDao = new UsuarioDao();		
	}	
	

	public Usuario getUsuarioEdicao() {
		return usuarioEdicao;
	}


	public void setUsuarioEdicao(Usuario usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}


	public Usuario getUsuarioSelecao() {
		return usuarioSelecao;
	}


	public void setUsuarioSelecao(Usuario usuarioSelecao) {
		this.usuarioSelecao = usuarioSelecao;
	}


	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}


	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}


	public List<Usuario> getTodosUsuario() {
		todosUsuario = usuarioDao.listaTodos();
		return todosUsuario;
	}

	public void setTodosUsuario(List<Usuario> todasUsuario) {
		this.todosUsuario = todasUsuario;
	}	
	
	public Integer getContaUsuario() {
		contaUsuario = usuarioDao.contaUsuario();
		return contaUsuario;
	}


	public void setContaUsuario(Integer contaUsuario) {
		this.contaUsuario = contaUsuario;
	}


	public void preparaCadastro(){
		usuarioEdicao = new Usuario();
		usuarioSelecao = new Usuario();		
		usuarioDao = new UsuarioDao();	
	}	
	
	public void salvar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();
		try {
			usuarioDao.create(usuarioEdicao);
			todosUsuario = usuarioDao.listaTodos();	
			contaUsuario = usuarioDao.contaUsuario();
			rc.execute("PF('janelaCadastro').hide()");				
			fc.addMessage("formUsuario", new FacesMessage("Usuário Cadastrado com Sucesso!"));		
			
		} catch (Exception e) {
			construct();
			fc.addMessage("formUsuario", new FacesMessage("Erro! " + e.getMessage()));
		}
	}
	
	public void editar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {			
			usuarioDao.update(usuarioEdicao);
			todosUsuario = usuarioDao.listaTodos();						
			fc.addMessage("formUsuario", new FacesMessage("Usuário Atualizado Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formUsuario", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void excluir(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			usuarioDao.delete(usuarioSelecao);
			todosUsuario = usuarioDao.listaTodos();
			contaUsuario = usuarioDao.contaUsuario();
			fc.addMessage("formUsuario", new FacesMessage("Usuário Excluído Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formUsuario", new FacesMessage("Erro!" + e.getMessage()));
		}
	}

}
