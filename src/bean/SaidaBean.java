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
import dao.SaidaDao;
import modelo.Entrada;
import modelo.Saida;

@SuppressWarnings("deprecation")
@ManagedBean(name = "saidaBean")
@ApplicationScoped
public class SaidaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Saida saidaEdicao;
	private Saida saidaSelecao;
	private List<Saida> todasSaidas;
	private SaidaDao saidaDao;

	@PostConstruct
	public void construct() {
		saidaEdicao = new Saida();
		saidaSelecao = new Saida();
		saidaDao = new SaidaDao();
	}

	public Saida getSaidaEdicao() {
		return saidaEdicao;
	}

	public void setSaidaEdicao(Saida saidaEdicao) {
		this.saidaEdicao = saidaEdicao;
	}

	public Saida getSaidaSelecao() {
		return saidaSelecao;
	}

	public void setSaidaSelecao(Saida saidaSelecao) {
		this.saidaSelecao = saidaSelecao;
	}

	public List<Saida> getTodasSaidas() {
		todasSaidas = saidaDao.todasSaidas();
		return todasSaidas;
	}

	public void setTodasSaidas(List<Saida> todasSaidas) {
		this.todasSaidas = todasSaidas;
	}

	public SaidaDao getSaidaDao() {
		return saidaDao;
	}

	public void setSaidaDao(SaidaDao saidaDao) {
		this.saidaDao = saidaDao;
	}
	
	public void preparaCadastro() {
		saidaEdicao = new Saida();
		saidaSelecao = new Saida();
		saidaDao = new SaidaDao();
	}

	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();

		try {
			saidaDao.create(saidaEdicao);
			todasSaidas = saidaDao.todasSaidas();
			rc.execute("PF('janelaCadastro').hide()");
			fc.addMessage("formMembro", new FacesMessage("Saída Cadastrada Com Sucesso"));

		} catch (Exception e) {
			fc.addMessage("formMembro", new FacesMessage("Erro!" + e.getMessage()));
		}
	}

	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			saidaDao.update(saidaEdicao);
			todasSaidas = saidaDao.todasSaidas();
			fc.addMessage("formMembro", new FacesMessage("Saída Atualizada Com Sucesso"));

		} catch (Exception e) {
			fc.addMessage("formMembro", new FacesMessage("Erro!" + e.getMessage()));
		}
	}

	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			saidaDao.delete(saidaSelecao);
			todasSaidas = saidaDao.todasSaidas();
			fc.addMessage("formMembro", new FacesMessage("Saída Removida Com Sucesso"));

		} catch (Exception e) {
			fc.addMessage("formMembro", new FacesMessage("Erro!" + e.getMessage()));
		}
	}

}
