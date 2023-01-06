package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dao.EntradaDao;
import modelo.Entrada;

@SuppressWarnings("deprecation")
@ManagedBean(name = "entradaBean")
@ApplicationScoped
public class EntradaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Entrada entradaEdicao;
	private Entrada entradaSelecao;
	private List<Entrada> todasEntradas;
	private EntradaDao entradaDao;
	
	@PostConstruct
	public void construct() {
		entradaEdicao = new Entrada();
		entradaSelecao = new Entrada();
		entradaDao = new EntradaDao();
	}

	public Entrada getEntradaEdicao() {
		return entradaEdicao;
	}

	public void setEntradaEdicao(Entrada entradaEdicao) {
		this.entradaEdicao = entradaEdicao;
	}

	public Entrada getEntradaSelecao() {
		return entradaSelecao;
	}

	public void setEntradaSelecao(Entrada entradaSelecao) {
		this.entradaSelecao = entradaSelecao;
	}

	public List<Entrada> getTodasEntradas() {
		todasEntradas = entradaDao.todasEntradas();
		return todasEntradas;
	}

	public void setTodasEntradas(List<Entrada> todasEntradas) {
		this.todasEntradas = todasEntradas;
	}

	public EntradaDao getEntradaDao() {
		return entradaDao;
	}

	public void setEntradaDao(EntradaDao entradaDao) {
		this.entradaDao = entradaDao;
	}
	
	public void preparaCadastro() {
		entradaEdicao = new Entrada();
		entradaSelecao = new Entrada();
		entradaDao = new EntradaDao();
	}
	
	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();
		
		try {
			entradaDao.create(entradaEdicao);
			todasEntradas = entradaDao.todasEntradas();
			rc.execute("PF('janelaCadastro').hide()");
			fc.addMessage("formMembro", new FacesMessage("Entrada Cadastrada Com Sucesso"));
			
		} catch (Exception e) {
			fc.addMessage("formMembro", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
				
		try {
			entradaDao.update(entradaEdicao);
			todasEntradas = entradaDao.todasEntradas();
			fc.addMessage("formMembro", new FacesMessage("Entrada Atualizada Com Sucesso"));
			
		} catch (Exception e) {
			fc.addMessage("formMembro", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			entradaDao.delete(entradaSelecao);
			todasEntradas = entradaDao.todasEntradas();
			fc.addMessage("formMembro", new FacesMessage("Entrada Removida Com Sucesso"));
			
		} catch (Exception e) {
			fc.addMessage("formMembro", new FacesMessage("Erro!" + e.getMessage()));
		}
	}	

}
