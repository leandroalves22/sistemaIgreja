package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dao.BemDao;
import modelo.Bem;

@SuppressWarnings("deprecation")
@ManagedBean(name = "bemBean")
@ApplicationScoped
public class BemBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Bem bemEdicao;
	private Bem bemSelecao;
	private BemDao bemDao;
	private List<Bem> todosBens;
	private Integer contaBens;
	
	@PostConstruct
	public void construct() {
		bemEdicao = new Bem();
		bemSelecao = new Bem();
		bemDao = new BemDao();
	}

	public Bem getBemEdicao() {
		return bemEdicao;
	}

	public void setBemEdicao(Bem bemEdicao) {
		this.bemEdicao = bemEdicao;
	}

	public Bem getBemSelecao() {
		return bemSelecao;
	}

	public void setBemSelecao(Bem bemSelecao) {
		this.bemSelecao = bemSelecao;
	}

	public BemDao getBemDao() {
		return bemDao;
	}

	public void setBemDao(BemDao bemDao) {
		this.bemDao = bemDao;
	}

	public List<Bem> getTodosBens() {
		todosBens = bemDao.todosBens();
		return todosBens;
	}

	public void setTodosBens(List<Bem> todosBens) {
		this.todosBens = todosBens;
	}	
	
	public Integer getContaBens() {
		contaBens = bemDao.contaBens();
		return contaBens;
	}

	public void setContaBens(Integer contaBens) {
		this.contaBens = contaBens;
	}	

	public void preparaCadastro() {
		bemEdicao = new Bem();
		bemSelecao = new Bem();
		bemDao = new BemDao();
	}
	
	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();
		
		try {
			bemDao.create(bemEdicao);
			todosBens = bemDao.todosBens();
			contaBens = bemDao.contaBens();
			rc.execute("PF('janelaCadastro'.hide()");
			fc.addMessage("formBem", new FacesMessage("Bem Cadastrado Com Sucesso!"));
			
		} catch (Exception e) {
			construct();
			fc.addMessage("formBem", new FacesMessage("Erro" + e.getMessage()));
		}
	}
	
	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			bemDao.update(bemEdicao);
			todosBens = bemDao.todosBens();
			fc.addMessage("formBem", new FacesMessage("Bem Atualizado Com Sucesso!"));					
			
		} catch (Exception e) {
			fc.addMessage("formBem", new FacesMessage("Erro!" +  e.getMessage()));
		}
	}
	
	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			if (bemSelecao.getNota()==null) {
				bemDao.delete(bemSelecao);
				todosBens = bemDao.todosBens();
				contaBens = bemDao.contaBens();
				fc.addMessage("formBem", new FacesMessage("Bem Excluído Com Sucesso!"));
				
			} else {
				fc.addMessage("formBem", new FacesMessage("Bem Está Associado A Uma Nota Fiscal!"));
			}
						
			
		} catch (Exception e) {
			fc.addMessage("formBem", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
}
