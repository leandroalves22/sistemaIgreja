package bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dao.BemDao;
import dao.NotaDao;
import modelo.Bem;
import modelo.Nota;

@SuppressWarnings("deprecation")
@ManagedBean(name = "notaBean")
@ApplicationScoped
public class NotaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Nota notaEdicao;
	private Nota notaSelecao;
	private List<Nota> todasNotas;
	private NotaDao notaDao;
	private Bem bemEdicao;
	private Bem bemSelecao;
	private BemDao bemDao;
	private List<Bem> todosBensNota = new ArrayList<>();
	private Integer contaNotas;
	
	@PostConstruct
	public void construct() {
		notaEdicao = new Nota();
		notaSelecao = new Nota();
		notaDao = new NotaDao();
		bemEdicao = new Bem();
		bemSelecao = new Bem();
		bemDao = new BemDao();
	}

	public Nota getNotaEdicao() {
		return notaEdicao;
	}

	public void setNotaEdicao(Nota notaEdicao) {
		this.notaEdicao = notaEdicao;
	}

	public Nota getNotaSelecao() {
		return notaSelecao;
	}

	public void setNotaSelecao(Nota notaSelecao) {
		this.notaSelecao = notaSelecao;
	}

	public List<Nota> getTodasNotas() {
		todasNotas = notaDao.todasNotas();
		return todasNotas;
	}

	public void setTodasNotas(List<Nota> todasNotas) {
		this.todasNotas = todasNotas;
	}

	public NotaDao getNotaDao() {
		return notaDao;
	}

	public void setNotaDao(NotaDao notaDao) {
		this.notaDao = notaDao;
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

	public List<Bem> getTodosBensNota() {		
		return todosBensNota;
	}

	public void setTodosBensNota(List<Bem> todosBensNota) {
		this.todosBensNota = todosBensNota;
	}

	public Integer getContaNotas() {
		contaNotas = notaDao.contaNota();
		return contaNotas;
	}

	public void setContaNotas(Integer contaNotas) {
		this.contaNotas = contaNotas;
	}

	public void preparaCadastro() {
		notaEdicao = new Nota();
		notaSelecao = new Nota();
		notaDao = new NotaDao();
		bemEdicao = new Bem();
		bemSelecao = new Bem();
		bemDao = new BemDao();
		todosBensNota = new ArrayList<>();
	}	
	
	public void preparaEdicao() {
		todosBensNota = notaEdicao.getBens();
	}
	
	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();
		
		try {			
			notaDao.create(notaEdicao);
			for (Bem bem : todosBensNota) {
				Bem b = new Bem();
				b = bem;
				b.setNota(notaEdicao);
				bemDao.create(b);
			}			
			bemEdicao = new Bem();
			todasNotas = notaDao.todasNotas();	
			contaNotas = notaDao.contaNota();
			todosBensNota.clear();
			rc.execute("PF('janelaCadastro').hide()");
			fc.addMessage("formNota", new FacesMessage("Nota Cadastrada Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formNota", new FacesMessage("Erro!" + e.getMessage()));
		}		
	}
	
	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			notaDao.update(notaEdicao);
			todasNotas = notaDao.todasNotas();
			fc.addMessage("formNota", new FacesMessage("Nota Atualizada Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formNota", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			notaDao.delete(notaSelecao);
			todasNotas = notaDao.todasNotas();
			contaNotas = notaDao.contaNota();
			fc.addMessage("formNota", new FacesMessage("Nota Excluída Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formNota", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void preparaCadastroBem() {	
		bemDao = new BemDao();
		bemEdicao = new Bem();
		bemSelecao = new Bem();
	}		
	
	public void InseriBensLista() {	
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();
		
		try {
			todosBensNota.add(bemEdicao);
			bemEdicao = new Bem();
			rc.execute("PF('janelaCadastroProduto').hide()");
			fc.addMessage("formNota", new FacesMessage("Produto Inserido Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formNota", new FacesMessage("Erro!" + e.getMessage()));
		}
				
	}
	
	public void editaBensLista() {
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();
		
		try {
			bemDao.update(bemEdicao);
			todosBensNota = notaEdicao.getBens();
			bemEdicao = new Bem();
			rc.execute("PF('janelaEdicaoProduto').hide()");
			fc.addMessage("formNota", new FacesMessage("Produto Alterado Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formNota", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void InseriBensNovoLista() {	
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();
		
		try {
			todosBensNota.add(bemEdicao);			
			for (Bem bem : todosBensNota) {
				Bem b = new Bem();
				b = bem;
				if (b.getIdBem()==null) {
					b.setNota(notaEdicao);
					bemDao.create(b);
					
				} else {
					bemDao.update(b);
				}				
			}
			
			bemEdicao = new Bem();
			rc.execute("PF('janelaNovoProduto').hide()");
			fc.addMessage("formNota", new FacesMessage("Produto Inserido Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formNota", new FacesMessage("Erro!" + e.getMessage()));
		}
				
	}	

}
