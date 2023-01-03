package modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Contato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idContato;
	@Column
	private String celular;
	@Column
	private String email;
	@OneToOne(mappedBy = "contato", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Membro membro;
	
	public Contato() {
		// TODO Auto-generated constructor stub
	}

	public Contato(Integer idContato, String celular, String email) {
		super();
		this.idContato = idContato;
		this.celular = celular;
		this.email = email;
	}

	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}		

}
