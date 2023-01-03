package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idNota;
	@Column
	private String numeroNota;
	@Column
	private String loja;
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	@Column
	private Double valorTotalNota;
	@OneToMany(mappedBy = "nota", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Bem> bens;

	public Nota() {

	}	

	public Nota(Integer idNota, String numeroNota, String loja, Date dataCompra, Double valorTotalNota,
			List<Bem> bens) {
		super();
		this.idNota = idNota;
		this.numeroNota = numeroNota;
		this.loja = loja;
		this.dataCompra = dataCompra;
		this.valorTotalNota = valorTotalNota;
		this.bens = bens;
	}
	
	public Integer getIdNota() {
		return idNota;
	}

	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Double getValorTotalNota() {
		return valorTotalNota;
	}

	public void setValorTotalNota(Double valorTotalNota) {
		this.valorTotalNota = valorTotalNota;
	}

	public List<Bem> getBens() {
		return bens;
	}

	public void setBens(List<Bem> bens) {
		this.bens = bens;
	}

}
