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
public class Entrada implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEntrada;
	@Column
	private String tipoEntrada;
	@Column
	private Double valorEntrada;
	@Temporal(TemporalType.DATE)
	private Date dataEntrada;
	
	public Entrada() {
		// TODO Auto-generated constructor stub
	}

	public Entrada(Integer idEntrada, String tipoEntrada, Double valorEntrada, Date dataEntrada) {
		this.idEntrada = idEntrada;
		this.tipoEntrada = tipoEntrada;
		this.valorEntrada = valorEntrada;
		this.dataEntrada = dataEntrada;
	}

	public Integer getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
	}

	public String getTipoEntrada() {
		return tipoEntrada;
	}

	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}

	public Double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(Double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
}
