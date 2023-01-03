package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Membro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idMembro;
	@Column
	private String nomeMembro;
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@Column
	private String cpf;
	@Column
	private String ativo; // Inserir SIM ou NÃO para identificar se o membro está ativo, campo de seleção
	@Column
	private String motivoDesligamento; // Se campo ativo for igual a NÃO, informar o motivo aqui
	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	@OneToOne
	@JoinColumn(name = "id_contato")
	private Contato contato;

	public Membro() {
		// TODO Auto-generated constructor stub
	}

	public Membro(Integer idMembro, String nomeMembro, Date dataNascimento, String cpf, String ativo, String motivoDesligamento) {
		this.idMembro = idMembro;
		this.nomeMembro = nomeMembro;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.ativo = ativo;
		this.motivoDesligamento = motivoDesligamento;
	}

	public Integer getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(Integer idMembro) {
		this.idMembro = idMembro;
	}

	public String getNomeMembro() {
		return nomeMembro;
	}

	public void setNomeMembro(String nomeMembro) {
		this.nomeMembro = nomeMembro;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getMotivoDesligamento() {
		return motivoDesligamento;
	}

	public void setMotivoDesligamento(String motivoDesligamento) {
		this.motivoDesligamento = motivoDesligamento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
