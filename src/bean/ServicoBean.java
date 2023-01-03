package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dao.ServicoDao;
import modelo.Servico;

@SuppressWarnings("deprecation")
@ManagedBean(name = "servicoBean")
@ApplicationScoped
public class ServicoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Servico servicoEdicao;
	private Servico servicoSelecao;
	private List<Servico> todosServicos;
	private ServicoDao servicoDao;
	private String documentoPrestador;
	
	@PostConstruct
	public void construct() {
		servicoEdicao = new Servico();
		servicoSelecao = new Servico();
		servicoDao = new ServicoDao();
	}

	public Servico getServicoEdicao() {
		return servicoEdicao;
	}

	public void setServicoEdicao(Servico servicoEdicao) {
		this.servicoEdicao = servicoEdicao;
	}

	public Servico getServicoSelecao() {
		return servicoSelecao;
	}

	public void setServicoSelecao(Servico servicoSelecao) {
		this.servicoSelecao = servicoSelecao;
	}

	public List<Servico> getTodosServicos() {
		todosServicos = servicoDao.todosServicos();
		return todosServicos;
	}

	public void setTodosServicos(List<Servico> todosServicos) {
		this.todosServicos = todosServicos;
	}

	public ServicoDao getServicoDao() {
		return servicoDao;
	}

	public void setServicoDao(ServicoDao servicoDao) {
		this.servicoDao = servicoDao;
	}
	
	public String getDocumentoPrestador() {
		return documentoPrestador;
	}

	public void setDocumentoPrestador(String documentoPrestador) {
		this.documentoPrestador = documentoPrestador;
	}

	public void preparaCadastro() {
		servicoEdicao = new Servico();
		servicoSelecao = new Servico();
		servicoDao = new ServicoDao();
	}
	
	public void selecionaPrestadorPF() {
		documentoPrestador = "999.999.999-99";
	}
	
	public void selecionaPrestadorPJ() {
		documentoPrestador = "99.999.999/9999-99";
	}
	
	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();
		
		try {
			servicoDao.create(servicoEdicao);
			todosServicos = servicoDao.todosServicos();
			servicoEdicao = new Servico();
			rc.execute("PF('janelaCadastro').hide()");
			rc.execute("PF('janelaTipo').hide()");
			fc.addMessage("formServico", new FacesMessage("Serviço Cadastrado Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formServico", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void atualizar() {
		FacesContext fc = FacesContext.getCurrentInstance();
				
		try {
			servicoDao.update(servicoEdicao);
			todosServicos = servicoDao.todosServicos();
			servicoEdicao = new Servico();			
			fc.addMessage("formServico", new FacesMessage("Serviço Atualizado Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formServico", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
				
		try {
			servicoDao.delete(servicoSelecao);
			todosServicos = servicoDao.todosServicos();
			servicoEdicao = new Servico();			
			fc.addMessage("formServico", new FacesMessage("Serviço Removido Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formServico", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	

}
