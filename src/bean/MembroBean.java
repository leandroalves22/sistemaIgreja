package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dao.ContatoDao;
import dao.EnderecoDao;
import dao.MembroDao;
import modelo.Contato;
import modelo.Endereco;
import modelo.Membro;

@SuppressWarnings("deprecation")
@ManagedBean(name = "membroBean")
@ApplicationScoped
public class MembroBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Membro membroEdicao;
	private Membro membroSelecao;
	private MembroDao membroDao;
	private List<Membro> todosMembros;
	private Contato contatoEdicao;
	private ContatoDao contatoDao;
	private Endereco enderecoEdicao;
	private EnderecoDao enderecoDao;
	private Integer contaMembros;
	private List<Membro> aniversariantes;
	
	@PostConstruct
	public void construct() {
		membroEdicao = new Membro();
		membroSelecao = new Membro();
		membroDao = new MembroDao();
		contatoEdicao = new Contato();
		contatoDao = new ContatoDao();
		enderecoEdicao = new Endereco();
		enderecoDao = new EnderecoDao();		
	}

	public Membro getMembroEdicao() {
		return membroEdicao;
	}

	public void setMembroEdicao(Membro membroEdicao) {
		this.membroEdicao = membroEdicao;
	}

	public Membro getMembroSelecao() {
		return membroSelecao;
	}

	public void setMembroSelecao(Membro membroSelecao) {
		this.membroSelecao = membroSelecao;
	}

	public MembroDao getMembroDao() {
		return membroDao;
	}

	public void setMembroDao(MembroDao membroDao) {
		this.membroDao = membroDao;
	}

	public List<Membro> getTodosMembros() {
		todosMembros = membroDao.todosMembros();
		return todosMembros;
	}

	public void setTodosMembros(List<Membro> todosMembros) {
		this.todosMembros = todosMembros;
	}

	public Contato getContatoEdicao() {
		return contatoEdicao;
	}

	public void setContatoEdicao(Contato contatoEdicao) {
		this.contatoEdicao = contatoEdicao;
	}

	public ContatoDao getContatoDao() {
		return contatoDao;
	}

	public void setContatoDao(ContatoDao contatoDao) {
		this.contatoDao = contatoDao;
	}

	public Endereco getEnderecoEdicao() {
		return enderecoEdicao;
	}

	public void setEnderecoEdicao(Endereco enderecoEdicao) {
		this.enderecoEdicao = enderecoEdicao;
	}

	public EnderecoDao getEnderecoDao() {
		return enderecoDao;
	}

	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
	}	
	
	public Integer getContaMembros() {
		contaMembros = membroDao.contaMembro();
		return contaMembros;
	}

	public void setContaMembros(Integer contaMembros) {
		this.contaMembros = contaMembros;
	}	

	public List<Membro> getAniversariantes() {
		aniversariantes = membroDao.aniversariantes();
		return aniversariantes;
	}

	public void setAniversariantes(List<Membro> aniversariantes) {
		this.aniversariantes = aniversariantes;
	}

	public void preparaCadastro() {
		membroEdicao = new Membro();
		membroSelecao = new Membro();
		membroDao = new MembroDao();
		contatoEdicao = new Contato();
		contatoDao = new ContatoDao();
		enderecoEdicao = new Endereco();
		enderecoDao = new EnderecoDao();
	}
	
	public void preparaEdicao() {
		contatoEdicao = membroEdicao.getContato();
		enderecoEdicao = membroEdicao.getEndereco();
	}
	
	public void salvar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		RequestContext rc = RequestContext.getCurrentInstance();
		
		try {
			membroEdicao.setContato(contatoEdicao);
			membroEdicao.setEndereco(enderecoEdicao);
			contatoDao.create(contatoEdicao);
			enderecoDao.create(enderecoEdicao);
			membroDao.create(membroEdicao);
			todosMembros = membroDao.todosMembros();
			contaMembros = membroDao.contaMembro();
			rc.execute("PF('janelaCadastro').hide()");
			fc.addMessage("formMembro", new FacesMessage("Membro Cadastrado Com Sucesso"));
			
		} catch (Exception e) {
			fc.addMessage("formMembro", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void editar() {
		FacesContext fc = FacesContext.getCurrentInstance();
				
		try {
			membroEdicao.setContato(contatoEdicao);
			membroEdicao.setEndereco(enderecoEdicao);
			contatoDao.update(contatoEdicao);
			enderecoDao.update(enderecoEdicao);
			membroDao.update(membroEdicao);
			todosMembros = membroDao.todosMembros();
			fc.addMessage("formMembro", new FacesMessage("Membro Atualizado Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formMembro", new FacesMessage("Erro!" + e.getMessage()));
		}
	}
	
	public void remover() {
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			membroDao.delete(membroSelecao);
			todosMembros = membroDao.todosMembros();
			contaMembros = membroDao.contaMembro();
			fc.addMessage("formMembro", new FacesMessage("Membro Excluído Com Sucesso!"));
			
		} catch (Exception e) {
			fc.addMessage("formMembro", new FacesMessage("Erro!" + e.getMessage()));
		}
		
	}	

}
