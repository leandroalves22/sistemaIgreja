package bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import modelo.Usuario;


@SuppressWarnings("deprecation")
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
	
	private Usuario usuario;
	private Usuario usuarioLogado;
	
	@PostConstruct
	public void construct(){
		usuario = new Usuario();
		usuarioLogado = new Usuario();		
	}	

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}


	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	

	
	public String logar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {			
			usuarioLogado = new UsuarioDao().logar(usuario);			
			if(usuarioLogado!=null){
				HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
				HttpSession session = request.getSession(true);
				session.setAttribute("usuarioLogado", usuarioLogado);				
				return "/logado/inicial.jsf?faces-redirect=true";
				
			} else{
				usuario = new Usuario();
				throw new Exception("Acesso Negado");
			}
			
		} catch (Exception e) {
			fc.addMessage("formLogin", new FacesMessage(e.getMessage()));
		}
		return null;
	}
	
	public String deslogar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("usuarioLogado");
			session.invalidate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/login.jsf?faces-redirect=true";
	}
	
	public void filtrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
			HttpSession session = request.getSession();
			if(session.getAttribute("usuarioLogado")==null){
				fc.getExternalContext().redirect("login.jsf?erro=true");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
