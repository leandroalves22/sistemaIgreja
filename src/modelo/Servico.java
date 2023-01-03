package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServico;
	@Column
	private String documentoContratado;
	@Column
	private String nomeContratado;
	@Column
	private Double valorServico;
	@Temporal(TemporalType.DATE)
	private Date dataServico;
	@Column
	private String descricaoServico;

	public Servico() {
		
	}

	public Servico(Integer idServico, String documentoContratado, String nomeContratado, Double valorServico,
			Date dataServico, String descricaoServico) {
		this.idServico = idServico;
		this.documentoContratado = documentoContratado;
		this.nomeContratado = nomeContratado;
		this.valorServico = valorServico;
		this.dataServico = dataServico;
		this.descricaoServico = descricaoServico;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getDocumentoContratado() {
		return documentoContratado;
	}

	public void setDocumentoContratado(String documentoContratado) {
		this.documentoContratado = documentoContratado;
	}

	public String getNomeContratado() {
		return nomeContratado;
	}

	public void setNomeContratado(String nomeContratado) {
		this.nomeContratado = nomeContratado;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}

	public Date getDataServico() {
		return dataServico;
	}

	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

}
